<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
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
    <title>确认菜单</title>

    <!-- CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Query -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>确认是否上传该菜单</h3>
    <form action="${pageContext.request.contextPath}/CaidanUplastServlet" method="post"  >
        <div class="form-group">
            <label for="ordernumber">菜单号：</label>
            <input type="text" class="form-control" id="ordernumber" name="ordernumber" value="${caidan.ordernumber}" readonly="readonly" >
        </div>
        <div class="form-group">
            <label for="date">形成菜单时间：</label>
            <input type="text" class="form-control" id="date" name="date" value="${caidan.date}"  readonly="readonly">
        </div>


        <div class="form-group">
            <label for="operator">操作人员：</label>
            <input type="text" class="form-control" id="operator" name="operator" value="${caidan.operator}" readonly="readonly">
        </div>
        <div class="form-group">

            <input type="hidden" class="form-control" id="status" name="status"  value="1" >
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="上传" />

            <a href="${pageContext.request.contextPath}/FindCaidanServlet">  <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>
</body>
</html>
