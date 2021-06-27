import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'

Vue.use(VueRouter)

//路由懒加载
const routes = [
    //默认路径
    {
        path:'/',
        redirect:'/login'
    },
    {
        path:'/stuhome',
        name:'studentHome',
        component:()=>import('../views/studentHome.vue'),
        meta:{
            userLogin:true
        }
    },
    {
        path:'/stucourse',
        name:'studentCourse',
        component:()=>import('../views/studentCourse.vue'),
        meta:{
            userLogin:true
        }
    },
    {
        path:'/stugrade',
        name:'studentGrade',
        component:()=>import('../views/studentGrade.vue'),
        meta:{
            userLogin:true
        }
    },
    {
        path:'/stumsg',
        name:'studentMsg',
        component:()=>import('../components/studentMsg.vue'),
        meta:{
            userLogin:true
        }
    },
    {
        path:'/login',
        name:'Login',
        component:()=>import('../views/Login.vue')
    },
    {
        path:'/teahome',
        name:'teacherHome',
        component:()=>import('../views/teacherHome.vue'),
        meta:{
            teacLogin:true
        }
    },
    {
        path:'/coursemsg/:course_id',
        name:'courseMsg',
        component:()=>import('../views/courseMsg.vue'),
        meta:{
            teacLogin:true
        }
    },
    {
        path:'/admin',
        name:'admin',
        component:()=>import('../views/admin.vue'),
        meta:{
            adminLogin:true
        }
    }
]

const originalPush = VueRouter.prototype.push

VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router
