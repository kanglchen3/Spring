<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2020/9/15
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script>
        var userList = new Array();
        userList.push({username: "zhangsan", age: 18});
        userList.push({username: "lisi", age: 19});

        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/tt15",
            data: JSON.stringify(userList),
            contentType: "application/json;charset=utf-8"
        })
    </script>
</head>
<body>

</body>
</html>
