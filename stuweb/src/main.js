import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from "axios"
// 挂载到vue原型链上
Vue.prototype.axios = axios;
axios.defaults.baseURL = '/api/'

import qs from 'qs'
//挂载到原型链
Vue.prototype.$qs = qs;

Vue.config.productionTip = false

import {request} from "./util/request";

import {Dropdown, DropdownMenu,DropdownItem,Menu, Submenu, MenuItem,MenuItemGroup,Card,Button,Table,TableColumn,Select,Option,Dialog,Radio,Input} from 'element-ui';

Vue.use(Dropdown);
Vue.use(DropdownMenu);
Vue.use(DropdownItem);
Vue.use(Menu);
Vue.use(Submenu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Card);
Vue.use(Button);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Select);
Vue.use(Option);
Vue.use(Dialog);
Vue.use(Radio);
Vue.use(Input)


//路由跳转前需要判断
router.beforeEach(function (to,from,next) {
    if(to.meta.userLogin){    //当跳转的路由需要判断是不是登录
        if(window.localStorage.getItem('studentId')){
            next()
        }else {
            alert("请先登入！")
            next('/login')
        }
    }else if(to.meta.teacLogin){
        if(window.localStorage.getItem('teacherId')){
            next()
        }else {
            alert("请先登入！")
            next('/login')
        }
    }else if(to.meta.adminLogin) {
        if (window.localStorage.getItem('flag')==='admin') {
            next()
        } else {
            alert("请先登入！")
            next('/login')
        }
    }else {
        next()
    }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
