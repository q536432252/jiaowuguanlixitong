<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/5
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--   <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
   <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <!-- 引入bootstrap -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <!-- 引入bootstrap.js-->
    <script src="/js/bootstrap.min.js"></script>
    <!-- 引入JQuery-->

    <%--开启el表达式--%>
    <%@ page  isELIgnored="false"%>
    <%--//日期格式转化--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%--c jsp c开头的标签--%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
                            <h4 class="col-lg-9">我的课程</h4>

                        </div>
                    </div>

                    <%--具体的信息表格--%>
                    <table class="table table-bordered">
                        <tr>
                            <th>课程号</th>
                            <th>课程名称</th>
                            <th>授课老师编号</th>
                            <th>上课时间</th>
                            <th>上课地点</th>
                            <th>周数</th>
                            <th>课程类型</th>
                            <th>学分</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="pageInfo" items="${courseList}" >
                            <%-- <c:forEach var="student" items="${requestScope.get(studentList)}">--%>
                            <tr>
                                    <%--${student.getUserID}--%>
                                <td>${pageInfo.courseID}</td>
                                <td>${pageInfo.courseName}</td>
                                <td>${pageInfo.teacherID}</td>
                                <td>${pageInfo.courseTime}</td>
                                <td>${pageInfo.classRoom}</td>
                                <td>${pageInfo.courseWeek}</td>
                                <td>${pageInfo.courseType}</td>

                                <td>${pageInfo.score}</td>
                                <%--选课--%>
                                <td>
                                    <%--<button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/updateCourse?id=${pageInfo.courseID}'">修改</button>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/deleteCourse?id=${pageInfo.courseID}'">删除</button>--%>
                                    <!--弹出框-->
                                        <button class="btn btn-default btn-xs btn-info" onClick="location.href='/teacher/showGrade?id=${pageInfo.courseID}'">成绩</button>
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
