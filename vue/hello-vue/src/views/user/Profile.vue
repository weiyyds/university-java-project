<template>
<!--所有的元素必须在根节点下-->
  <div>
    <h1>个人信息</h1>
<!--    这里是#route,不是$router-->
    <!--    方式一-->
<!--    {{$route.params.id}}-->
<!--    方式二-->
    {{id}}
  </div>

</template>

<script>
    export default {
      props:['id'],
        name: "UserProfile",
      //进入这个页面之前先执行这两个钩子函数，过滤器
      beforeRouteEnter:(to, from, next) => {
        console.log('进入路由之前！');//加载数据
        next(vm => {
          vm.getData();
        });
      },
      beforeRouteLeave:(to, from, next) => {
        console.log('离开路由之前！');
       next();
      },
      methods:{
        getData:function () {
          this.axios({
            method:'get',
            url:'http://localhost:8080/static/mock/data.json'
          }).then(function (response) {
            console.log(response)
          })
        }
      }
    }
</script>

<style scoped>

</style>
