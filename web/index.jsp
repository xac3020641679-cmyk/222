
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>后台页面</title>
  <link rel="stylesheet" href="./layui/css/layui.css">
  <style>
    .layui-this>a:hover{background-color: rgb(200,180,90);color:#1E9FFF;}
  </style>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs layui-bg-green">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-sidebar-reverse" viewBox="0 0 16 16">
            <path d="M12.5 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm0 3a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5zm.5 3.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
            <path d="M16 2a2 2 0 0 0-2-2H2a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2zM4 1v14H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h2zm1 0h9a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H5V1z"/>
        </svg>
        餐厅后台管理系统
    </div>
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item layui-show-xs-inline- layui-hide-sm" lay-header-event="menuLeft">
        <i class="layui-icon layui-icon-spread-left"></i>
      </li>
      <li class="layui-nav-item layui-hide-xs"><span id="times"></span></li>
    </ul>
      <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-video" viewBox="0 0 16 16">
                <path d="M8 9.05a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>
                <path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2Zm10.798 11c-.453-1.27-1.76-3-4.798-3-3.037 0-4.345 1.73-4.798 3H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-1.202Z"/>
            </svg>
          ${User.username}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;">姓名：${User.name}</a></dd>
          <dd><a href="javascript:;">部门：${User.status}</a></dd>
          <dd><a href="javascript:;">身份：${User.wisdom}</a></dd>
          <hr>
          <dd style="text-align: center;">
              <form class="tuichu" action="outServlet" method="post">
            <input type="submit" value="退出登录">
          </form></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>

  <div class="layui-side layui-bg-green">
    <div class="layui-side-scroll">

      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed" style="text-align: center">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-gear-fill" viewBox="0 0 16 16">
                    <path d="M7.293 1.5a1 1 0 0 1 1.414 0L11 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l2.354 2.353a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5Z"/>
                    <path d="M11.07 9.047a1.5 1.5 0 0 0-1.742.26l-.02.021a1.5 1.5 0 0 0-.261 1.742 1.5 1.5 0 0 0 0 2.86 1.504 1.504 0 0 0-.12 1.07H3.5A1.5 1.5 0 0 1 2 13.5V9.293l6-6 4.724 4.724a1.5 1.5 0 0 0-1.654 1.03Z"/>
                    <path fill-rule="evenodd" d="m13.158 9.608-.043-.148c-.181-.613-1.049-.613-1.23 0l-.043.148a.64.64 0 0 1-.921.382l-.136-.074c-.561-.306-1.175.308-.87.869l.075.136a.64.64 0 0 1-.382.92l-.148.045c-.613.18-.613 1.048 0 1.229l.148.043a.64.64 0 0 1 .382.921l-.074.136c-.306.561.308 1.175.869.87l.136-.075a.64.64 0 0 1 .92.382l.045.149c.18.612 1.048.612 1.229 0l.043-.15a.64.64 0 0 1 .921-.38l.136.074c.561.305 1.175-.309.87-.87l-.075-.136a.64.64 0 0 1 .382-.92l.149-.044c.612-.181.612-1.049 0-1.23l-.15-.043a.64.64 0 0 1-.38-.921l.074-.136c.305-.561-.309-1.175-.87-.87l-.136.075a.64.64 0 0 1-.92-.382ZM12.5 14a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3Z"/>
                </svg><a href="maincaidanServlet" style="font-size: 25px">前台点餐系统</a>
            </li>
        </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-ui-checks-grid" viewBox="0 0 16 16">
                  <path d="M2 10h3a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1v-3a1 1 0 0 1 1-1zm9-9h3a1 1 0 0 1 1 1v3a1 1 0 0 1-1 1h-3a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zm0 9a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h3a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-3zm0-10a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h3a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2h-3zM2 9a2 2 0 0 0-2 2v3a2 2 0 0 0 2 2h3a2 2 0 0 0 2-2v-3a2 2 0 0 0-2-2H2zm7 2a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2h-3a2 2 0 0 1-2-2v-3zM0 2a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm5.354.854a.5.5 0 1 0-.708-.708L3 3.793l-.646-.647a.5.5 0 1 0-.708.708l1 1a.5.5 0 0 0 .708 0l2-2z"/>
              </svg>
              管理页面</a>
          <dl class="layui-nav-child">
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="ShowrecipeServlet"
                   data-id="cpgl"
                   data-title="菜谱管理"
                   class="site-demo-active"
                   data-type="tabAdd"
            >菜谱管理</a></dd>
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="FindCaidanServlet"
                   data-id="cdgl"
                   data-title="菜单管理"
                   class="site-demo-active"
                   data-type="tabAdd"
            >菜单管理</a></dd>
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="FindOrderServlet"
                   data-id="ddgl"
                   data-title="订单管理"
                   class="site-demo-active"
                   data-type="tabAdd"
            >订单管理</a></dd>
          </dl>
        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-ui-radios-grid" viewBox="0 0 16 16">
                  <path d="M3.5 15a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5zm9-9a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5zm0 9a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zM16 3.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0zm-9 9a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0zm5.5 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zm-9-11a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm0 2a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7z"/>
              </svg>
              厨房管理</a>
          <dl class="layui-nav-child">
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="pcyglmainServlet"
                   data-id="dtcytj"
                   data-title="当天菜肴数量统计"
                   class="site-demo-active"
                   data-type="tabAdd"
            >当日菜单数量统计</a></dd>
          </dl>

        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="imgs/pcygl.png" style="height: 20px;width:20px;margin-right: 5px;">配餐员管理</a>
          <dl class="layui-nav-child">
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/pcytodayServlet"
                   data-id="jrdd"
                   data-title="今日批量订单"
                   class="site-demo-active"
                   data-type="tabAdd"
            >今日批量订单</a></dd>
          </dl>

        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="imgs/tjzx.png" style="height: 20px;width:20px;margin-right: 5px;">统计中心</a>

          <dl class="layui-nav-child">


            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="${pageContext.request.contextPath}/jrzkddServlet"
                   data-id="jrzkdd"
                   data-title="今日总括订单"
                   class="site-demo-active"
                   data-type="tabAdd"
            >今日总括订单</a></dd>

            <dd style="text-align: center;"><a href="javascript:;"
                     data-url="${pageContext.request.contextPath}/ydddtjServlet"
                     data-id="ydddtj"
                     data-title="月度订单统计"
                     class="site-demo-active"
                     data-type="tabAdd"
              >月度订单统计</a></dd>
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="tjzx-maintj.jsp"
                   data-id="cptj"
                   data-title="餐品订单统计"
                   class="site-demo-active"
                   data-type="tabAdd"
            >餐品订单统计</a></dd>
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="UsertjServlet"
                   data-id="yhtj"
                   data-title="用户统计"
                   class="site-demo-active"
                   data-type="tabAdd"
            >用户统计</a></dd>
          </dl>
        </li>
      </ul>

      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><img src="imgs/sz.png" style="height: 20px;width:20px;margin-right: 5px;">设置</a>
          <dl class="layui-nav-child">
            <dd style="text-align: center;"><a href="javascript:;"
                   data-url="UsershezhiServlet"
                   data-id="yhgl"
                   data-title="用户管理"
                   class="site-demo-active"
                   data-type="tabAdd"
            >用户管理</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>

  <div class="layui-body">

    <div style="padding: 15px;height: 500px;width: auto">
        <div class="layui-row layui-col-space15" style="padding: 0px">
          <div style="width: 99%;height: 99%" >
            <div class="layui-card">
              <div  style="margin: 0;line-height: 24px">
                <div class="layui-tab layui-tab-card layui-tab-brief" lay-allowclose="true" lay-filter="demo" style="width: 100%;height: 100%">
                  <ul class="layui-tab-title">
                    <li class="layui-this"><i class="layui-icon layui-icon-home" style="font-size:14px;color: #009688;font-weight: bold"></i>首页</li>
                  </ul>

                  <div class="layui-tab-content" style="height: 500px;">
                    <div class="layui-tab-item layui-show" style="text-align: center">
                        <h1>跨越山海，风味不改，无穷的远方，无穷的人们，都与美食相关。</h1>
                       <h2 style="margin-top: 30px">跨越高山、河流、海洋</h2>
                        <h2>不同的土地，碰撞出相似的美食</h2>
                        <h2>  人们从未停止寻找的脚步</h2>
                            <h2 style="margin-top: 20px">在风味中激发灵感</h2>

                                <h2>穿过昼夜、四季、三餐</h2>
                                    <h2> 迥异的文化，绽放出相同的热爱</h2>

                                        <h2>每种食物，都藏着别样的欢欣</h2>
                                            <h2>每种味道，都蕴含多彩的幸福</h2>

                                                <h2 style="margin-top: 20px">遍寻全球 25 个国家和地区</h2>
                                                    <h2>   拍摄超过 300 种美食</h2>
                                                        <h2>   记录无数张动人的笑脸</h2>

                                                            <h2 style="margin-top: 20px"> 山川依旧</h2>
                                                                <h2> 风味不改</h2>

                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    </div>


  </div>


</div>
<script src="./layui/layui.js"></script>
<script>
  //JS
  layui.use(['element', 'layer', 'util'], function(){
    var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

    //头部事件
    util.event('lay-header-event', {
      //左侧菜单事件
      menuLeft: function(othis){
        layer.msg('展开左侧菜单的操作', {icon: 0});
      }
      ,menuRight: function(){
        layer.open({
          type: 1
          ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
          ,area: ['260px', '100%']
          ,offset: 'rt' //右上角
          ,anim: 5
          ,shadeClose: true
        });
      }
    });

    //时钟定时器
    setInterval(function () {
      let dateStr = "";
      let date = new Date();
      //单独的获取时间
      dateStr += date.getFullYear() + "年";
      dateStr += ((date.getMonth()+1)<10?"0"+(date.getMonth()+1):(date.getMonth()+1))+"月";
      dateStr += (date.getDate()<10?"0"+date.getDate():date.getDate())+"日";
      dateStr += (date.getHours()<10?"0"+date.getHours():date.getHours())+"时";
      dateStr += (date.getMinutes()<10?"0"+date.getMinutes():date.getMinutes())+"分";
      dateStr += (date.getSeconds()<10?"0"+date.getSeconds():date.getSeconds())+"秒";
      let xq = ["日","一","二","三","四","五","六"];
      dateStr += "    星期"+xq[date.getDay()];

      $("#times").text(dateStr);
    },1000);

    //触发事件
    var active = {
      //在这里给active绑定几项事件，后面可通过active调用这些事件
      tabAdd: function (url, id, title) {
        //新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
        //关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
        element.tabAdd('demo', {
          title: title,
          content: '<iframe data-frameid="' + id
                  + '" scrolling="auto" frameborder="0" src="'
                  + url + '" style="width:100%;height: 730px"></iframe>',
          id: id
          //规定好的id
        })
        element.render('tab');

      },
      tabChange: function (id) {
        //切换到指定Tab项
        element.tabChange('demo', id); //根据传入的id传入到指定的tab项
      },
      tabDelete: function (id) {
        element.tabDelete("demo", id);//删除
      },
      tabDeleteAll: function (ids) {//删除所有
        $.each(ids, function (i, item) {
          element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
        })
      },
    };

    //当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
    $('.site-demo-active').on(
            'click',
            function () {
              var dataid = $(this);

              //这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
              if ($(".layui-tab-title li[lay-id]").length <= 0) {
                //如果比零小，则直接打开新的tab项
                active
                        .tabAdd(dataid.attr("data-url"), dataid
                                .attr("data-id"), dataid
                                .attr("data-title"));
              } else {
                //否则判断该tab项是否以及存在

                var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
                $.each($(".layui-tab-title li[lay-id]"),
                        function () {
                          //如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
                          if ($(this).attr("lay-id") == dataid
                                  .attr("data-id")) {
                            isData = true;
                          }
                        })
                if (isData == false) {
                  //标志为false 新增一个tab项
                  active.tabAdd(dataid.attr("data-url"), dataid
                          .attr("data-id"), dataid
                          .attr("data-title"));
                }
              }
              //最后不管是否新增tab，最后都转到要打开的选项页面上
              active.tabChange(dataid.attr("data-id"));
            });

  });
</script>
</body>
</html>
