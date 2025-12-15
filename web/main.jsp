<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>点餐页面</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pure.css">

    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script language="JavaScript" type="text/javascript">
        function add (id) {
            if (confirm("加入订单！")){
                location.href="${pageContext.request.contextPath}/AddServlet?id=" + id;
            }
        }
    </script>
</head>

<style>

</style>
<body >

<div >
    <span style="align-content: center;font-size: 45px;color: #dca7a7">五邑网络餐厅点餐系统</span>
    <div style="float: right">
        <ul class="layui-nav">
            <li class="layui-nav-item"><a href="FindmyorderServlet">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-checklist" viewBox="0 0 16 16">
                    <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                    <path d="M7 5.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0zM7 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z"/>
                </svg>我的订单</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/grydtjServlet"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
                <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
            </svg>个人月度订单</a></li>
            <li class="layui-nav-item"><a href="findgrxx?username=${User.username}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
            </svg>修改个人信息</a></li>
            <li class="layui-nav-item"><a href="person.jsp"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-vcard" viewBox="0 0 16 16">
                <path d="M5 8a2 2 0 1 0 0-4 2 2 0 0 0 0 4Zm4-2.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5ZM9 8a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4A.5.5 0 0 1 9 8Zm1 2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1-.5-.5Z"/>
                <path fill-rule="evenodd" d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2ZM1 4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H8.96c.026-.163.04-.33.04-.5C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1.006 1.006 0 0 1 1 12V4Z"/>
            </svg>个人信息</a></li>

            <li class="layui-nav-item">
                <c-if test="${user.wisdom=='admin'}">
                    <div style="display: flex;flex-direction: row">
                    <a href="index.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-layout-text-window-reverse" viewBox="0 0 16 16">
                    <path d="M13 6.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm-.5 2.5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1 0-1h5z"/>
                    <path d="M14 0a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12zM2 1a1 1 0 0 0-1 1v1h14V2a1 1 0 0 0-1-1H2zM1 4v10a1 1 0 0 0 1 1h2V4H1zm4 0v11h9a1 1 0 0 0 1-1V4H5z"/>
                    </svg>后台管理系统
                     </a>
                    </div>
                </c-if>
            </li>
            <li class="layui-nav-item">
                <form  action="outServlet" method="post">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-toggle2-off" viewBox="0 0 16 16">
                        <path d="M9 11c.628-.836 1-1.874 1-3a4.978 4.978 0 0 0-1-3h4a3 3 0 1 1 0 6H9z"/>
                        <path d="M5 12a4 4 0 1 1 0-8 4 4 0 0 1 0 8zm0 1A5 5 0 1 0 5 3a5 5 0 0 0 0 10z"/>
                    </svg>
                    <input type="submit" style="color: #0000FF;size: 30px" value="退出登录">
                </form>
            </li>
        </ul>
    </div>
</div>

<%--<div style="width: 100%;height: 40px;display: flex;flex-direction: row;justify-content: space-between;background-color: rgb(57,61,73);color: white">--%>
<%--&lt;%&ndash;    <div style="display: flex;flex-direction: row;padding: 5px">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div style="padding: 0 5px">登录账户：${User.username}</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div style="padding: 0 5px">姓名：${User.name}</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div style="padding: 0 5px">部门：${User.status}</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <div style="padding: 0 5px">身份：${User.wisdom}</div>&ndash;%&gt;--%>
<%--    </div>--%>
<%--    <div style="display: flex;flex-direction: row">--%>
<%--    <a href="index.jsp" style="color: white">后台系统</a>--%>
<%--    <form  action="outServlet" method="post">--%>
<%--        <input type="submit" style="color: red" value="退出登录">--%>
<%--    </form>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<div style="display: flex;justify-content: space-between;width: 1400px;flex-direction: row;">--%>

<div>
    <form action="" method="post" >
        <table class="pure-table pure-table-bordered" style="width: 1000px">
            <thead>
            <tr>
                <th>序号</th>
                <th>名字</th>
                <th>图片</th>
                <th>单价</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
             <c:forEach items="${caidanlist}" var = "caidanlist" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${caidanlist.menuname}</td>
                <td><img src="${pageContext.request.contextPath}/${caidanlist.menupicture}" style="width: 100px;height: 100px"></td>
                <td>价格${caidanlist.money}</td>
                <td><a href="javascript:add('${caidanlist.id}');" style="color: red">加入订单</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>


<div style="background-color: rgb(245,246,247);width: 500px;height: 200px">
<%--    <img src="imgs/gouwuche.png" style="height: 20px;width:20px;margin-right: 5px;text-align: center">--%>
    <div style="margin: 10px 30px;"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-plus" viewBox="0 0 16 16">
        <path d="M9 5.5a.5.5 0 0 0-1 0V7H6.5a.5.5 0 0 0 0 1H8v1.5a.5.5 0 0 0 1 0V8h1.5a.5.5 0 0 0 0-1H9V5.5z"/>
        <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
    </svg>
        订单预览</div>
    <c:choose>
        <c:when test="${foodlist2 == null || foodlist2.size()==0}">
            <div style="margin: 80px auto;display: flex;justify-content: center;flex-wrap: wrap">
                <p style="display: flex;justify-content: center;width: 100%"><img src="imgs/null.png" style="width: 80px;height: 80px;"></p>
                <p style="width: 100%;text-align: center;color: #8a8a8a">订单为空!</p>
            </div>
        </c:when>
        <c:otherwise>
            <form style="margin: 30px" action="xiadanservlet" method="post">
                <table class="pure-table pure-table-bordered">
                    <thead>
                    <tr>
                        <th>菜谱编号</th>
                        <th>菜谱名字</th>
                        <th>菜谱种类</th>
                        <th>单位</th>
                        <th>单位价格</th>
                        <th>数量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${foodlist2}" var = "food" varStatus="a">
                        <tr>
                            <td>${food.menunumber}</td>
                            <td>${food.menuname}</td>
                            <td>${food.kind}</td>
                            <td>${food.unit}</td>
                            <td>${food.money}</td>
                            <td><input type="number" value="${food.number}" min="1" id="number" name="number"> </td>
                            <td >
                                <a  href="DelServlet?menunumber=${food.menunumber}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div style="margin-top: 20px;display: flex;justify-content: center">
                    <button type="submit" class="button-success pure-button">确认下单</button>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
</div>
<%--</div>--%>
</body>
</html>
