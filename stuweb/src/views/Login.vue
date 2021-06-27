<template>
    <div id="login">
        <div class="header">
            <!--<img src="https://news.gdpu.edu.cn/dfiles/11295/public/home/img/16sy/xh.jpg">-->
            <!--<span>学生信息管理系统</span>-->
        </div>
        <div class="container">
            <div class="left">
                <img src="../assets/library.jpg">
            </div>
            <div class="right">
                <div class="userInput">
                    <span>Login</span>
                    <br>
                    <input type="text" placeholder="username" v-model="username">
                    <br>
                    <input type="password" placeholder="password" v-model="password">
                    <br>
                    <el-radio v-model="radio" label="1">学生</el-radio>
                    <el-radio v-model="radio" label="2">教师</el-radio>
                    <el-radio v-model="radio" label="3">管理员</el-radio>
                    <el-button type="primary" round @click="isLogin">sign in</el-button>
                </div>
                <!--<a href="http://localhost:8080/home">游客进入</a>-->
            </div>
        </div>
    </div>
</template>

<script>
    import {request} from "../util/request";
    export default {
        name: "Login",
        data(){
            return{
                username:'',
                password:'',
                radio:'1'
            }
        },
        methods:{
            //登录功能
            isLogin(){
                let params={
                    id:this.username,
                    password:this.password
                };
                if(this.name='admin'&&this.password==='admin'&&this.radio==='3'){
                    localStorage.setItem("flag","admin");
                    this.$router.push('/admin');
                }
                else{
                    let url;
                    if(this.radio!=='3') {
                        if (this.radio === '1')
                            this.UserLogin('/stuLogin',"studentId", "student","/stuhome")
                        else
                            this.UserLogin('/teacLogin',"teacherId","teacher","/teahome")

                    }
                }
            },
            UserLogin(url,setId,flagName,path) {
                let params = {
                    id: this.username,
                    password: this.password
                }
                request(`${url}`, "post", params).then((res) => {
                    let data=res;
                    if(data){
                        localStorage.setItem(setId,data.stu_id||data.teac_id);
                        localStorage.setItem("flag",flagName);
                        this.$router.push(path);
                    }else{
                        alert("账号密码错误");
                    }
                })
            }
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #login{
        .header{
            padding: 10px;
            img{
                vertical-align: middle;
            }
            span{
                color: black;
                font-size: 36px;
                font-weight: 800;
                display: inline-block;
                vertical-align:middle;
            }
        }
        /*background-image: linear-gradient(to left top, white,white, #76b2f1);*/
        height: 100%;
        .container{
            background-color: white!important;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            height: 500px;
            width: 900px;
            box-shadow: -1px -1px 5px black;
            display: flex;
            .left{
                width: 60%;
                height: 100%;
                img{
                    width: 100%;
                    height: 100%;
                    object-fit: cover;
                }
                h2{
                    /*position: absolute;*/
                    text-align: center;
                    /*top: 50%;*/


                }
            }
            .right{
                background-color: white;
                height: 100%;
                width: 40%;
                position: relative;
                .userInput{
                    width: 100%;
                    text-align: center;
                    position: absolute;
                    top: 50%;
                    transform: translateY(-50%);
                    span{
                        font-weight: bold;
                        font-family: Georgia;
                        font-size: 22px;
                    }
                    input{
                        outline: none;
                        margin: 15px 0;
                        height: 30px;
                        width: 70%;
                        border-top-width: 0;
                        border-left-width: 0;
                        border-right-width: 0;
                        border-bottom-width: 2px;
                        font-size: 15px;
                    }
                    input:focus{
                        border-bottom-color: #76b2f1;
                    }
                    button{
                        position: relative;
                        margin-top: 20px;
                        width: 70%;
                    }
                }
                a{
                    position: absolute;
                    bottom: 10px;
                    text-decoration: none;
                    right: 10px;
                }
            }
        }
    }
</style>