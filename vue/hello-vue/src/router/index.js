import Vue from 'vue'
import Router from 'vue-router'

import Main from "../views/Main";
import Login from "../views/Login";

import UserList from "../views/user/List";
import UserProfile from "../views/user/Profile";

import NotFound from "../views/NotFound";
Vue.use(Router);

export default new Router({
  mode:'history',
  routes:[
    {
      path:'/login',
      component:Login
    },

    {
      path:'/main',
      component:Main,
      props:true,
      //嵌套路由
      children:[
        {
          path:'/user/profile/:id',
          //这里的name必须用‘’,不然会是空白页面
          name:'UserProfile',
          //这里的component不能用''
          component:UserProfile,
          //第二种方法传递参数
          props:true
        },
        {
          path:'/user/list',
          component:UserList
        },
      ]
    },
    {
      path: '/gohome',
      redirect:'/main'
    },
    {
      path: '*',
      component: NotFound
    }
  ]
});

