<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
	<title>addCourse</title>
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

<%--class="col-lg-12"--%>

<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="panel panel-primary">
				<div class="panel-heading" style="text-align: center">
					<h1>新增课程信息</h1>
				</div>
				<form action="/admin/addCourse2" method="post">
					<table class="table table-bordered">

						<tr >
							<td class="col-lg-5" style="text-align: right"> 课程id：</td>
							<td style="text-align: left"><input type="text" name="courseID"></td>
						</tr>
						<tr>
							<td  style="text-align: right">课程名：</td>
							<td><input type="text" name="courseName"></td>
						</tr>
						<tr>
							<td  style="text-align: right">授课老师：</td>
							<td>
								<select class="form-control" name="teacherID">
									<c:forEach items="${teacherList}" var="item">
										<option value="${item.userID}">${item.userName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td  style="text-align: right">上课时间：</td>
							<td><input type="text" name="courseTime"></td>
						</tr>
						<tr>
							<td  style="text-align: right">地点：</td>
							<td><input type="text" name="classRoom"></td>
						</tr>
						<tr>
							<td  style="text-align: right">周数：</td>
							<td>
								<input type="text" name="courseWeek">
							</td>
						</tr>
						<tr>
							<td  style="text-align: right">课程类型：</td>
							<td>
								<select class="form-control" name="courseType">
									<option value="必修课">必修课</option>
									<option value="选修课">选修课</option>
									<option value="公共课">公共课</option>
								</select>
							</td>
						</tr>
						<tr>
							<td  style="text-align: right">所属院系：</td>
							<td>
								<select class="form-control" name="collegeID">
									<c:forEach items="${collegeList}" var="item">
										<option value="${item.collegeID}">${item.collegeName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td  style="text-align: right">学分：</td>
							<td>
								<input type="text" name="score">
							</td>
						</tr>
						<tr>
							<td style="text-align: right"><input type="submit" value="添加"></td>
							<td><input type="button" value="返回" onclick="location.href='/admin/showCourse'"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>


</div>


</body>

</html>