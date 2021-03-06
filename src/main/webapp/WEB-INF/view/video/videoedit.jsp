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
	<jsp:param value="video" name="fromJsp"/>
	</jsp:include>
<div class="container">
	<div class="jumbotron">
  <h1>添加视频-视频管理</h1>
</div>
<div class="container">
	
	<form class="form-horizontal" action="<c:url value="/admin/video/videoedit1.action"></c:url>">
	<input type="hidden" value="${v.id}" name="id">
		<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频标题"class="form-control" name="videoTitle" value="${v.videoTitle }">
    </div>
  </div>

  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
    <div class="col-sm-10">
       <select name="speakerId"class="form-control">
       <c:forEach items="${speaker}" var="s">  
  	<option value="${s.id}" ${v.speakerId eq s.id?"selected":""}>${s.speakerName}</option>
  </c:forEach>
  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
    <div class="col-sm-10">
     <select name="courseId"class="form-control">
  <c:forEach items="${course}" var="c">
  	<option value="${c.id}" ${v.courseId eq c.id?"selected":""}>${c.courseName}</option>
  	</c:forEach>
  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频时长"class="form-control" name="videoLength" value="${v.videoLength}">
    </div>
  </div>
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
     <input type="text" placeholder="封面图片"class="form-control" name="videoImageUrl" value="${v.videoImageUrl}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频播放地址"class="form-control" name="videoUrl" value="${v.videoUrl}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10" >
     <input type="text" class="form-control" style="height:100px;" name="videoDescr" value="${v.videoDescr}">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <a> <button type="submit" class="btn btn-default" style="background-color: deepskyblue;">保存</button></a>
     <a href="javascript:history.go(-1)"> <button type="button" class="btn btn-default" >返回列表</button></a>
    </div>
  </div>
</form>
</div></div>	
	

	</body>
</html>
