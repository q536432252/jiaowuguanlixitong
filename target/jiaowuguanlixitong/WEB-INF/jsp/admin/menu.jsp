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
</head>
<body>

        <div class="col-lg-2">
            <div class="panel panel-primary" >
                <div class="panel-heading">
                    <h4 style="text-align: center">菜单栏</h4>
                </div>
                <ul class="list-group" style="text-align: center">
                    <li class="list-group-item"><a href="/admin/showCourse">课程管理</a></li>
                    <li class="list-group-item"><a href="/admin/showStudent">学生管理</a></li>
                    <li class="list-group-item"><a href="/admin/showTeacher">教师管理</a></li>
                    <li class="list-group-item"><a href="/admin/userPasswordRest">修改其他用户密码</a></li>
                    <li class="list-group-item"><a href="/admin/passwordRest">修改密码</a></li>
                    <li class="list-group-item"><a href="/logout">退出系统</a></li>
                </ul>
            </div>
        </div>

</body>
</html>
