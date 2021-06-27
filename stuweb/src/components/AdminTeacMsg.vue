<template>
    <div id="AdminTeacMsg">
        <div class="add">
            姓名:<input v-model="name">
            密码:<input v-model="password">
            学院:<select name="stu_dept" placeholder="请选择" v-model="dept_id">
                    <option :value="item.dept_id" v-for="item in deptList" :label="item.dept_name"></option>
                </select>
            <button @click="addTeacher">确认</button>
        </div>
        <el-table
                :data="teacMsg"
                stripe
                border
                style="width: 100%">
            <el-table-column
                    prop="teac_id"
                    label="教师号">
            </el-table-column>
            <el-table-column
                    prop="teac_name"
                    label="教师名">
            </el-table-column>
            <el-table-column
                    prop="password"
                    label="密码">
            </el-table-column>
            <el-table-column
                    prop="dept_name"
                    label="学院">
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
        name: "AdminTeacMsg",
        data(){
            return{
                teacMsg:[],
                deptList:[],
                name: '',
                password:'',
                dept_id:'',
                temp:1
            }
        },
        created(){
            this.axios.all([
                request("selAllTeac", "get", {}),
                request("selDept", "get",{})
            ]).then(this.axios.spread((res1,res2)=>{
                this.teacMsg=res1;
                this.deptList=res2;
            }))
        },
        methods: {
            addTeacher() {
                let params = {
                    teac_name: this.name,
                    password: this.password,
                    dept_id: this.dept_id
                };
                request("insertTeacher", "get", params).then((res) => {
                    this.name = '';
                    this.password = '';
                    this.dept_id = '';
                    this.temp++;
                })
            },
            //删除教师
            handleDelete(msg) {
                request("delTeacher", "get", {teac_id: msg.teac_id}).then((res) => {
                    this.temp++;
                })
            }
        },
        watch:{
            temp(val){
                request("selAllTeac", "get", {}).then((res)=>{
                    this.teacMsg = res
                    }
                )
            }
        }
    }
</script>

<style scoped lang="scss" type="text/scss">
    .add{
        margin: 15px 0px;
        input,select{
            margin:0px 5px;
            box-sizing: border-box;
            width: 250px;
            height: 30px;
        }
        button{
            color: white;
            background-color:  #0483d4;
            width: 80px;
            height: 30px;
        }
    }
</style>