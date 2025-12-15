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
    <title>添加菜谱</title>

    <!-- CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Query -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

        function add() {
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


            $("#AddRecipe").submit();


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
<div class="container" style="padding: 5px 30px;">
    <h3>添加菜谱页面</h3>
    <form id="AddRecipe" action="AddRecipeServlet" method="post" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="kind">菜谱种类：</label>
            <input type="text" class="form-control" id="kind" name="kind" >
        </div>


        <div class="form-group">
            <label for="menuname">菜谱名字：</label>
            <input type="text" class="form-control" id="menuname" name="menuname" >
        </div>

        <div class="form-group">
            <label for="myfile">菜谱图片：</label>
            <input type="file"  id="myfile" name="myfile" >
        </div>

        <div class="form-group">
            <label for="unit">单位：</label>
            <input type="text" class="form-control" id="unit" name="unit" >
        </div>

        <div class="form-group">
            <label for="money">单位价格：</label>
            <input type="text" class="form-control" id="money" name="money" >
        </div>


        <div class="form-group">
            <label for="remarks">烹饪说明：</label>
            <input type="text" class="form-control" id="remarks" name="remarks" >
        </div>

        <span class="msg" id="msg" style="color: red" ></span>
        <div class="form-group" style="text-align: center">
            <button class="btn btn-primary" type="button" onclick="add()"  >添加</button>
            <a href="${pageContext.request.contextPath}/ShowrecipeServlet">  <input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>
</body>
</html>
