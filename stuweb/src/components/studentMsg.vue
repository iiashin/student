<template>
    <div id="studentMsg">
        <div class="header">学生信息查询</div>
        <div class="msg_content">
            <button @click="dialogVisible = true" class="rewrite">修改</button>
            <el-dialog
                    title="修改个人信息"
                    :visible.sync="dialogVisible"
                    width="600px"
                    :before-close="handleClose">
                <div class="msg">
                    <label>学号:</label><span>{{stuMsg.stu_id}}</span><br>
                    <label>姓名:</label><span>{{stuMsg.stu_name}}</span><br>
                    <label>性别:</label><span>{{stuMsg.sex}}</span><br>
                    <label>学院:</label><span>{{stuMsg.dept_name}}</span><br>
                    <label>专业:</label><span>{{stuMsg.major_name}}</span><br>
                    <form action="http://localhost:8976/StuMsg/updateStu">
                        <input type="hidden" name="stu_id" :value="id">
                        <label>联系电话:</label><input type="text" v-model="stuMsg.phone" name="phone"><br>
                        <label>监护人:</label><input type="text" v-model="stuMsg.guarder" name="guarder"><br>
                        <label>监护人联系电话:</label><input type="text" v-model="stuMsg.guarder_phone" name="guarder_phone"><br>
                        <button type="submit" >确定</button>
                    </form>
                </div>
            </el-dialog>

            <table cellpadding="0" cellspacing="0" border="1"> <!-- cellspacing单元格之间的的距离，cellpadding单元格和内容之间的距离-->
                <tr>
                    <td class="title">学号</td>
                    <td>{{stuMsg.stu_id}}</td>
                    <td class="title">姓名</td>
                    <td>{{stuMsg.stu_name}}</td>
                </tr>
                <tr>
                    <td class="title">性别</td>
                    <td>{{stuMsg.sex}}</td>
                    <td class="title">联系电话</td>
                    <td>{{stuMsg.phone}}</td>
                </tr>
                <tr>
                    <td class="title">学院</td>
                    <td>{{stuMsg.dept_name}}</td>
                    <td class="title">专业</td>
                    <td>{{stuMsg.major_name}}</td>
                </tr>
                <tr>
                    <td class="title">监护人</td>
                    <td>{{stuMsg.guarder}}</td>
                    <td class="title">监护人联系电话</td>
                    <td>{{stuMsg.guarder_phone}}</td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
    import {request} from "../util/request";

    export default {
        name: "studentMsg",
        data(){
            return{
                stuMsg:'',
                dialogVisible: false,
                id:''
            }
        },
        methods:{
            //关闭窗口
            handleClose(done) {
                request("selStuMsgByStuId",get,{stu_id: this.id}).then((res)=>{
                    this.stuMsg=res[0];
                    this.dialogVisible = false
                })
            },
            //确认修改
            reWriteMsg(){
                request("updateStu",get,{studentMsg:this.stuMsg}).then((res)=>{
                    // console.log(res.data,"!!");
                    dialogVisible = false;
                })
            }

        },
        mounted(){
            this.id=localStorage.getItem("studentId");
            request("selStuMsgByStuId","get",{ stu_id:this.id}).then((res)=>{
                this.stuMsg=res[0];
            })
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #studentMsg{
        .header{
            height: 60px;
            background-color: #0483d4;
            padding:0px 100px;
            font-size: 22px;
            color: white;
            line-height: 60px;
        }
        .msg_content{
            width: 80%;
            background-color: white;
            margin:10px 100px;
            padding: 20px;
            .rewrite{
                margin-bottom: 10px;
                color: white;
                background-color:orangered;
                float: right;
                height: 30px;
                width: 80px;
            }
            table{
                width: 100%;
            }
            td{
                /*border: 1px solid black;*/
                text-align: center;
                height: 50px;
            }
            .title{
                color: grey;
            }
            ::v-deep .el-dialog__header{
                text-align: center;
                background-color: #e15743;
            }
            ::v-deep .el-dialog__close{
                color: white;
            }
            .msg{
                position: relative;
                left: 10%;
                label,span,input{
                    display: inline-block;
                    font-size: 15px;
                    margin-bottom: 15px;
                    color: black;
                }
                label{
                    width: 130px;
                }
                input{
                    border-top-width: 0;
                    border-left-width: 0;
                    border-right-width: 0;
                    border-bottom-width: 2px;
                    width: 250px;
                    height: 20px;
                }
            }
            form{
                overflow: hidden;
                padding-right: 10%;
                button{
                    float: right;
                    background-color: #0483d4;
                    color: white;
                    font-size: 15px;
                    height: 40px;
                    width: 90px;
                }
            }
        }
    }
</style>