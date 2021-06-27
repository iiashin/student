<template>
    <div id="admin">
        <!--侧边栏-->
        <div class="sideBar">
            <el-menu :default-active="activeIndex" class="el-menu-vertical-demo"
                     active-text-color="#42b983" background-color="rgb(48, 65, 86)" text-color="white" :collapse="isCollapse" @select="handleSelect">
                <div class="sigh">
                    <img src="../assets/nami.jpg">
                </div>
                <el-menu-item index="1" class="activeCol">
                    <i class="el-icon-menu"></i>
                    <span slot="title">首页</span>
                </el-menu-item>
                <el-submenu index="2" >
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">用户管理</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="2-1">学生信息</el-menu-item>
                        <el-menu-item index="2-2">教师信息</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">课程管理</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="3-1">课程信息</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title">
                        <i class="el-icon-location"></i>
                        <span slot="title">通知管理</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="4-1">通知信息</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </div>
        <!--侧边栏右边-->
        <div class="right">
            <!--顶部-->
            <div class="topNav">
                <!--伸缩侧边栏，退出登录-->
                <img :src="isCollapse?require('../assets/close.png'):require('../assets/open.png')" @click="isCollapse=!isCollapse">   <!--三元运算符切换图片-->
                <div class="user">
                    <el-dropdown @command="handleCommand">
                        <span>ashin</span>
                        <img src="../assets/nami.jpg" class="userImg">
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="a">退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </div>
            <!--tab栏标题-->
            <div class="onTab">
                <div class="tabBtn">
                    <button :class="'1'===activeIndex?'active':''"   @click="choseItem('1')">首页</button>
                    <template v-for="item in openIndex.filter(item=>item.id!=='1')">
                        <button v-if="item.id===activeIndex" class="active">
                            <img src="../assets/dot.png">
                            {{item.name}}
                            <img src="../assets/shut2.png" @click.stop="delItem(item.id)">  <!--.stop防止冒泡，阻止按钮点击事件！！！-->
                        </button>
                        <button v-else @click="choseItem(item.id)">
                            {{item.name}}
                            <img src="../assets/shut.png" @click.stop="delItem(item.id)">
                        </button>
                    </template>
                </div>
                <!--tab栏内容-->
                <div class="tabItem">
                    <!--<keep-alive>-->
                    <component :is="componentId"></component>
                    <!--</keep-alive>-->
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import {mapState,mapMutations,mapActions} from 'vuex'
    import AdminStuMsg from '../components/AdminStuMsg'
    import AdminTeacMsg from '../components/AdminTeacMsg'
    import AdminCourseMsg from '../components/AdminCourseMsg'
    import AdminNoticeMsg from '../components/AdminNoticeMsg'
    export default {
        name: "admin",
        components:{
            AdminStuMsg,AdminTeacMsg,AdminCourseMsg,AdminNoticeMsg
        },
        data() {
            return {
                isCollapse: false,
                componentId:'AdminStuMsg',
            };
        },
        computed:{
            ...mapState('admin',[
                'activeIndex',    //:default-active="activeIndex"当我们更改打开页面时侧边栏也会跟着更改
                'openIndex',
                'tabList',
                // 'user'
            ])
        },
        methods:{
            ...mapMutations('admin',['set_activeIndex','add_openIndex','delete_openIndex']),
            ...mapActions('admin',['get_user','get_newsList','get_reviewNewsList']),
            //选择侧边栏
            handleSelect(key) {
                this.set_activeIndex(key);
                this.add_openIndex(key);     //增加当前打开的页面
            },
            //更改当前打开的页面
            choseItem(id){
                this.set_activeIndex(id);   //更改当前打开的页面
            },
            //删除查看列表
            delItem(id){
                this.delete_openIndex(id)
            },
            //退出登录
            handleCommand(command) {
                console.log('click on item ' + command);
                this.$router.push('/login');
            }
        },
        watch:{
            //监视activeIndex，当active变化时，获取当前打开的tab信息，并赋给组件
            activeIndex:function (val) {
                var item1=this.tabList.filter(function (item){
                    return item.id===val
                })
                const str=item1[0].sign
                this.componentId="Admin"+str.charAt(0).toUpperCase()+str.slice(1)
            }
        },
    }
</script>

<style scoped lang="scss" type="text/scss">
    #admin{
        display: flex;
        .right{
            flex: 1;    //flex:1使元素自适应剩余部分
            background-color: white;
            .topNav{
                display: flex;
                justify-content: space-between;
                height: 45px !important;
                img{
                    height: 25px;
                    width: auto;
                }
                .userImg{
                    height: 30px;
                    border-radius: 50%;
                    vertical-align: middle;
                }
                span{
                    display: inline-block;
                    color: black;
                    margin-right: 15px;
                    vertical-align: middle;
                }
            }

            .tabBtn,.topNav{
                box-sizing: border-box;
                width: 100%;
                padding: 5px 20px 5px 5px;
                box-shadow: 0px 2px 5px #e7e7e7;
            }
            .tabBtn{
                height: 40px;
                button{
                    background-color: white;
                    height:30px;
                    border: 1px solid #e7e7e7;
                    margin-right: 5px;
                    top: 50%;
                    transform:translateY(-50%);
                    position: relative;
                    img{
                        vertical-align:middle ;
                    }
                }
                .active{
                    background-color: #42b983;
                    color: white;
                }
            }
            .tabItem{
                padding: 5px;
            }

        }

        .sideBar{
            .sigh{
                height: 100px;
                border-bottom: 2px solid #34bfa3;
                position: relative;
                img{
                    border-radius: 50%;
                    height: 60px;
                    width:60px;
                    top:0;
                    bottom:0;
                    left: 0;
                    right: 0;
                    margin: auto;
                    position: absolute;
                }
            }
            .el-menu{
                height: 750px;
            }
            .el-menu-vertical-demo:not(.el-menu--collapse) {
                width: 200px;
                min-height: 400px;
            }
            /*.el-menu,.el-menu-item-group{*/
            /*background-color: rgb(48, 65, 86);*/
            /*}*/
            .el-menu-item:hover{
                background-color:#263445!important;
            }
            ::v-deep .el-submenu__title:hover{
                background-color:#263445!important;
                /*color: white;*/
            }
            /*/deep/.el-submenu__title,.el-menu-item{*/
            /*color: white;*/
            /*}*/
        }
    }

</style>