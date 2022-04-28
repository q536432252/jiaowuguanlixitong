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
                            <h4 class="col-lg-9">学生管理</h4>
                            <span class="col-lg-2" style="font-size: 15px; margin-top: 10px;text-align: right"><a
                                    href="/admin/addStudent" style="color: white">新增信息</a></span>
                        </div>
                    </div>

                    <%--具体的信息表格--%>
                    <table class="table table-bordered">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>出生年份</th>
                            <th>入学时间</th>
                            <th>学院</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="pageInfo" items="${pageInfo.list}" >
                            <%-- <c:forEach var="student" items="${requestScope.get(studentList)}">--%>
                            <tr>
                                    <%--${student.getUserID}--%>
                                <td>${pageInfo.userID}</td>
                                <td>${pageInfo.userName}</td>
                                <td>${pageInfo.sex}</td>
                                <%--<td>&lt;%&ndash;<fmt:formatDate value="${student.birthYear}" dateStyle="medium" />&ndash;%&gt;${pageInfo.birthYear}</td>
                                <td>&lt;%&ndash;<fmt:formatDate value="${student.grade}" dateStyle="medium" />&ndash;%&gt;${pageInfo.grade}</td>--%>
                                <td> <fmt:formatDate value="${pageInfo.birthYear}" pattern="yyyy年MM月dd日"/></td>
                                <td> <fmt:formatDate value="${pageInfo.grade}" pattern="yyyy年MM月dd日"/></td>
                                <td><%--${student.collegeName}--%>${pageInfo.collegeName}</td>
                                <td>
                                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/updateStudent?id=${pageInfo.userID}'">修改</button>
                                    <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/deleteStudent?id=${pageInfo.userID}'">删除</button>
                                    <!--弹出框-->
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="panel-heading">
                    <div class="panel-primary" style="text-align: center; ">
                        当前是${pageInfo.pageNum}页,共${pageInfo.pages}页,每页${pageInfo.pageSize}条,共${pageInfo.total}条记录
                        <br><br>
                        <a href="/admin/showStudent?page=1" style="color: white">首页</a>
                        <a href="/admin/showStudent?page=${pageInfo.pageNum-1}" style="color: white">上一页</a>
                        <a href="/admin/showStudent?page=${pageInfo.pageNum+1}" style="color: white">下一页</a>
                        <a href="/admin/showStudent?page=${pageInfo.pages}" style="color: white">尾页</a>
                    </div>
                    </div>
                </div>


                    <%--<div class="panel-footer">
                        <c:if test="${pagingVO != null}">
                            <nav style="text-align: center">
                                <ul class="pagination">
                                    <li><a href="/admin/showStudent?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>
                                    <li class="active"><a href="">${pagingVO.curentPageNo}</a></li>
                                    <c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
                                        <li><a href="/admin/showStudent?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">
                                        <li><a href="/admin/showStudent?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">
                                        <li><a href="/admin/showStudent?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>
                                    </c:if>
                                    <c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">
                                        <li><a href="/admin/showStudent?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>
                                    </c:if>
                                    <li><a href="/admin/showStudent?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>
                                </ul>
                            </nav>
                        </c:if>
                    </div>--%>

            </div>

            <%--中间右侧的菜单栏--%><%--class="col-lg-2"--%>
            <jsp:include page="menu.jsp"></jsp:include>

        </div>
    </div>

</body>
</html>
