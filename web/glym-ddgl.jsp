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
    <title>订单管理</title>

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
    <script>
        function delorder (ordernumber) {
            console.log("我能过来")
            if (confirm("您确定要删除此订单吗")){
                location.href="${pageContext.request.contextPath}/DelorderServlet?ordernumber=" + ordernumber;
            }

        }
    </script>
</head>
<body>
<c:choose>
    <c:when test="${orders.size() == 0}">
        <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
            <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
            <p style="width: 100%;text-align: center;color: #8a8a8a">还没有任何订单喔~</p>
        </div>
    </c:when>
    <c:otherwise>

        <div class="container">
            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <th>序号</th>
                    <th>订单号</th>
                    <th>形成订单时间</th>
                    <th>操作人员</th>
                    <th>总金额</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${orders}" var = "order" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${order.ordernumber}</td>
                        <td>${order.date}</td>
                        <td>${order.name}</td>
                        <td>${order.totalmoney}</td>
                        <td>
                            <a class="btn btn-default btn-sm" href="#">打印</a>&nbsp;
                            <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindorderitemServlet?ordernumber=${order.ordernumber}">查看订单详情</a>&nbsp;

                            <a class="btn btn-default btn-sm" href="javascript:delorder('${order.ordernumber}');">删除此订单</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </c:otherwise>
</c:choose>

</body>
</html>
