<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="sxw" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>编辑课程</title>
		
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		</head>
	<body>
	<jsp:include page="/WEB-INF/view/header.jsp">
	<jsp:param value="course" name="fromJsp"/>
	</jsp:include>
	
	
	
<div class="container">
	<div class="jumbotron">
  <h1>编辑学科-学科管理</h1>
</div>
<div class="container">
	
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/course/courseedit1.action">
	<input type="hidden" name="id" value="${courselist.id}">
  <div class="form-group">
  	 <label for="inputEmail3" class="col-sm-2 control-label">所属学科</label>
    <div class="col-sm-10">
      <select class="form-control" name="subjectId">
		<option>请选择所属学科</option>
	<c:forEach items="${subjectlist}" var="li" varStatus="status">
	<option value="${li.id}" ${courselist.subjectId eq li.id?"selected":""}>${li.subjectName}</option>
	</c:forEach>

	</select><br>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
     <input type="text" placeholder="标题"class="form-control" name="courseName" value="${courselist.courseName}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
     <input type="text" placeholder="简介"class="form-control" name="courseDescr" value="${courselist.courseDescr}">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <a> <button type="submit" class="btn btn-default" style="background-color: deepskyblue;">保存</button></a>
     <a href="javascript:history.go(-1)"> <button type="button" class="btn btn-default" >返回列表</button></a>
    </div>
  </div>
</form>
	</div>
	
	</div>
	

	</body>
</html>