<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        //编写一个javascript对象
        var obj={
            name:"秦僵",
            age:3,
            sex:"男"
        };
        var json=JSON.stringify(obj);
        console.log("json字符串"+json);
        console.log(obj);

        console.log("===================================")

        //将json对象转为JavaScript对象
        var obj2=JSON.parse(json);
        console.log(obj2);
    </script>
</head>
<body>

</body>
</html>
