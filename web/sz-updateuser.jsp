
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改个人信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="padding: 5px 30px;">
    <h3 style="text-align: center;">修改个人信息</h3>
    <form action="${pageContext.request.contextPath}/updateszuser" method="post">
        <%--            隐藏域--%>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="username">用户名（不可修改）：</label>
            <input type="text" class="form-control" id="username" name="username" value="${user.username}"  readonly="readonly" />
        </div>

        <div class="form-group">
            <label for="password">修改密码：</label>
            <input type="text" class="form-control" id="password" name="password"  value="${user.password}"    />
        </div>

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}"  />
        </div>
        <div class="form-group">
            <label for="status">部门：</label>
            <input type="text" class="form-control" id="status" name="status" value="${user.status}"   />
        </div>
        <div class="form-group">
            <label for="phone">手机号：</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}"   />
        </div>
            <div class="form-group">
                <label for="wisdom">权限：</label>
                <input type="text" class="form-control" id="wisdom" name="wisdom" value="${user.wisdom}"   />
            </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a href="UsershezhiServlet">返回</a>
        </div>
    </form>
</div>
</body>
</html>