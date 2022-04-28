<%--
  Created by IntelliJ IDEA.
  User: Lin
  Date: 2021/12/28
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>login</title>
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
    <%--当页面变大 两边会有边距，居中效果--%>
    <div class="container">
        <div class="col-lg-14">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-lg-14" style="text-align: center">教务管理系统 </h1>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%-----------------------%>
    <!--顶部-->


    <%--中间一整个大的div--%>
    <%--class="col-lg-12"--%>
    <div class="container" >
        <%--class="row" 将容器（container）分成列 ，在进行col-x-x划分--%>
        <div class="row">
            <div class="col-lg-4">
                <%--<div class="panel panel-primary" >
                    <div class="panel-heading">
                        <div class="row" style="text-align: center">
                            <h4 class="col-lg-13">用户登录</h4>
                        </div>
                    </div>
                </div>--%>
            </div>
            <%--中间左侧的信息汇总--%><%--class="col-lg-10"--%>
            <div class="col-lg-4" >
                <%--面板的颜色 panel-danger红 panel-primary蓝 panel-default灰  panel-warning黄色--%>
                <div class="panel panel-primary" >
                    <div class="panel-heading">
                        <div class="row" style="text-align: center">
                            <h4 class="col-lg-13">用户登录</h4>
                        </div>
                    </div>

                    <%--具体的信息表格--%>

                    <form action="/login" method="post" style="text-align: center">
                        <%--name属性是传过controller作为参数接受的 要和数据库的列名大小写一致--%>
                        <br>
                        账号：<input type="text" name="userName"/><br><br>
                        密码：<input type="password" name="password"/><br><br>
                        <input type="submit" class="btn btn-default btn-xs btn-info" value="提 交">
                          <%--  <button class="btn btn-default btn-xs btn-info" >修改</button>--%>
                    </form>


                </div>
            </div>
        </div>
    </div>


</body>


</html>
