<template>
    <div id="myHeader">
        <div class="myNav">
            <div class="logo">教学信息综合服务平台(教师端)</div>
            <div class="user">
                <el-dropdown @command="handleCommand">
                    <img src="../assets/nami.jpg" class="userImg">
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="a">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
        <el-menu :default-active="activeIndex" class="el-menu-demo"  mode="horizontal"  @select="handleSelect" >
            <el-menu-item index="1" @click="$router.push('/teahome')" >课程信息</el-menu-item>
            <el-menu-item index="2" @click="add" v-if="add1===1">添加课程</el-menu-item>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "teaHeader",
        data(){
            return{
                activeIndex:'1',
            }
        },
        props: ['add1'],
        methods:{
            //选中下拉菜单的回调
            handleCommand(command) {
                console.log('click on item ' + command);
                this.$router.push('/login');
            },
            //选中导航菜单菜单的回调
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            //下拉菜单跳转
            toLink(url){
                const {href} =this.$router.resolve({
                    path:url
                })
                window.open(href,'_blank')  //  _blank：在新窗口显示目标网页
            },
            add(){
                console.log("触发父方法")
                this.$emit('func');
            }
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #myHeader{
        .myNav{
            height: 60px;
            background-color: #0483d4;
            display: flex;
            justify-content: space-between;
            padding:0px 100px;
            .logo{
                font-weight: bold;
                color: white;
                font-size: 22px;
            }
            .user{
                height: 100%;
                img{
                    height: 30px;
                    border-radius: 50%;
                }
            }
            .user,.logo{
                display: flex;
                align-items: center;
            }
        }
        .el-menu{
            padding: 0px 100px;
        }
        ::v-deep li:hover{
            background-color:#ddd;
        }
        a{
            text-decoration: none;
        }
    }
</style>