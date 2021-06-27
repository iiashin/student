<template>
    <div id="AdminNoticeMsg">
        <button class="add" @click="addNotice">添加</button>
        <el-dialog
                title="发布通知"
                :visible.sync="dialogVisibleAdd"
                width="800px"
                :before-close="handleClose(dialogVisibleAdd)">
            <div class="addNotice">
                通知内容:
                <textarea placeholder="发布内容" v-model="content"></textarea></br>
                <el-select v-model="value" placeholder="请选择">
                    <el-option :value="item.major_id" v-for="item in majorList" :disabled="choseList.find((list)=>list.major_id===item.major_id)?true:false" :label="item.major_name"></el-option>
                </el-select>
                <el-button @click="addList" type="primary">选择</el-button>
                <div class="selected">
                    <span>已选中:</span>
                    <span v-for="item in choseList" :key="item.major_id" @click="deleteChose(item.major_id)" class="chose">{{item.major_name}}</span>
                </div>
                <el-button  type="success" class="addBtn" @click="releaseNotice()">确认发布</el-button>
            </div>
        </el-dialog>
        <el-table
                :data="noticeMsg"
                stripe
                border
                style="width: 950px">
            <el-table-column
                    prop="notice_id" width="180"
                    label="通知编号">
            </el-table-column>
            <el-table-column width="280"
                    prop="notice_content"
                    label="通知内容">
            </el-table-column>
            <el-table-column
                    prop="time" width="280"
                    label="发布时间">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" type="success" @click="handle(scope.row)">查看</el-button>
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog
                title="查看通知"
                :visible.sync="dialogVisible"
                width="600px"
                :before-close="handleClose(dialogVisible)">
            <div class="msg" v-if="openNotice">
                <div class="content">{{openNotice[0].notice_content}}</div>
                <div>通知班级:</div><span v-for="item in openNotice" :key="item.major_id">{{item.major_name}}</span>
            </div>
        </el-dialog>

    </div>
</template>

<script>
    import {request} from "../util/request";

    export default {
        name: "AdminNoticeMsg",
        data(){
            return{
                noticeMsg:[],
                dialogVisible:false,
                dialogVisibleAdd:false,
                openNotice:'',
                majorList:[],
                value:'',
                choseList:[],  //被选中的班级列表
                content:'',
                temp:1
            }
        },
        methods:{
            //查看通知
            handle(msg){
                request("selAllNoticeByNoticeId", "get", {id:msg.notice_id}).then((res)=>{
                    this.openNotice=res;
                })
                this.dialogVisible=true;
            },
            //关闭
            handleClose(flag){
                flag = false;
            },
            //添加通知
            addNotice(){
                this.dialogVisibleAdd=true;
            },
            //添加通知班级
            addList(){
                this.choseList.push(this.majorList.filter((res)=>{
                    return res.major_id===this.value;
                })[0]);
            },
            //删除选中列表
            deleteChose(id){
                this.choseList=this.choseList.filter((item)=>{
                    return item.major_id!==id;
                })
            },
            //发布通知
            releaseNotice(){
                let date=new Date();
                let year=date.getFullYear(),
                    month=(date.getMonth()+1).toString().padStart(2,0),
                    day=date.getDate().toString().padStart(2,0),
                    time=`${year}-${month}-${day}`;
                //批量通知
                let idList=this.choseList.reduce((pre,todo)=>pre+todo.major_id+",",'');
                idList=idList.slice(0,idList.length-1);
                request("addNotice", "get", {notice_content:this.content,time:time}).then((res)=>{
                    if(res){
                        request("insertSelect", "get", {idList:idList}).then((res)=>{
                            if(res){
                                this.dialogVisibleAdd=false;
                                this.temp++;
                            }
                        })
                    }
                });
            },
            //删除通知
            handleDelete(msg){
                request("deleteNoticeById", "get", {id:msg.notice_id}).then((res)=>{
                    if(res){
                        this.temp++;
                    }
                })
            }
        },
        watch:{
            temp:function (val) {
                request("selAllNotice", "get", {}).then((res)=>{
                    this.noticeMsg=res;
                })
            }
        },
        created(){
            this.axios.all([
                request("selAllNotice", "get", {}),
                request("selMajor", "get", {})
            ]).then(this.axios.spread((res1,res2)=>{
                this.noticeMsg=res1;
                this.majorList=res2;
            }))
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #AdminNoticeMsg{
        /*position:relative;*/
        ::v-deep .cell{
            overflow: hidden;
            white-space:nowrap;
            text-overflow: ellipsis;
        }
        .msg{
            .content{
                font-weight: bold;
                font-size: 18px;
                margin-bottom: 15px;
            }
        }
        .add{
            position: relative;
            height: 30px;
            width: 80px;
            margin-bottom: 10px;
            background-color: #0483d4;
            color: white;
            left: 850px;
        }
        .addNotice{
            overflow: hidden;
            width: 100%;
            box-sizing: border-box;
            padding: 20px;
            textarea{
                width: inherit;
                height: 100px;
                margin: 10px 0px;
            }
            button{
                margin-left: 10px;
            }
            .selected{
                margin-top: 5px;
                .chose{
                    margin-right: 5px;
                    font-weight: bold;
                }
            }
            .addBtn{
                margin-top: 10px;
                float: right;
            }
        }
    }
</style>