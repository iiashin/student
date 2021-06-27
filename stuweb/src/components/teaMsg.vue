<template>
    <div id="teaMsg">
        <div class="top">
            <img src="../assets/nami.jpg">
            <div class="msg">
                <div class="name">教师名:{{msg.teac_name}}</div>
                <span class="line">职工号:{{msg.teac_id}}</span>
                <span class="line">学院:{{msg.dept_name}}</span>
            </div>
        </div>
        <div>
            <input placeholder="输入课程编号" class="delInput" v-model="delId"></input>
            <el-button type="success" @click="delCourse">删除</el-button>
        </div>
        <div class="course" v-for="item in courseMsg" :key="item.course_id" @click="$router.push(`/coursemsg/${item.course_id}`)">
            <div class="test">
                点击查看
            </div>
            <div class="courseMsg">
                <span>学期:{{item.term}}</span>
                <span>课程编号:{{item.course_id}}</span>
                <span>课程:{{item.course_name}}</span>
                <span>上课教室:{{item.room}}号教室</span>
                <span>上课时间:星期{{item.day |toDay }},第{{item.classtime}}节课</span>
            </div>
        </div>
    </div>
</template>

<script>
    import {request} from "../util/request";

    export default {
        name: "teaMsg",
        data(){
            return{
                msg:'',
                id:'',
                courseMsg:'',
                delId:'',
                temp:1
            }
        },
        methods:{
            //删除课程号
            delCourse(){
                request("delCourse", "get", {course_id:this.delId}).then((res)=>{
                    this.temp++;
                    this.delId='';
                })
            }
        },
        watch:{
            temp:function (val) {
                request("selCourseByTeaId", "get", {id:this.id}).then((res)=>{
                        this.courseMsg=res;
                    }
                )
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
            this.id=localStorage.getItem('teacherId');
            this.axios.all([
                request("selTeac", "get", {id:this.id}),
                request("selCourseByTeaId", "get", {id:this.id}),
            ]).then(this.axios.spread((res1,res2)=>{
                this.msg=res1;
                this.courseMsg=res2;
            }))
        }
    }
</script>

<style scoped type="text/scss" lang="scss">
    #teaMsg{
        padding:10px 100px;
        overflow: hidden;
        .delInput{
            height: 36px;
            width: 250px;
            margin-right: 10px;
        }
        .top{
            height: 180px;
            width: 1150px;
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
                .line{
                    margin-right: 10px;
                }
            }
        }
        .course{
            width: 400px;
            height: 300px;
            background-color: white;
            position: relative;
            /*border: 1px solid darkgray;*/
            margin:10px 20px 10px 0;
            float: left;
            .courseMsg{
                display: flex;
                /*align-items: center;*/
                justify-content: space-between;
                flex-direction: column;
                height: 100%;
                width: 100%;
                padding:60px 0px;
                box-sizing: border-box;
                font-size: 18px;
                margin-left: 40px;
            }
        }
        .course:hover .test{
            opacity: 1;
            transform: translate(0px,-150px);
        }
        .course:hover{
            background-color: darkslategrey;
            opacity: 0.5;
        }
        .course:hover .courseMsg{
            /*opacity: 0.2;*/
        }
        .test{
            position: absolute;
            opacity: 0;
            color: white;
            font-size: 18px;
            bottom: 0;
            left: 40%;
            transition: all 1s;
        }
    }
</style>