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
    <title>个人月度订单统计</title>

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
<div id="main"  style="margin: 30px 50px;">
    <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black;flex-wrap: wrap">
        <div style="width: 100%;margin: 10px 0;text-align: center">个人月度订单汇总</div>
        <div style="width: 100%;display: flex;flex-direction: row;margin: 10px 0 5px 0;">
            <div style="width: 20%;padding-left: 20px">员工：${username}</div>
            <div style="width: 40%;padding-left: 5px">联系电话：${phone}</div>
            <div style="width: 40%;padding-left: 5px">统计月份：${starttime}——${nowtime}</div>
        </div>

    </div>
    <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
        <div style="width: 25%;padding: 5px;text-align: center;">时间</div>
        <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">菜名</div>
        <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">单位</div>
        <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">分量</div>
        <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">单价</div>
        <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">合计</div>
    </div>

<c:forEach items="${order}" var = "order" varStatus="s">
    <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
        <div style="width: 25%;padding: 5px;text-align: center;">${order.date}</div>
        <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.menuname}</div>
        <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.unit}</div>
        <div style="width: 5%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.number}</div>
        <div style="width: 10%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.money}</div>
        <div style="width: 25%;border-left: 1px solid black;padding: 5px;text-align: center;">${order.thistotalmoney}</div>
    </div>
</c:forEach>

    <div style="width: 100%;border: 1px solid black;text-align: right;">
        <div style="margin: 10px 10px 10px 0">合计金额：¥${totalmoney}</div>
    </div>

    <div style="width: 100%;display: flex;flex-direction: row;border: 1px solid black">
        <div style="width: 50%;padding-left: 20px;margin-top: 10px;margin-bottom: 10px">操作员:${username}</div>
        <div style="width: 50%;margin-top: 10px;margin-bottom: 10px">操作时间：${nowtime}</div>

    </div>

</div>
<div id="anniu" style="width: 100%;display: flex;justify-content: center">
    <a href="${pageContext.request.contextPath}/maincaidanServlet"><button class="btn" >返回</button></a>
    <div style="width: 5px"></div>
<button class="btn btn-success" onclick="windowprint();">打印</button>
</div>
</body>
</html>
