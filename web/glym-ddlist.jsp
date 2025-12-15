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
    <title>订单详情</title>

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
        function delorderitem(id,ordernumber) {
            if (confirm("您确定要删除此订单中的菜吗")){
                location.href="${pageContext.request.contextPath}/DelorderitemServlet?id="+id+"&&ordernumber="+ordernumber;
            }

        }
    </script>
</head>
<body>
<a id="hiddenprint1" class="btn btn-primary" style="display: flex;align-items: center;background-color: white;color: #952424;height: 40px" href="${pageContext.request.contextPath}/FindOrderServlet">返回</a>

<div class="container">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>序号</th>
            <th>订单号</th>
            <th>菜谱编号</th>
            <th>菜谱名</th>
            <th>单位</th>
            <th>单位价格</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${orderitems}" var = "orderitems" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${orderitems.ordernumber}</td>
                <td>${orderitems.menunumber}</td>
                <td>${orderitems.menuname}</td>
                <td>${orderitems.unit}</td>
                <td>${orderitems.money}</td>
                <td>${orderitems.number}</td>
                <td >
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/showorderServlet?id=${orderitems.id}&&ordernumber=${orderitems.ordernumber}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:delorderitem('${orderitems.id}','${orderitems.ordernumber}');">删除</a>
                        <%--                        <button class="btn btn-default btn-sm"  onclick="adddaizi(${recipe.id},${recipe.menunumber});">添加到袋子里</button>--%>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
