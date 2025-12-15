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
    <title>今日总括订单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">

    //直接在本窗口进行打印
    function windowprint() {
        //备份初始html
        var bodyHTML = window.document.body.innerHTML;
        window.document.body.innerHTML=$("#main").html();
        window.print();
        //恢复初始化页面
        window.document.body.innerHTML = bodyHTML;
        //刷新页面，防止因打印影响页面元素
        window.location.reload();

    }
</script>

<c:choose>
    <c:when test="${Jrzkddlist.size() == 0}">
        <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
            <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
            <p style="width: 100%;text-align: center;color: #8a8a8a">今天还没有订餐记录喔~</p>
        </div>
    </c:when>
    <c:otherwise>
        <div id="main"  style="margin: 30px 50px;">
            <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black;flex-wrap: wrap">
                <div style="width: 100%;margin: 10px 0;text-align: center">今日总括订单</div>
            </div>
            <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
                <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">菜品编号</div>
                <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">菜名</div>
                <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">数量</div>
                <div style="width: 15%;border-left: 1px solid black;padding: 5px;text-align: center;">单价</div>
                <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">合计</div>
            </div>

            <c:forEach items="${Jrzkddlist}" var = "Jrzkddlist" varStatus="s">
                <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
                    <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">${Jrzkddlist.menunumber}</div>
                    <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">${Jrzkddlist.menuname}</div>
                    <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">${Jrzkddlist.number}</div>
                    <div style="width: 15%;border-left: 1px solid black;padding: 5px;text-align: center;">${Jrzkddlist.money}</div>
                    <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">${Jrzkddlist.thistotalmoney}</div>
                </div>
            </c:forEach>

            <div style="width: 100%;border: 1px solid black;text-align: right;">
                <div style="margin: 10px 10px 10px 0">合计金额：¥${totalmoney}</div>
            </div>

            <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
                <div style="width: 50%;padding-left: 20px;margin-top: 10px;margin-bottom: 10px">操作员:${username}</div>
                <div style="width: 50%;margin-top: 10px;margin-bottom: 10px">操作时间：${nowTime}</div>

            </div>

        </div>
        <div id="anniu" style="width: 100%;display: flex;justify-content: center">
            <div style="width: 5px"></div>
            <button class="btn btn-success" onclick="windowprint();">打印</button>
        </div>
    </c:otherwise>
</c:choose>



</body>
</html>
