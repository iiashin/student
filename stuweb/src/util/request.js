import axios from 'axios';
import qs from 'qs';
import Vue from "vue";
Vue.prototype.$qs = qs;

// 挂载到vue原型链上
// Vue.prototype.axios = axios;
// axios.defaults.baseURL = '/api/'

let baseURL='/api/'

var instance=axios.create({
    baseURL:baseURL,
    timeout:30000
})

instance.defaults.headers.post['Content-Type']='application/x-www-form-urlencoded';

//请求拦截器
// instance.interceptors.request.use(
//     config=>{
//
//     },
//     error => Promise.error(error)
// )
//response拦截器
instance.interceptors.response.use(
    response=>{
        const res=response.data;
        return Promise.resolve(res)
    },
    error => {
        return Promise.reject(error)
    }
)
export const request = async (url = '', type = 'GET', data = {})=>{
    let result;
    type = type.toUpperCase();
    let requestOptions = {
        method: type,
        url: url
    }
    // requestOptions['headers'] = 'application/x-www-form-urlencoded';
    if(type==='GET'){
        requestOptions['params']=data;
        // console.log(requestOptions['params']);
    }
    else{
        // console.log(data);
        requestOptions['data']=qs.stringify(data);
        // console.log(requestOptions['data']);
    }
    await instance(requestOptions).then((res)=>{
        console.log(res,"res");
        result=res;
    })
    return result;
}