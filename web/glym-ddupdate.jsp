
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
    <title>修改订单内容信息</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="padding: 5px 30px;">
    <h3 style="text-align: center;">修改订单内容信息</h3>
    <form action="${pageContext.request.contextPath}/updateorderServlet" method="post">
        <%--            隐藏域--%>
        <input type="hidden" name="id" value="${order.id}">
        <input type="hidden" name="ordernumber" value="${ordernumber}">
        <div class="form-group">
            <label for="menunumber">菜谱编号（不可修改）：</label>
            <input type="text" class="form-control" id="menunumber" name="menunumber" value="${order.menunumber}"  readonly="readonly" />
        </div>

            <div class="form-group">
                <label for="menuname">菜谱名字（不可修改）：</label>
                <input type="text" class="form-control" id="menuname" name="menuname" value="${order.menuname}"  readonly="readonly" />
            </div>

            <div class="form-group">
                <label for="unit">单位（不可修改）：</label>
                <input type="text" class="form-control" id="unit" name="unit" value="${order.unit}"  readonly="readonly" />
            </div>
            <div class="form-group">
                <label for="money">价格（不可修改）：</label>
                <input type="text" class="form-control" id="money" name="money" value="${order.money}"  readonly="readonly" />
            </div>
            <div class="form-group">
                <label for="number">数量：</label>
                <input type="number" class="form-control" id="number" name="number" value="${order.number}" min="1" />
            </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <a href="FindorderitemServlet?ordernumber=${ordernumber}">返回</a>
        </div>
    </form>
</div>
</body>
</html>