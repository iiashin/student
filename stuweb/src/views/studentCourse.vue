<template>
    <div id="studentCourse">
        <div class="header">学生课表查询</div>
        <div class="container">
            <div class="container_top">
                <span>
                    学期:
                    <el-select v-model="value" placeholder="请选择">
                        <el-option
                                v-for="item in 8"
                                :key="item"
                                :label="item"
                                :value="item">
                        </el-option>
                    </el-select>
                </span>
                <button class="search" @click="findTerm()">
                    <img src="../assets/search.png" />查询
                </button>
            </div>
            <button class="printer" @click="print">打印</button>
            <table class="container_table" border="1">
                <thead>
                    <tr>
                        <th colspan="8">
                            <h2>{{name}}的课表</h2>
                        </th>
                    </tr>
                </thead>
                <tr class="table_header">
                    <th>节次</th>
                    <th>星期日</th>
                    <th>星期一</th>
                    <th>星期二</th>
                    <th>星期三</th>
                    <th>星期四</th>
                    <th>星期五</th>
                    <th>星期六</th>
                </tr>
                <tr v-for="i in 7" class="row_height">
                    <td class="num">{{i}}</td>
                    <td v-for="(j,index) in resultData">
                        <template v-if="j.course">
                            <div v-for="item in j.course" :key="item.course_id">
                                <template v-if="item.classtime===i">
                                    <div class="table_container">{{item.course_name}}</div>
                                    <div class="table_container"><img src="../assets/classroom.png">教室:{{item.room}}号教室</div>
                                    <div class="table_container"><img src="../assets/teacher.png">{{item.teac_name}}</div>
                                    <div class="table_container"><img src="../assets/credit.png">学分:{{item.credit}}</div>
                                </template>
                            </div>
                        </template>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>
    // import {mapState} from 'vuex';
    import XLSX from 'xlsx'
    import {request} from "../util/request";
    export default {
        name: "studentCourse",
        data(){
            return{
                value: '',    //下拉菜单默认为''
                name:'',
                id:'',
                responseData:[],  //响应结果
                courseData:[],
                resultData:[]
            }
        },
        methods:{
            //XLSX导出为excel
            print(){
                let table = document.getElementsByClassName('container_table')[0];
                let worksheet = XLSX.utils.table_to_sheet(table);  //将一个table对象转换成一个sheet对象
                let workbook = XLSX.utils.book_new();   //XLSX.utils.book_new实用函数创建一个新的工作簿对象。
                XLSX.utils.book_append_sheet(workbook, worksheet, 'sheet');   //将数据添加到工作薄
                XLSX.writeFile(workbook, 'text.xlsx');  //导出Excel

            },
            init(){
                this.resultData=[];   //重新初始化
                this.courseData=this.responseData.filter((item)=>{
                    return item.term=== parseInt(this.value);
                })
                let arr=new Array(7);
                for(let i=0;i<7;i++){
                    arr[i]=this.courseData.filter((item)=>{
                        return item.day===i;
                    });
                }
                let temp={}
                for(let index in arr){
                    if(arr[index].length!==0)
                     {
                        temp['week']=index;
                        temp['course']=[]
                        for(var ele of arr[index]){
                            temp['course'].push(ele)
                        }
                    }
                    this.resultData.push(temp);
                    temp={}
                }
            },
            //获取对应学期的数据
            getMsgByTerm(id,term){
                let params={
                    stu_id:id,
                    term:term
                }
                request("selCourseMsgByStuId","get",params).then((res)=>{
                    this.responseData=res;
                    this.init();
                })
            },
            //查找学期
            findTerm(){
                // this.init();
                this.getMsgByTerm(this.id,this.value);
            },

        },
        mounted(){
            this.value=localStorage.getItem("defaultTerm");
            this.id=localStorage.getItem("studentId");
            request("selStuMsgByStuId","get",{ stu_id:this.id}).then((res)=>{
                this.name=res[0].stu_name;
            })
            this.getMsgByTerm(this.id,this.value);
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    #studentCourse{
        /*background: #f0f0f0;*/
        /*overflow: hidden;   !*清除子元素浮动*!*/
        .header{
            height: 60px;
            background-color: #0483d4;
            padding:0px 100px;
            font-size: 22px;
            color: white;
            line-height: 60px;
        }
        .container{
            width: 80%;
            background-color: white;
            margin:10px 100px;
            padding: 20px;
            .container_top{
                width: 100%;
                border: 1px solid #e6e6e6;
                padding: inherit;
                margin-bottom: 10px;
                box-sizing: border-box;
                span{
                    position: relative;
                    display: inline-block;
                    left: 150px;
                }
                .search{
                    background-color: #337ab7;
                    color: white;
                    height: 35px;
                    width: 80px;
                    float: right;
                    img{
                        height: 15px;
                        vertical-align: bottom;
                    }
                }
            }
            .printer{
                float: right;
                color: #fff;
                background-color: #337ab7;
                width: 60px;
                margin-bottom: 10px;
            }
            .container_table{
                border: 1px solid #e6e6e6;
                /*text-align: center;*/
                width: 100%;
                h2{
                    color: #666666;
                    font-size: 30px;
                    font-family: "microsoft YaHei";
                    font-weight: normal;
                }
                .table_header th,.num{
                    color: #666666;
                    font-family: "microsoft YaHei";
                    font-weight: normal;
                    text-align: center;
                }
                tr:hover{
                    background-color: #ddd;
                }
                .row_height{
                    height: 60px;
                }
                .table_container{
                    margin-left: 20px;
                    box-sizing: border-box;
                    img{
                        height: 20px;
                        vertical-align: bottom;
                    }
                }
                .row_height td{
                    width: 200px;
                }
            }
        }
    }
</style>