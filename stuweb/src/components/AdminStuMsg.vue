<template>
    <div id="AdminStuMsg">
        <div class="search">
            <label>学号:</label><input type="text" v-model="id" />
            <br>
            <label>专业:</label>
            <select v-model="value">
                <option :value="item.major_id" v-for="item in majorList">{{item.major_name}}</option>
            </select>
            <button @click="searchHandle">搜索</button>
        </div>
        <button class="add" @click="addStudent()">添加学生</button>
        <el-dialog
                title="添加学生"
                :visible.sync="dialogVisible"
                width="600px"
                :before-close="handleClose()">
            <div class="msg">
                <form action="http://localhost:8976/StuMsg/insertStudent">
                    姓名:<input name="stu_name" class="text" placeholder="姓名"></input><br/>
                    密码:<input name="password" class="text" placeholder="密码"></input><br/>
                    性别:<input type="radio" name="sex" class="sex" value="男">男
                         <input type="radio" name="sex" class="sex" value="女">女<br/>
                    学院:<select name="stu_dept" placeholder="请选择">
                            <option :value="item.dept_id" v-for="item in deptList" :label="item.dept_name"></option>
                         </select><br/>
                    专业:<select name="stu_major" placeholder="请选择">
                            <option :value="item.major_id" v-for="item in majorList" :label="item.major_name"></option>
                        </select>
                        <input type="submit" value="提交" class="btn">
                </form>
            </div>
        </el-dialog>
        <el-table
                :data="stuMsg"
                stripe
                border
                style="width: 100%">
            <el-table-column
                    prop="stu_id"
                    label="学号">
            </el-table-column>
            <el-table-column
                    prop="stu_name"
                    label="姓名">
            </el-table-column>
            <el-table-column
                    prop="password"
                    label="密码">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别">
            </el-table-column>
            <el-table-column
                    prop="dept_name"
                    label="学院">
            </el-table-column>
            <el-table-column
                    prop="major_name"
                    label="专业">
            </el-table-column>
            <el-table-column
                    prop="phone"
                    label="联系电话">
            </el-table-column>
            <el-table-column
                    prop="guarder"
                    label="监护人">
            </el-table-column>
            <el-table-column
                    prop="guarder_phone"
                    label="监护人联系电话">
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
        name: "AdminStuMsg",
        data(){
            return{
                stuMsg:[],     //学生列表
                majorList:[],     //专业列表
                value:'',       //搜索下拉菜单默认值
                id:'',        //搜索学生学号
                dialogVisible:false,
                deptList:[]
            }
        },
        created(){
            this.axios.all([
                request("qurryStudentMsg", "get", {}),
                request("selMajor", "get",{}),
                request("selDept", "get",{})
            ]).then(this.axios.spread((res1,res2,res3)=>{
                this.stuMsg=res1;
                this.majorList=res2;
                this.deptList=res3;
            }))
        },
        methods:{
            searchHandle(){
                let params={
                    major_id:this.value,
                    stu_id:this.id
                };
                request("searchStudentMsg", "get", params).then((res)=>{
                    this.stuMsg=res
                });
            },
            addStudent(){
                this.dialogVisible=true;
            },
            //关闭弹出窗
            handleClose(){
            },
            handleDelete(msg){
                request("delStudent", "get", {stu_id:msg.stu_id}).then((res)=>{
                    if(res){
                        request("qurryStudentMsg", "get", {}).then((res)=>{
                            this.stuMsg=res;
                        })
                    }
                });
            }
        }
    }
</script>

<style scoped type="text/scss" lang="scss">
    #AdminStuMsg{
        width: 100%;
        padding-top: 5px;
        /*box-sizing: border-box;*/
        .add{
            position: relative;
            height: 30px;
            width: 80px!important;
            margin-bottom: 10px;
            background-color: #0483d4!important;
            color: white;
            /*left: 850px;*/
        }
        .search{
            margin-bottom:5px ;
            /*box-shadow: 0px 2px 2px #e7e7e7;*/
            font-size: 14px;
            input,select{
                margin-bottom: 10px;
                width: 225px;
                height: 22px;
                margin-right: 20px;
                /*border:1px solid #ccc;*/
                box-sizing: border-box;
            }
            label{
                display: inline-block;
                width: 50px;
            }
            button{
                background-color: #db4254;
                color: white;
                /*height: 25px;*/
                width: 54px;
                border-radius: 5px;
            }
        }
        .msg{
            padding-left: 80px;
            .text,select,option,.btn{
                margin-bottom: 15px;
                height: 36px;
                width: 300px;
                margin-left: 5px;
                box-sizing: border-box;
            }
            .btn{
                color: white;
                background-color: #0483d4!important;
                width: 330px;
            }
            .sex{
                margin-bottom: 15px;
                margin-left: 5px;
            }
        }
    }
</style>