<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>菜单管理</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success" style="font-size: 14px">
                <th>序号</th>
                <th>用户名</th>
                <th>姓名</th>
                <th>电话</th>
                <th>下单次数</th>
                <th>下单总金额</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${usertj}" var = "usertj" varStatus="s">
                <tr style="font-size: 14px">
                    <td >${s.count}</td>
                    <td >${usertj.username}</td>
                    <td>${usertj.name}</td>
                    <td >${usertj.phone}</td>
                    <td>${usertj.cishu}</td>
                    <td>${usertj.totalmoney}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findgrydtjServlet?username=${usertj.username}">查看个人月度统计</a>&nbsp;
                    </td>
                </tr>
            </c:forEach>

        </table>
</div>
</body>
</html>
