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
    <title>餐品订单统计</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<form action="TONGJIServlet" method="post">
<label>
    <span>选择开始日期</span>
    <input type="datetime-local" step="1"  class="measureDate" id="start" name="start" placeholder="请选择日期">
    <span>选择结束日期</span>
    <input type="datetime-local" step="1" class="measureDate" id="end" name="end" placeholder="请选择日期">
</label>
    <button type="submit">开始查询</button>

    <c:if test="${orderitemstj != null}">
        <div>统计开始日期：${starttime}</div>
        <div>统计结束日期：${endtime}</div>
        <div>总金额：${totalmoney}</div>
    <c:choose>
        <c:when test="${orderitemstj.size() == 0}">
            <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
                <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
                <p style="width: 100%;text-align: center;color: #8a8a8a">所选范围时间还没有订餐记录喔~</p>
            </div>
        </c:when>
        <c:otherwise>
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
        </c:otherwise>
    </c:choose>
    </c:if>

</form>
</body>
</html>
