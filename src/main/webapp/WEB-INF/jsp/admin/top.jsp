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
    <%--开启el表达式--%>
    <%@ page  isELIgnored="false"%>
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
                        <h1 class="col-lg-14" style="text-align: center">教务管理系统(管理员账户) </h1>
                        <%--当前注册的用户 ： ${curCount}--%>
                        <span class="col-lg-12"  style="text-align: right;"><a style="color: white;" href="/logout">退出</a></span>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
