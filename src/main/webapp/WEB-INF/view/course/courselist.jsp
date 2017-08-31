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
		<title>课程列表</title>
		
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
  <h1>课程列表-课程管理</h1>
</div>

 <div  class="row">
        	<div  class="col-md-4 "  >
        	<a href="<c:url value="/admin/course/addcourse.action"></c:url>"><button type="button" class="btn btn-primary btn-lg active" >添加课程</button></a>
        
        	</div>
		 
 <table class="table table-hover" style="margin-left: 0px;">
        <tr>
        
          <th>序号</th>
          <th>标题</th>
          <th>学科</th>
          <th class="col-md-6">简介</th>
          <th>编辑</th>
          <th>删除</th>
          
        </tr>
     
      <tbody>
        <c:forEach items="${page.rows}" var="li" varStatus="status">
        <tr>
        	
          <th scope="row">${status.count}</th>
          <td>${li.courseName}</td>
          <td>${li.sub.subjectName}</td> 
          <td>${li.courseDescr}</td>
          <td><a class="glyphicon glyphicon-edit"  href="<c:url value="/admin/course/courseedit.action?id=${li.id}"></c:url>"></a></td>
          <td><a class="glyphicon glyphicon-trash" href="<c:url value="/admin/course/coursedelete.action?id=${li.id}"></c:url>"></a> </td>
        </tr>
      </c:forEach>
        
      </tbody>
    </table>
	</div>
	<sxw:page url="${pageContext.request.contextPath}/admin/course/course.action"/>
	</div>
			
	</body>
</html>
