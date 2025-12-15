<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>菜谱管理</title>

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


        function delmenu(id) {
            if (confirm("您确定要删除此菜谱吗")){
                location.href="${pageContext.request.contextPath}/DeleteRecipeServlet?id="+id;
            }

        }


        window.onload = function () {


            document.getElementById("delselected").onclick = function () {

                if (confirm("您确定要删除选中的菜谱吗")) {
                    var flag = false;
                    //防止空指针异常
                    var cds = document.getElementsByName("mid");
                    for (var i = 0; i < cds.length; i++) {
                        if (cds[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("delselectform").submit();
                    } else {
                        window.alert("您未选择任何项，请注意操作！")
                    }

                }

            }

            document.getElementById("firstid").onclick = function () {
                var cds = document.getElementsByName("mid");

                for (var i = 0; i < cds.length; i++) {
                    cds[i].checked = this.checked;
                }
            }



        }

        function addmenuform() {

            if (confirm("您是否新建一个菜单吗")) {
                var flag = false;
                //防止空指针异常
                var cds = document.getElementsByName("mid");
                for (var i = 0; i < cds.length; i++) {
                    if (cds[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    var action = excel.action;
                    var url= "${pageContext.request.contextPath}/MakeCaidanServlet";
                    excel.action=url;
                    excel.submit();
                    excel.action = action;



                } else {
                    window.alert("您未选择任何项，请注意操作！")
                }

            }
        }

    </script>
</head>
<body>
<div style="display: flex;justify-content: space-between;width: 100%;align-items: center;">
    <div style="display: flex;align-items: center;margin-left: 30px;">
        <img src="imgs/caozuo.png" style="width: 30px;height: 30px">
    </div>
<div style="margin-right: 40px;">
    <a id="hiddenprint3" class="btn btn-primary"  href="glym-addrecipe.jsp">添加菜谱</a>
    <a class="btn btn-primary"  href="javascript:void(0)" id="delselected">删除选中菜谱</a>
    <a class="btn btn-primary" onclick="addmenuform()" id="addmenuform">形成菜单</a>
</div>
</div>



<div style="height: 20px;width: 100%"></div>

<div class="container">

    <form id="delselectform" name="excel" action="${pageContext.request.contextPath}/DelSelectedRecipeServelet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success" style="font-size: 14px">
                <th><input type="checkbox" id="firstid"></th>
                <th>序号</th>
                <th>菜谱种类</th>
                <th>菜谱名</th>
                <th>菜谱图片</th>
                <th>单位</th>
                <th>单位价格</th>
                <th>烹饪说明</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${recipe}" var = "recipe" varStatus="s">
                <tr style="font-size: 14px">
                    <td><input type="checkbox" name="mid" id="mid" value="${recipe.id}" ></td>
                    <td name="xh" >${s.count}</td>
                    <td>${recipe.kind}</td>
                    <td name="menuname">${recipe.menuname}</td>
                    <td><img src="${pageContext.request.contextPath}/${recipe.menupicture}" style="width: 40px;height: 30px;"></td>
                    <td>${recipe.unit}</td>
                    <td>${recipe.money}</td>
                    <td>${recipe.remarks}</td>
                    <td >
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindRecipeServlet?id=${recipe.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:delmenu(${recipe.id});">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>
</body>
</html>
