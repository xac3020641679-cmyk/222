<%--
  Created by IntelliJ IDEA.
  User: y
  Date: 2023/12/15
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<div style="display: flex;flex-direction: row;padding: 5px">
    <div style="padding: 0 5px">登录账户：${User.username}</div>
    <div style="padding: 0 5px">姓名：${User.name}</div>
    <div style="padding: 0 5px">部门：${User.status}</div>
    <div style="padding: 0 5px">身份：${User.wisdom}</div>
</div>
</body>
</html>
