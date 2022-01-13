## axios使用

* cmd命令：cnpm install axios -s

* 在main.js中import axios from 'axios'

* ```vue
  import axios from 'axios'
  import VueAxios from 'vue-axios'
  
  Vue.use(VueAxios, axios)
  ```

```vue
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
```

