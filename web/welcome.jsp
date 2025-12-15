
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="./layui/layui.js"></script>
</head>
<body>
<div class="layui-carousel" style="height: 500px;" id="test1" lay-filter="test1">
    <div carousel-item="" style="height: 500px">
        <div> <img src="${pageContext.request.contextPath}/imgs/1.jpg" style="height: 555px;width: 100%;object-fit: cover"   > </div>
        <div> <img src="${pageContext.request.contextPath}/imgs/2.jpg" style="height: 555px;width: 100%;object-fit: cover" > </div>
        <div> <img src="${pageContext.request.contextPath}/imgs/3.jpg" style="height: 555px;width: 100%;object-fit: cover" > </div>
    </div>
</div>
</body>
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;
        //常规轮播
        carousel.render({
            elem: '#test1'
            ,width:'100%'
            ,height:'555px'
            ,interval: 3000
            ,arrow: 'always'
            ,anim: 'fade'
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });
    });

</script>
</html>
