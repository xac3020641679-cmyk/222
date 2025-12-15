<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
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
    <title>当天菜肴统计</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure.css">
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<c:choose>
<c:when test="${namelist2.size() == 0}">
    <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
    <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
    <p style="width: 100%;text-align: center;color: #8a8a8a">今天还没有订餐记录喔~</p>
    </div>
</c:when>
<c:otherwise>
<div>出现的菜品有</div>
<c:forEach items="${namelist2}" var = "name" varStatus="s">
    <div style="display: flex;flex-direction: row;flex-wrap: wrap;width: 100%"><div>${name.mennuname}、</div></div>
</c:forEach>
<div style="height: 20px;width: 100%"></div>

<table class="pure-table pure-table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>序号</th>
        <th>菜单名字</th>
        <th>烹饪说明</th>
        <th>数量统计</th>
    </tr>
    </thead>

    <tbody>
<c:forEach items="${namelist2}" var = "name" varStatus="s">
    <tr>

        <td >${s.count}</td>
        <td >${name.mennuname}</td>
        <td >${name.remarks}</td>
        <td >${name.number}</td>
    </tr>
</c:forEach>

    </tbody>
</table>
</c:otherwise>
</c:choose>
</body>
</html>
