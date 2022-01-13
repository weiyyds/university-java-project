<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/22
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
<%--        数据：后台--%>
    </tbody>
</table>
</body>
<script>
    $("#btn").click(function () {
        //console.log("1111");
        $.post("${pageContext.request.contextPath}/a2",function (data) {
            //console.log(data);

            var html="";
            for (let i=0;i<data.length;i++){
                html+="<tr>"+
                        "<td>"+data[i].name+"</td>"+
                    "<td>"+data[i].age+"</td>"+
                    "<td>"+data[i].sex+"</td>"+
                    "</tr>"
            }

            $("#content").html(html);
        })
    })


</script>
</html>
