<template>
    <div id="courseMsg">
        <teac-header :add1="0"></teac-header>
        <div class="add">
            <el-select v-model="value" placeholder="请选择">
                <el-option :value="item.major_id" v-for="item in majorList" :disabled="choseList.find((list)=>list.major_id===item.major_id)?true:false" :label="item.major_name"></el-option>
            </el-select>
            <el-button @click="addList" type="primary">选择</el-button>
            <div class="selected">
                <span style="margin-top: 15px">已选中:</span>
                <span v-for="item in choseList" :key="item.major_id" @click="deleteChose(item.major_id)" class="chose">{{item.major_name}}</span>
            </div>
            <button class="btn" @click="addStudent">添加学生</button>
        </div>
        <div class="table">
            <el-table
                    border
                    :data="tableData"
                    style="width: 100%">
                <el-table-column
                        prop="course_name"
                        label="科目"
                        width="190">
                </el-table-column>
                <el-table-column
                        prop="stu_id"
                        label="学号"
                        width="90">
                </el-table-column>
                <el-table-column
                        prop="stu_name"
                        label="姓名"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="dept_name"
                        label="学院">
                </el-table-column>
                <el-table-column
                        prop="major_name"
                        label="班级">
                </el-table-column>
                <el-table-column
                        prop="score"
                        label="分数">
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button size="mini"  type="success" @click="handleEdit(scope.$index, scope.row)">修改成绩</el-button>
                        <el-button size="mini"  type="danger" @click="handleDel(scope.row)">删除学生</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-dialog
                    title="修改成绩"
                    :visible.sync="dialogVisible"
                    width="30%"
                    :before-close="handleClose">
                <span>学生成绩:</span>
                <input type="text" v-model="score">
                <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="handle">确 定</el-button>
                  </span>
            </el-dialog>
        </div>
    </div>
</template>

<script>
    import {request} from "../util/request";
    export default {
        name: "courseMsg",
        components:{
            'teac-header':()=>import('../components/teaHeader.vue'),
        },
        data(){
            return{
                tableData:[],
                dialogVisible:false,
                openIndex:'',
                score:'',
                majorList:'',
                value:'',
                choseList:[],
                temp:0
            }
        },
        methods:{
            //打开修改
            handleEdit(index, row) {
                this.dialogVisible = true;
                this.openIndex=index;
            },
            //删除学生
            handleDel(row){
                let params={
                    stu_id:row.stu_id,
                    course_id:this.$route.params.course_id
                }
                request("delSelect", "get", params).then(
                    (res)=>{
                        this.temp++;
                    }
                )
            },
            //关闭修改
            handleClose(){
                this.dialogVisible = false
            },
            //确认修改
            handle(){
                let params={
                    stu_id:this.tableData[this.openIndex].stu_id,
                    score: this.score,
                    course_id:this.$route.params.course_id
                }
                request("updatescore", "get", params).then(
                    (res)=>{
                        if(res)
                            this.$router.go(0)
                    }
                )
            },
            //添加通知班级
            addList(){
                this.choseList.push(this.majorList.filter((res)=>{
                    return res.major_id===this.value;
                })[0]);
                this.value='';
            },
            //删除选中列表
            deleteChose(id){
                this.choseList=this.choseList.filter((item)=>{
                    return item.major_id!==id;
                })
            },
            //添加授课学生
            addStudent(){
                let idList=this.choseList.reduce((pre,todo)=>pre+todo.major_id+",",'');
                idList=idList.slice(0,idList.length-1);
                let params={
                    idList,
                    course_id:this.$route.params.course_id,
                }
                request("addSelectStu", "get", params).then(
                    (res)=>{
                        this.temp++;
                    }
                )
            }
        },
        created(){
            this.axios.all([
                request("selStuMsgByCourseId", "get", {course_id:this.$route.params.course_id}),
                request("selMajor", "get",{})
            ]).then(this.axios.spread((res1,res2)=>{
                this.tableData=res1;
                this.majorList=res2;
            }))
        },
        watch:{
            temp:function (val) {
                request("selStuMsgByCourseId", "get", {course_id:this.$route.params.course_id}).then((res)=>{
                        this.tableData=res;
                    }
                )
            }
        }
    }
</script>

<style scoped type="text/scss" lang="scss">
    #courseMsg{
        padding:0px 100px;
        overflow: hidden;
        .table{
            margin-top: 10px;
        }
        .add{
            padding: 5px;
            margin: 5px 0px;
            box-sizing: border-box;
            background-color: white;
            .btn{
                margin: 10px;
                background-color: #337ab7;
                color: white;
                width: 80px;
                height: 30px;
            }
            select{
                /*margin: 15px;*/
            }
        }
    }
</style>