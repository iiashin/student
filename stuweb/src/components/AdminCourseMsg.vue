<template>
    <div id="AdminCourseMsg">
        <el-table
                :data="courseMsg"
                stripe
                border
                style="width: 100%">
            <el-table-column
                    prop="course_id"
                    label="课程号">
            </el-table-column>
            <el-table-column
                    prop="course_name"
                    label="课程名称">
            </el-table-column>
            <el-table-column
                    prop="credit"
                    label="学分">
            </el-table-column>
            <el-table-column label="上课日期">
                <template slot-scope="scope">
                    星期{{scope.row.day|toDay}}
                </template>
            </el-table-column>
            <el-table-column
                    prop="term"
                    label="学期">
            </el-table-column>
            <el-table-column label="教室">
                <template slot-scope="scope">
                    {{scope.row.room}}号教室
                </template>
            </el-table-column>
            <el-table-column
                    prop="teac_id"
                    label="任课教师编号">
            </el-table-column>
            <el-table-column label="操作"  width="80">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import {request} from "../util/request";

    export default {
        name: "AdminCourseMsg",
        data(){
            return{
                courseMsg:[]
            }
        },
        methods:{

        },
        created(){
            request("selAllCourse", "get", {}).then((res)=>{
                this.courseMsg=res;
            })
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
        methods:{
            handleDelete(msg){
                request("delCourse", "get", {course_id:msg.course_id}).then((res)=>{
                    request("selAllCourse", "get", {}).then((res)=>{
                        this.courseMsg=res;
                    })
                })
            }
        }
    }
</script>

<style scoped>

</style>