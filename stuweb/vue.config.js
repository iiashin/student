const webpack = require("webpack");
module.exports = {
    // configureWebpack: {
    //     plugins: [
    //         new webpack.ProvidePlugin({
    //             $: "jquery",
    //             jQuery: "jquery",
    //             "window.jQuery": "jquery"
    //         })
    //     ]
    // },
    //解决跨域
    devServer:{
        proxy:{
            '/api':{
                target:'http://localhost:8976/StuMsg/',
                changeOrigin:true,  //允许跨域
                ws: true,
                pathRewrite:{
                    '^/api':''
                }
            }
        },
        open:true   //自动打开浏览器
    }
};