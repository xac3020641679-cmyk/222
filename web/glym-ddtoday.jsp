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
    <title>配餐员管理-今日批量订单</title>

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
    <c:when test="${todayorder.size() == 0}">
        <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
            <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
            <p style="width: 100%;text-align: center;color: #8a8a8a">今天还没有订餐记录喔~</p>
        </div>
    </c:when>
    <c:otherwise>
        <div id="main"  style="margin: 30px 50px;">
            <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
                <div style="width: 15%;padding: 5px;text-align: center;">时间</div>
                <div style="width: 15%;border-left: 1px solid black;padding: 5px;text-align: center;">菜名</div>
                <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">单位</div>
                <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">分量</div>
                <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">单价</div>
                <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">下单人</div>
                <div style="width: 20%;border-left: 1px solid black;padding: 5px;text-align: center;">下单电话</div>
                <div style="width: 20%;border-left: 1px solid black;padding: 5px;text-align: center;">合计</div>
            </div>

            <c:forEach items="${todayorder}" var = "order" varStatus="s">
                <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
                    <div style="width: 15%;padding: 5px;text-align: center;">${order.date}</div>
                    <div style="width: 15%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.menuname}</div>
                    <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.unit}</div>
                    <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.number}</div>
                    <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.money}</div>
                    <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.operator}</div>
                    <div style="width: 20%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.phone}</div>
                    <div style="width: 20%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.thistotalmoney}</div>
                </div>
            </c:forEach>

        </div>
        <div id="anniu" style="width: 100%;display: flex;justify-content: center">
            <button class="btn btn-success" onclick="windowprint();">打印</button>
        </div>
    </c:otherwise>
</c:choose>

</body>
</html>
