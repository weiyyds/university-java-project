## vue的简写

v-bind

* 缩写:

* 1.绑定文本

* 直接用v-bind或者{{}}

* ```vue
  <p v-bind="message"></p>
  <p>{{message}}</p>
  ```

* 2.绑定属性

* ```vue
  <p v-bind:src="http://...."></p>
  <p v-bind:class="http://...."></p>
  <p v-bind:style="http://...."></p>
  ```

1.v-bind用来绑定数据和属性以及表达式，缩写为'：'
2.v-model使用在表单中，实现双向数据绑定的，在表单元素外使用不起作用