<template>
    <div id="stuContent">
        <div class="top">
            <img src="../assets/logo.jpg">
            <div class="msg">
                <div class="name">{{studentMsg.stu_id}}      {{studentMsg.stu_name}}</div>
                <div class="dept">信息工程学院 计算机科学与技术2班</div>
            </div>
        </div>
        <el-card class="box-card" shadow="hover">
            <div slot="header" class="clearfix">
                <span>课表</span>
                <el-button style="float: right; padding: 3px 0" type="text" @click="$router.push('/stucourse')">更多</el-button>
            </div>
            <div v-for="item in courseMsg.slice(0,5)" :key="item.course_id" class="text item">
                第{{item.classtime}}节--星期{{item.day | toDay}}--{{item.course_name }}--{{item.room}}--{{item.teac_name}}
            </div>
        </el-card>
        <el-card class="box-card" shadow="hover">
            <div slot="header" class="clearfix">
                <span>通知</span>
                <!--<el-button style="float: right; padding: 3px 0" type="text" >更多</el-button>-->
            </div>
            <div v-for="item in noticeMsg" :key="item.notice_id" class="text item" @click="openNotice(item.notice_id)">
                {{item.notice_content }}
            </div>
        </el-card>
        <el-card class="box-card" shadow="hover">
            <div slot="header" class="clearfix">
                <span>成绩</span>
                <!--<el-button style="float: right; padding: 3px 0" type="text">更多</el-button>-->
            </div>
            <div v-for="item in courseMsg.slice(0,5)" :key="item.course_id" class="text item">
                <div class="score">
                    <span>第{{item.term}}学期--{{item.course_name}}</span>
                    <span>{{item.score}}</span>
                </div>
            </div>
        </el-card>
        <el-dialog
                title="通知"
                :visible.sync="dialogVisible"
                width="600px">
            <div class="time" v-if="msg[0]">发布时间:{{msg[0].time}}</div>
            <div class="msg" v-if="msg[0]">
                {{msg[0].notice_content}}
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import {request} from "../util/request";

    export default {
        name: "stuContent",
        props:['num','stu_id'],    //父组件传过来
        data(){
          return{
              courseMsg:[],
              studentMsg:'',
              noticeMsg:[],
              dialogVisible:false,
              msg:''
          }
        },
        methods:{
            //获取课程信息
            get_course_Msg(){
                let params={
                    stu_id:this.stu_id,
                    term:this.num
                }
                request("selCourseMsgByStuId","get",params).then(
                    (res)=>{
                        this.courseMsg=res;
                    }
                )
            },
            //获取学生信息
            getStudentMsg(){
                this.id=localStorage.getItem("studentId");
                request("selStuMsgByStuId","get",{stu_id: this.id}).then(
                    (res)=>{
                        this.studentMsg=res[0];
                        this.getNoticeMsg();
                    }
                )
            },
            //获取通知信息
            getNoticeMsg(){
                request("queryAllNoticeByMajorId","get",{major_id:this.studentMsg.stu_major}).then((res)=>{
                    this.noticeMsg=res;
                })
            },
            //展示通知信息
            openNotice(id){
                this.dialogVisible=true;
                this.msg=this.noticeMsg.filter((item)=>{
                    return item.notice_id===id;
                })
            }
        },
        filters:{
            toDay:function (num) {
                //获取数字对应的大写
                const map={
                    '0':'日',
                    '1':'一',
                    '2':'二',
                    '3':'三',
                    '4':'四',
                    '5':'五',
                    '6':'六'
                }
                let res=map[num];
                return res;
            }
        },
        created(){
            this.get_course_Msg();
            this.getStudentMsg();
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #stuContent{
        padding:10px 100px;
        .top{
            height: 180px;
            width: 1000px;
            border: 1px solid #EBEEF5;
            margin-bottom: 10px;
            display: flex;
            justify-content:left;
            align-items: center;
            padding: 0 50px;
            background-color: white;
            img{
                border-radius: 50%;
                height: 100px;
                width: 100px;
                margin-right: 15px;
            }
            .msg{
                .name{
                    font-weight: bold;
                    margin-bottom: 10px;
                }
            }
        }
        .text {
            font-size: 14px;
            border-bottom: 1px dashed  black;
            cursor:pointer;
            height: 30px;
            line-height: 30px;
            color: #6e6e6e;
            white-space: nowrap;
            overflow: hidden;
            text-overflow:ellipsis;
        }
        .text:hover{
            background-color: #dddddd;
        }
        .item {
            margin-bottom: 18px;
        }

        .clearfix:before,
        .clearfix:after {
            display: table;
            content: "";
        }
        .clearfix:after {
            clear: both
        }
        .box-card {
            width: 530px;
            margin:0 20px 10px 0;
            float: left;
            height: 300px;
        }
        /*.el-card{*/
            /*height: 300px;*/
        /*}*/
        .score{
            display: flex;
            justify-content: space-between;
        }
        .time{
            font-size: 12px;
            text-align: center;
        }
        .msg{
            font-weight: bold;
        }
        ::v-deep.el-dialog__header{
            background-color:#0483d4;
        }
    }
</style>