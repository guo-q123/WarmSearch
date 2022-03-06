<h1 align="center"> 校园失物招领网站</h1>


### 项目介绍 :book:

👉基于Springboot+vue+uni-app的校园失物招领平台. 含平台主体PC端、微信小程序和web后台数据管理平台.

* 失物招领信息一览
* 信息发布(支持图片上传)


### 项目技术栈 :star:


- PC端（WarmSearch-PC)：`Vue 2.0`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`
- 后台管理系统(WarmSearch-Web)：基于Vue-admin-ui脚手架
- 微信小程序(WarmSearch-uniapp)：uni-app + Vue.js
- 后端(WarmSearch)：Springboot 2.4.2 + Java Web Token +MybatisPlus + Swagger 
- 数据库：MySql 5.7

项目采用前后端分离开发模式，PC端使用:Vue + Element-ui, 小程序使用Uni-app开发，后端数据API采用Java、Spring-Boot开发.

演示视频：[在线演示视频](https://www.bilibili.com/video/BV1f54y1j7sG)



## 说明

> 本项目前后端分离，前端(WarmSearch-PC）[参考锤子商城](https://www.smartisan.com/)


![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/0E503FDA.gif)

- 总体架构

  总体设计按“前后端分离”方式，当浏览器请求页面或静态资源时，HTTP Server直接响应；当浏览器请求数据时，该请求仍然先发给HTTP Server，经由该Server转发至Web APP Server。Web APP Server业务处理后将结果数据返回给HTTP Server，最终返回浏览器。在此过程中，Web APP Server返回的仅仅是数据（json格式），没有任何与显示（视图）相关的信息，做到了完全的前后端分离，前端负责页面与展示，后端负责业务处理与数据。

## 技术栈

- 前台页面展示系统（WarmSearch-PC)：`Vue`+`Vue-router`+`Vuex`+`Element-ui`+`Axios`
- 后台管理系统：基于Vue-admin-ui脚手架
- 微信小程序：uni-app + Vue.js
- 后端：Springboot + Java Web Token +MybatisPlus + Swagger 框架
- 数据库：MySql

## 功能模块


#### 1.前台页面展示（WarmSearch-PC)

- ###### WarmSearch-PC首页部分展示

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/pc首页.png)

- 物品详情页

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/物品详情页.png)

- ###### 寻失物部分页面展示

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/寻物.png)

- #####  认领页面
![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/物品详情页2.png)

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/认领页.png)

- ##### 信息发布页面

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/信息发布页.png)

- ###### 寻失主部分页面展示

![img](https://cdn.jsdelivr.net/gh/lijinghailjh/cdn/img/失物招领.assets/image-20210327001747782.png)

