<%--
  Created by IntelliJ IDEA.
  User: NHP
  Date: 2022/11/15
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>月度订单统计</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<c:choose>
    <c:when test="${orderitemstj.size() == 0}">
        <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
            <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
            <p style="width: 100%;text-align: center;color: #8a8a8a">这个月还没有订餐记录喔~</p>
        </div>
    </c:when>
    <c:otherwise>
        月度订单统计
        统计${month}月份
        <table class="pure-table pure-table-bordered" style="width: 100%">
            <thead>
            <tr>
                <th>菜名字</th>
                <th>菜单价</th>
                <th>总下单数</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach items="${orderitemstj}" var = "name" varStatus="s">
                <tr>
                    <td>${name.mennuname}</td>
                    <td>${name.money}</td>
                    <td>${name.cishu}次</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>总金额为：${totalmoney}</div>
    </c:otherwise>
</c:choose>
</body>
</html>
