<template>
    <div id="teacherHome">
        <teac-header  v-on:func="openWindows" :add1="1"></teac-header>
        <teac-msg></teac-msg>
        <el-dialog
                title="添加课程"
                :visible.sync="addCourse"
                width="30%"
               @click="this.addCourse=false">
            <form action="http://localhost:8976/StuMsg/addCourse">
                <input type="hidden" :value="teac_id" name="teac_id">
                <label>课程名称</label>
                <input type="text" name="course_name"><br/>
                <label>节次:</label>
                <select placeholder="请选择" name="classtime">
                    <option :value="item" v-for="item in 7" :label="item"></option>
                </select><br/>
                <label>学期:</label>
                <select placeholder="请选择" name="term">
                    <option :value="item" v-for="item in 8" :label="item"></option>
                </select><br/>
                <label>上课日期:</label>
                <select placeholder="请选择" name="day">
                    <option :value="item-1" v-for="item in 7" :label="item-1|toDay"></option>
                </select><br/>
                <label>教室:</label>
                <select placeholder="请选择" name="room">
                    <option :value="item" v-for="item in 10" :label="item"></option>
                </select><br/>
                <label>学分:</label>
                <select placeholder="请选择" name="credit">
                    <option :value="item" v-for="item in 5" :label="item"></option>
                </select><br/>
                <span slot="footer" class="dialog-footer">
                <button type="primary">确 定</button>
                </span>
            </form>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "teacherHome",
        components:{
            'teac-header':()=>import('../components/teaHeader.vue'),
            'teac-msg':()=>import('../components/teaMsg.vue')
        },
        data(){
            return{
                addCourse:false,
                teac_id:''
                // course_name:''
            }
        },
        methods:{
            openWindows(){
                console.log("我是父组件方法")
                this.addCourse=true;
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
                return "星期"+res;
            }
        },
        created(){
            this.teac_id=localStorage.getItem('teacherId');
        }
    }
</script>

<style scoped type="text/scss" lang="scss">
    #teacherHome{
        overflow: hidden;
        form{
            overflow: hidden;
            input,select{
                height: 40px;
                width: 250px;
                margin-bottom: 10px;
                box-sizing: border-box;
            }
            label{
                margin-right: 5px;
                width: 70px;
                display: inline-block;
            }
            button{
                float: right;
            }
        }
    }
</style>