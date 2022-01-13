<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/18
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <style>
        #top{
            width: 100%;
            height: 150px;
            background-image: url("static/img/main.jpg");
            background-repeat: no-repeat;
            background-size: 100% 150px;
        }
        #top>h2{
            color: white;
            margin-left: 30px;
            padding-top: 50px;
        }
        #info_table{
            width: 700px;
            margin: 0 auto;
            /*background-color: red;*/
        }
        #info_table>table{
            border: 1px solid green;
        }

        tr:nth-child(2n){
            background-color: #f5f5f0;
        }
        #line {
            width: 0;
            height: 167px;
            border-left: 1px solid #cbcece;
            margin-left: 658px;
            margin-top: -169px;
        }
        .watch_messager{
            width: 150px;
            height: 50px;
            margin-left: 600px;
            margin-top: 10px;
            font-size: 18px;
        }
        .watch_messager:hover{
            cursor: pointer;
        }

    </style>
</head>
<body>
    <div id="top">
        <h2>全国大学四六级考试报名网</h2>
    </div>
    <h2 style="color: blue;text-align: center">欢迎黄少伟登陆CET考试报名系统</h2>
    <div id="info_table">
        <table cellpadding="0" cellspacing="0" id="main_table">
            <tr style="background-color: skyblue;">
                <td style="width:100px;display:block;margin-left: 246px">基本信息</td>
                <td></td>
            </tr>
            <tr class="one">
                <td>考次名称</td>
                <td>2021年上半年CET考试</td>
            </tr>
            <tr>
                <td>学籍与资格状态</td>
                <td>已确认</td>
            </tr>
            <tr>
                <td>笔试报考状态</td>
                <td>已报考</td>
            </tr>
            <tr>
                <td>笔试支付状态</td>
                <td>已支付</td>
            </tr>
            <tr>
                <td>口试报考状态</td>
                <td>未报考</td>
            </tr>
            <tr>
                <td>报名时间</td>
                <td>2021-3-26 10:30至2021-04-06 17:00</td>
            </tr>
            <tr>
                <td>残疾考生合理便利线下申请截止时间</td>
                <td>2021-04-19</td>
            </tr>
            <tr>
                <td>笔试准考证打印开始时间</td>
                <td>2021-06-01</td>
            </tr>
        </table>
    </div>
<div id="line"></div>
<button class="watch_messager">查看报名信息</button>
</body>
</html>
