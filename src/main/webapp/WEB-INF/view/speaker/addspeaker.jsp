<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加主讲人</title>
		
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		</head>
	<body>
   <jsp:include page="/WEB-INF/view/header.jsp">
	<jsp:param value="speaker" name="fromJsp"/>
	</jsp:include>
<div class="container">
	<div class="jumbotron">
  <h1>增加主讲人-主讲人管理</h1>
</div>
</div>
<div class="container">
	
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/speaker/addspeaker1.action" enctype="multipart/form-data">
	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
     <input type="text" placeholder="请输入名字"class="form-control" name="speakerName">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
     <input type="text" placeholder="职业"class="form-control" name="speakerJob">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
     <input type="text" placeholder="http://zhiyou100.com"class="form-control" name="speakerHeadUrl">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
     <input type="text" placeholder="简介"class="form-control" name="speakerDescr">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     <button type="submit" class="btn btn-default" style="background-color: deepskyblue;">保存</button>
     <a href="javascript:history.go(-1)"><button type="button" class="btn btn-default" >返回列表</button></a>
    </div>
  </div>
</form>
</div>	
	

</body>
</html>