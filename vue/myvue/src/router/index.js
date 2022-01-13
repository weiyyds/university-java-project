import Vue from "vue";
import VueRouter from "vue-router";

import Content from "../components/Content"
import Main from "../components/Main"
//安装路由
Vue.use(VueRouter)

//配置导出路由
export default new VueRouter({
  routes:[
    {
      //配置路由路径：页面跳转
      path:'/content',//请求路径
      //路由名字
      name:Content,
      //跳转的组件
      component:Content
    },
    {
      //配置路由路径：页面跳转
      path:'/main',//请求路径
      //路由名字
      name:Main,
      //跳转的组件
      component:Main
    }
  ]
});
