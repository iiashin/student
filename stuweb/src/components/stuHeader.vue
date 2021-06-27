<template>
    <div id="myHeader">
        <div class="myNav">
            <div class="logo">教学信息综合服务平台(学生端)</div>
            <div class="user">
                <el-dropdown @command="handleCommand">
                    <img src="../assets/logo.jpg" class="userImg">
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="a">退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>
        <el-menu :default-active="activeIndex" class="el-menu-demo"  mode="horizontal"  @select="handleSelect" >
            <el-submenu index="1">
                <template slot="title">信息查询</template>
                <el-menu-item v-for="item in list.slice(0,2)" :index=item.index @click="toLink(item.url)" :key="item.index">{{item.name}}</el-menu-item>
            </el-submenu>
            <el-submenu index="2">
                <template slot="title">选课</template>
                <el-menu-item v-for="item in list.slice(2)" :index=item.index @click="toLink(item.url)" :key="item.index">{{item.name}}</el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script>
    export default {
        name: "myHeader",
        data(){
          return{
              activeIndex:'1',
              //下拉菜单的信息
              list:[
                  {
                      index:'1-1',
                      name:"学生信息查询",
                      url:"stumsg"
                  },
                  {
                      index:'1-2',
                      name:"学生成绩查询",
                      url:"stugrade"
                  },
                  {
                      index:'2-1',
                      name:"学生课表查询",
                      url:"stucourse"
                  }
              ]
          }
        },
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
        ::v-deep .el-submenu__title:hover{
            background-color:#ddd;
        }
    }
</style>