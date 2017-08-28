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
		
        <link href="../css/bootstrap.min.css" rel="stylesheet">

		<script src="../js/jquery-1.12.4.min.js"></script>

		<script src="../js/bootstrap.min.js"></script>
		</head>
	<body>
	<div class="container">
	<nav class="navbar navbar-inverse">
  		
  			 <ul class="nav navbar-nav">
        		
	            <li style="font-size: 30px;"><a href="#">视频管理系统</a></li>
	             <li><a href="<c:url value="/video/videolist.action"></c:url>">视频管理</a></li>
	            <li><a href="<c:url value="/speaker/speakerlist.action"></c:url>">主讲人管理</a></li>
	            <li><a href="<c:url value="/course/courselist.action"></c:url>">课程管理</a></li>
	            <li><a href="#">统计分析</a></li>
	            <p class="navbar-text navbar-right" style="margin-left: 450px;">${admin.loginName}<a href="#" class="glyphicon glyphicon-share">退出</a></p>
	            
          </ul>
       

  		
	</nav>
</div>
<div class="container">
	<div class="jumbotron">
  <h1>添加视频-视频管理</h1>
</div>
<div class="container">
	
	<form class="form-horizontal" action="<c:url value="/video/addvideo1.action"></c:url>">
		<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频标题"class="form-control" name="videoTitle">
    </div>
  </div>

  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
    <div class="col-sm-10">
       <select name="speakerId"class="form-control">
         <c:forEach items="${speaker}" var="s">
  	<option value="${s.id}" >${s.speakerName}</option>
  </c:forEach>
  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
    <div class="col-sm-10">
     <select name="courseId"class="form-control">
  <c:forEach items="${course}" var="c">
  	<option value="${c.id}">${c.courseName}</option>
  	</c:forEach>
  </select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频时长"class="form-control" name="videoLength">
    </div>
  </div>
 
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
     <input type="text" placeholder="封面图片"class="form-control" name="videoImageUrl">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
     <input type="text" placeholder="视频播放地址"class="form-control" name="videoUrl">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10" >
     <input type="text" class="form-control" style="height:100px;" name="videoDescr">
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
