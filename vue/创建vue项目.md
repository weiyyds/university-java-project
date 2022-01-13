### 创建vue项目

* 1.cmd命令

* vue init webpack hello-vue --offline
* enter，然后选择no，自己安装插件
* 2.安装路由插件
* npm install vue-router --save-dev
* 3.安装elementUi
* npm i element -S
* 如果安装遇到npm ERR! code UNABLE_TO_VERIFY_LEAF_SIGNATURE
  npm ERR! errno UNABLE_TO_VERIFY_LEAF_SIGNATURE
* 如下：npm config set strict-ssl false
  用完之后恢复：
  npm config set strict-ssl true
* 安装依赖
* npm install
* 安装cnpm淘宝镜像
* npm install -g cnpm --registry=https://registry.npm.taobao.org
* 安装SASS加载器
* cnpm install sass-loader node-sass --save-dev
* 启动测试
* npm run dev