<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/11
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateStudent</title>
    <%--开启el表达式--%>
    <%@ page  isELIgnored="false"%>
    <%--//日期格式转化--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%--c jsp c开头的标签--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="panel panel-primary">
                <div class="panel-heading" style="text-align: center">
                    <h1>修改信息</h1>
                </div>

    <form action="/admin/updateTeacher" method="post">
        <table class="table table-bordered">
            <tr >
                <td class="col-lg-5" style="text-align: right" > 教师编号：</td>
                <td style="text-align: left"><input type="text" name="userID" value="${teacherCustom.userID}" readonly="readonly"></td>
            </tr>
            <tr>
                <td  style="text-align: right">姓名：</td>
                <td><input type="text" name="userName" value="${teacherCustom.userName}"></td>
            </tr>
            <tr>
                <td  style="text-align: right">性别：</td>
                <td>
                    <input type="radio" name="sex" value="男" checked>男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td  style="text-align: right">出生年份：</td>
                <td><input type="date" value="<fmt:formatDate value="${teacherCustom.birthYear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthYear"/></td>
            </tr>
            <tr>
                <td  style="text-align: right">学历:</td>
                <td><input type="text" name="degree" value="${teacherCustom.degree}"></td>
            </tr>
            <tr>
                <td  style="text-align: right">职称:</td>
                <td><input type="text" name="title" value="${teacherCustom.title}"></td>
            </tr>
            <tr>
                <td  style="text-align: right">入职年份：</td>
                <td><input type="date" value="<fmt:formatDate value="${teacherCustom.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/></td>
            </tr>
            <tr>
                <td  style="text-align: right">学院：</td>
                <td>
                    <select class="form-control" name="collegeID">
                        <c:forEach items="${collegeList}" var="item">
                            <option value="${item.collegeID}">${item.collegeName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td style="text-align: right"><input type="submit" value="修改"></td>
                <td><input type="button" value="返回" onclick="location.href='/admin/showTeacher'"></td>
            </tr>
        </table>

    </form>
</div>

            <%-- 教师编号：<input readonly="readonly"  type="text" name="userID" value="${teacherCustom.userID}"><br><br><br>
        姓名：<input type="text" name="userName" value="${teacherCustom.userName}" ><br><br><br>
        性别：
        <input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女">女
        <br><br><br>
        出生年份：
        <input type="date" value="<fmt:formatDate value="${teacherCustom.birthYear}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="birthYear"/>
        <br><br><br>
        学历:
        <input type="text" name="degree" value="${teacherCustom.degree}"><br><br><br>
        职称:
        <input type="text" name="title" value="${teacherCustom.title}"><br><br><br>
        入职年份：
        <input type="date" value="<fmt:formatDate value="${teacherCustom.grade}" dateStyle="medium" pattern="yyyy-MM-dd" />" name="grade"/>
        <br><br><br>
        学院：
        <select class="form-control" name="collegeID">
            <c:forEach items="${collegeList}" var="item">
                <option value="${item.collegeID}">${item.collegeName}</option>
            </c:forEach>
        </select>
        <br><br><br>
        <br><br><br>
        <input type="submit" value="修改">
        <input type="button" value="返回" onclick="location.href='/admin/showTeacher'">--%>

</body>
</html>
