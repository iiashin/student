<template>
    <div id="student_home">
        <home-header></home-header>
        <stu-content :num="term" :stu_id="id"></stu-content>
    </div>
</template>

<script>
    // import { mapMutations,mapState} from 'vuex'
    export default {
        name: "studentHome",
        components:{
            'home-header':()=>import('../components/stuHeader.vue'),
            'stu-content':()=>import('../components/stuContent.vue')
        },
        data(){
            return{
                id:'1',
                term:'1'
            }
        },
        methods:{
            //获取默认学期
            getDefaultTerm(){
                this.id=localStorage.getItem("studentId");
                let year,month,time,res;
                year=new Date().getFullYear().toString().slice(2);
                month=new Date().getMonth()+1;
                time=new Number(year)-new Number(this.id.toString().slice(0,2));
                if(month-6>=0)
                    if(time>4)
                        res=8;
                    else
                        res=time*2;
                else
                    res=time*2+1;
                this.term=res;
                localStorage.setItem("defaultTerm",res);
            }
        },
        created(){
            this.getDefaultTerm()
        }
    }
</script>

<style scoped>
    #student_home{
        /*background: #f0f0f0;*/
        overflow: hidden;   /*清除子元素浮动*/
    }
</style>