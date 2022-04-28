<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/7
  Time: 16:01
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
    <%--当页面变大 两边会有边距，居中效果--%>
    <div class="container">
        <div class="col-lg-14">
            <div class="panel panel-primary">
                <div class="panel-heading">
                   <%-- <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>教务管理系统</th>
                        </tr>
                        </thead>
                    </table>--%>
                    <div class="row">
                        <h1 class="col-lg-14" style="text-align: center">教务管理系统(学生账户)</h1>
                        <span class="col-lg-12"  style="text-align: right;"><a style="color: white;" href="/logout">退出</a></span>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
