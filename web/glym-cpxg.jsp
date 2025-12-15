
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
    <title>修改菜谱</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

        function update() {
            var kind = $("#kind").val();
            var menuname = $("#menuname").val();
            var myfile =  $("#myfile").val();
            var unit =  $("#unit").val();
            var money = $("#money").val();
            var remarks = $("#remarks").val();

            if (isEmpty(kind)){
                $("#msg").html("种类不可为空");
                return;
            }
            if (isEmpty(menuname)){
                $("#msg").html("菜谱名字不可为空");
                return;
            }
            if (isEmpty(myfile)){
                $("#msg").html("图片不可为空");
                return;
            }

            if (isEmpty(unit)){
                $("#msg").html("单位不可为空");
                return;
            }
            if (isEmpty(money)){
                $("#msg").html("价格不可为空");
                return;
            }
            if (isEmpty(remarks)){
                $("#msg").html("烹饪说明不可为空");
                return;
            }


            $("#updayeRecipe").submit();


        }

        //专用方法：判断为空

        function isEmpty(str) {
            if (str == null || str.trim() == ""){
                return true;
            }
            return false;

        }


    </script>
</head>
<body>
<div class="container" style="padding: 5px 30px">
    <h3  style="text-align: center;">修改菜谱</h3>
    <form id="updayeRecipe" action="${pageContext.request.contextPath}/UpdateRecipeServlet" method="post" enctype="multipart/form-data">
        <%--            隐藏域--%>
        <input type="hidden" name="id" value="${Recipe.id}">
        <div class="form-group">
            <label for="kind">菜谱种类：</label>
            <input type="text" class="form-control" id="kind" name="kind" value="${Recipe.kind}"   />
        </div>

        <div class="form-group">
            <label for="menuname">菜谱名称：</label>
            <input type="text" class="form-control" id="menuname" name="menuname"  value="${Recipe.menuname}"    />
        </div>

        <div class="form-group">
            <label for="myfile">菜谱图片：</label>
            <img src="${pageContext.request.contextPath}/${Recipe.menupicture}" style="width: 50px;height: 50px">
            <input type="file"  id="myfile" name="myfile" value="${Recipe.menupicture}" >
        </div>
        <div class="form-group">
            <label for="unit">单位：</label>
            <input type="text" class="form-control" id="unit" name="unit" value="${Recipe.kind}"   />
        </div>
        <div class="form-group">
            <label for="money">单位价格：（谨慎修改，统计时若出现不同价格相同名称/编号会分开统计）</label>
            <input type="text" class="form-control" id="money" name="money" value="${Recipe.money}"   />
        </div>
        <div class="form-group">
            <label for="remarks">烹饪说明：</label>
            <input type="text" class="form-control" id="remarks" name="remarks" value="${Recipe.remarks}"   />
        </div>
            <span class="msg" id="msg" style="color: red" ></span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="update()"  >提交</button>
            <a href="${pageContext.request.contextPath}/ShowrecipeServlet"> <input class="btn btn-default" type="button" value="返回"/></a>
        </div>
    </form>
</div>
</body>
</html>