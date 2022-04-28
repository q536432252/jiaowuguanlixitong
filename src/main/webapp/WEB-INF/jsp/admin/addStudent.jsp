<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>addStudent</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="/js/jquery-3.2.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</head>
<body>

	<%--class="col-lg-12"--%>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="panel panel-primary">
					<div class="panel-heading" style="text-align: center">
						<h1>新增学生信息</h1>
					</div>
					<form action="/admin/addStudent2" method="post">
						<table class="table table-bordered">

								<tr >
									<td class="col-lg-5" style="text-align: right"> 学生学号：</td>
									<td style="text-align: left"><input type="text" name="userID"></td>
								</tr>
								<tr>
									<td  style="text-align: right">学生姓名：</td>
									<td><input type="text" name="userName"></td>
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
									<td><input type="date" value="1996-09-02" name="birthYear"/></td>
								</tr>
								<tr>
									<td  style="text-align: right">入学时间：</td>
									<td><input type="date" value="2015-09-02" name="grade"/></td>
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
									<td style="text-align: right"><input type="submit" value="添加"></td>
									<td><input type="button" value="返回" onclick="location.href='/admin/showStudent'"></td>
								</tr>
						</table>
					</form>
				</div>
			</div>
		</div>


	</div>
</body>

</html>