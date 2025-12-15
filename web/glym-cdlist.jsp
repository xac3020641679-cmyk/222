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
    <title>菜单项详情列表</title>

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



    <a id="hiddenprint1" class="btn btn-primary" style="display: flex;align-items: center;background-color: white;color: #952424;height: 40px" href="${pageContext.request.contextPath}/FindCaidanServlet">返回</a>



<div class="container">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>序号</th>
            <th>菜谱编号</th>
            <th>菜谱种类</th>
            <th>菜谱名</th>
            <th>菜谱图片</th>
            <th>单位</th>
            <th>单位价格</th>
            <th>烹饪说明</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${caidanlist}" var = "caidanlist" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${caidanlist.menunumber}</td>
                <td>${caidanlist.kind}</td>
                <td>${caidanlist.menuname}</td>
                <td><img src="${pageContext.request.contextPath}/${caidanlist.menupicture}" style="width: 40px;height: 30px;"></td>
                <td>${caidanlist.unit}</td>
                <td>${caidanlist.money}</td>
                <td>${caidanlist.remarks}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindCaidanupdateServlet?id=${caidanlist.id}&&ordernumber=${ordernumber}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/DeletecaidanitemServlet?id=${caidanlist.id}&&ordernumber=${ordernumber}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>

</div>
</body>
</html>
