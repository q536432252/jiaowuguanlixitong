<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2022/1/13
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                            <h4 class="col-lg-9">修改密码</h4>
                        </div>
                    </div>
                    <div style="text-align: center">
                        <form action="/admin/userPasswordRest" method="post">
                            <div class="form-group"></div>
                            <div class="form-group">
                                需要修改的学号/教师编号为：<input type="text" name="userName"/><br>
                            </div>
                            <div class="form-group">
                                新密码：<input type="text" name="password1"/><br>
                            </div>
                            <div class="form-group">
                                确认密码：<input type="text" name="password2"/><br>
                            </div>
                            <input type="submit" value="提交">
                            <input type="reset" value="重置">
                        </form>
                    </div>


                </div>

            </div>

            <%--中间右侧的菜单栏--%><%--class="col-lg-2"--%>
            <jsp:include page="menu.jsp"></jsp:include>

        </div>

</body>
</html>
