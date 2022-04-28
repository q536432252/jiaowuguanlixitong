<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/17
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<!--顶部-->
<%--class="col-lg-12"--%>
<jsp:include page="top.jsp"></jsp:include>

<%--中间一整个大的div--%>
<%--class="col-lg-12"--%>
<div class="container">
    <%--class="row" 将容器（container）分成列 ，在进行col-x-x划分--%>
    <div class="row">

        <%--中间左侧的信息汇总--%><%--class="col-lg-10"--%>
        <div class="col-lg-10">
            <%--面板的颜色 panel-danger红 panel-primary蓝 panel-default灰  panel-warning黄色--%>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <h4 class="col-lg-9">打分</h4>

                    </div>
                </div>

                <%--具体的信息表格--%>
                <table class="table table-bordered">
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>分数</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="pageInfo" items="${selectedCourseList}" >
                        <%-- <c:forEach var="student" items="${requestScope.get(studentList)}">--%>
                        <tr>
                                <%--${student.getUserID}--%>
                            <td>${pageInfo.student.userID}</td>
                            <td>${pageInfo.student.userName}</td>
                            <td>${pageInfo.mark}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info" onClick="location.href='/teacher/mark?studentID=${pageInfo.studentID}&courseID=${pageInfo.courseID}'">打分</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>

        </div>

        <%--中间右侧的菜单栏--%><%--class="col-lg-2"--%>
        <jsp:include page="menu.jsp"></jsp:include>

    </div>
</div>

</body>
</html>
