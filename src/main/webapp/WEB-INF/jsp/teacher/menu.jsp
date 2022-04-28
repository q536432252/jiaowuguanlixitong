<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/7
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <%--开启el表达式--%>
    <%@ page  isELIgnored="false"%>
    <%--//日期格式转化--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%--c jsp c开头的标签--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%--shiro标签--%>
    <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
</head>
<body>

        <div class="col-lg-2">
            <div class="panel panel-primary" >
                <div class="panel-heading">
                    <h4 style="text-align: center">菜单栏</h4>
                </div>
                <ul class="list-group" style="text-align: center">
                    <li class="list-group-item"><a href="/teacher/showCourse">我的课程</a></li>
                    <li class="list-group-item"><a href="/teacher/passwordRest">修改密码</a></li>
                    <li class="list-group-item"><a href="/logout">退出系统</a></li>
                </ul>
            </div>
        </div>

</body>
</html>
