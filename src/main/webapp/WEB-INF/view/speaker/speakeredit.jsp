<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<div class="container">
	<nav class="navbar navbar-inverse">
  		
  			 <ul class="nav navbar-nav">
        		
	            <li style="font-size: 30px;"><a href="#">视频管理系统</a></li>
	            <li><a href="<c:url value="/admin/video/videolist.action"></c:url>">视频管理</a></li>
	            <li><a href="<c:url value="/admin/speaker/speakerlist.action"></c:url>">主讲人管理</a></li>
	            <li><a href="<c:url value="/admin/course/courselist.action"></c:url>">课程管理</a></li>
	            <li><a href="#">统计分析</a></li>
	            <p class="navbar-text navbar-right" style="margin-left: 450px;">${admin.loginName}<a href="#" class="glyphicon glyphicon-share">退出</a></p>
	            
          </ul>
      

  		
	</nav>
</div>
<div class="container">
	<div class="jumbotron">
  <h1>编辑主讲人-主讲人管理</h1>
</div>
<div class="container">
	
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/speaker/speakeredit1.action">
	<input type="hidden" name="id" value="${s1.id}">
	
	
	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
     <input type="text" placeholder="请输入名字"class="form-control" name="speakerName" value="${s1.speakerName}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
     <input type="text" placeholder="职业"class="form-control" name="speakerJob" value="${s1.speakerJob}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
     <input type="text" placeholder="http://zhiyou100.com" class="form-control" name="speakerHeadUrl" value="${s1.speakerHeadUrl}">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
     <input type="text" placeholder="简介"class="form-control" name="speakerDescr" value="${s1.speakerDescr}">
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