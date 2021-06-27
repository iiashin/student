

export default {
    namespaced:true,
    state:{
        activeIndex:'1',                        //当前打开的页面
        openIndex:[                             //当前打开的所有页面
            {id:'1',name:'首页',sign:'home'}
        ],
        tabList:[                                //侧边栏列表
            {id:'1',name:'首页',sign:'stuMsg'},
            {id:'2-1',name:'学生信息',sign: 'stuMsg'},
            {id:'2-2',name:'教师信息',sign:'teacMsg'},
            {id:'3-1',name:'课程信息',sign:'courseMsg'},
            {id:'4-1',name:'通知信息',sign:'noticeMsg'}
        ],
        user:[],                                 //获取所有用户
        newsList:[],                             //已发布新闻列表
        reviewNewsList:[]                       //待审核列表
    },
    mutations:{
        //更改当前打开的页面
        set_activeIndex(state,val){
            state.activeIndex=val;
        },
        //添加页面
        add_openIndex(state,val){
            if(!(state.openIndex.find(item=>item.id===val))) {
                const item=state.tabList.filter(item=>item.id===val)   //根据点击的页面id找到当前打开的页面的所有信息
                state.openIndex.push(item[0])     //加入数组
            }
        },
        //删除页面
        delete_openIndex(state,val){
            const num=val;
            state.openIndex=state.openIndex.filter(item=>item.id!==val)  //不是正好打开的页面，直接筛选剔除
            if(num===state.activeIndex){
                state.activeIndex=state.openIndex[state.openIndex.length-1].id    //当删除的是正好打开的页面，active转到前一个
            }
        },
        //设置用户
        set_user(state,val){
            state.user=val
        },
        //设置新闻
        set_newsList(state,val){
            state.newsList=val;
        },
        //设置审核表
        set_reviewNewsList(state,val){
            state.reviewNewsList=val;
        }
    },
    actions:{
        //获取所有用户
        get_user({commit}){
            request("get","selUser").then(
                res=>{
                    commit('set_user',res)
                })
        },
        //获取所有新闻
        get_newsList({commit}){
            request("get","newsServlet").then(
                res=>{
                    console.log("test")
                    commit('set_newsList',res)
                }
            )
        },
        //获取所有待审核新闻
        get_reviewNewsList({commit}){
            request("get","selReviewNews").then(
                res=>{
                    commit('set_reviewNewsList',res)
                }
            )
        }
    },
    getters:{
        MsgCount(state){
            if(state.newsList.length>0)
                return state.newsList.reduce((pre,msg)=>msg.count+pre,0)
        }
    }
}