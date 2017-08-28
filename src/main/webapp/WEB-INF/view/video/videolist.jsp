<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sxw" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/javascript; charset=gb2312" />
<title>视频列表</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="/twitter-bootstrap/twitter-bootstrap-v2/js/bootstrap-modal.js"></script>

<script>
      
function deletevideos() {
	
	      

	document.getElementsByTagName("form")[1].submit();
	
}






      var a=0; 
function cishu(n){	
	 if(n.checked==true){ 
		a++;
	 }else{
		a--;
	}
	
/* 	document.getElementById('dianjicishu').innerHTML = a; */
	$("#dianjicishu").html(a);
	
}

/*  function allclick(allchoose,ids){
    	
    	
	 var sonname=document.getElementsByName("ids"); 
	var all=document.getElementById("allchoose");
	var tempstate=all.checked;
	
	for (i=0;i<sonname.length;i++){
		
		if(sonname[i].checked!=tempstate){
			sonname[i].click();
		}
		
	}
	
}  */

 $(function(){
	

	$("#allchoose").click(function(){
		var tempstate=this.checked;
	
		var a=$("input[name=ids]");
		
	a.each(function (index,domElement){	
		    
          domElement.checked=tempstate;	    	  
		});
	       var count=a.size();
		if(tempstate==true){	
		
			$("#dianjicishu").html(count);
			
		}else{
			$("#dianjicishu").html(0);
		}
		
	});	
	
		
	})	 
	




</script>

</head>
<body>



	<div class="container">
		<nav class="navbar navbar-inverse">

			<ul class="nav navbar-nav">

				<li style="font-size: 30px;"><a href="#">视频管理系统</a></li>
				<li><a href="<c:url value="/video/videolist.action"></c:url>">视频管理</a></li>

				<li><a
					href="<c:url value="/speaker/speakerlist.action"></c:url>">主讲人管理</a></li>
				<li><a href="<c:url value="/course/courselist.action"></c:url>">课程管理</a></li>
				<li><a href="<c:url value="/charts/chartslist.action"></c:url>">统计分析</a></li>
				<p class="navbar-text navbar-right" style="margin-left: 450px;">
					${admin.loginName}<a href="#" class="glyphicon glyphicon-share">退出</a>
				</p>

			</ul>



		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h1>视频列表-视频管理</h1>
		</div>

		<div class="row">
			<div class="col-md-4">
				<a href="<c:url value="/video/addvideo.action"></c:url>"><button type="button" class="btn btn-primary btn-lg active">添加视频</button></a>
	
	
	<button type="button" class="btn btn-primary btn-lg active" onclick="deletevideos()">批量删除(<span id="dianjicishu">0</span>)</button>
			</div>
			<form class="form-inline"
				action="<c:url value="/video/videolist.action"></c:url>">
				<div class="form-group col-md-offset-1">
					<input type="text" class="form-control" id="exampleInputName2"
						placeholder="视频标题" name="videoSearchField"
						value="${videoSearchField}">
				</div>
				<div class="form-group">
					<div class="btn-group">
						<select name="videoSpeaker" class="form-control">
							<option value="">请选择主讲人</option>
							<c:forEach items="${speaker}" var="s">
								<option value="${s.speakerName}"
									${videoSpeaker eq s.speakerName? "selected":""}>${s.speakerName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="btn-group">
						<select name="videoCourse" class="form-control">
							<option value="">请选择课程</option>
							<c:forEach items="${course}" var="c">
								<option value="${c.courseName}"
									${videoCourse eq c.courseName? "selected":""}>${c.courseName}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<button type="submit" class="btn btn-primary active">查询</button>
			</form>
		</div>

		<form class="form-inline" action="<c:url value="/video/deletevideos.action"></c:url>">
			<table class="table table-hover">
				<tr>
					<th><input type="checkbox" id="allchoose" onclick="allclick('allchoose','ids')" ></th>
					<th>序号</th>
					<th>名称</th>
					<th class="col-md-6">介绍</th>
					<th>讲师</th>
					<th>课程</th>
					<th>时长(秒)</th>
					<th>播放次数</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>

				<tbody>
					<c:forEach items="${page.rows}" var="li" varStatus="status">
						<tr>
							<td><input type="checkbox" value="${li.id}" name="ids" id="ids" onclick="cishu(this)" ></td>
							<th scope="row">${ status.count}</th>
							<td>${li.videoTitle}</td>
							<td>${li.videoDescr}</td>
							<td>${li.speakerName }</td>
							<td>${li.courseName}</td>
							<td>${li.videoLength}</td>
							<td>${li.videoPlayTimes }</td>
							<td><a class="glyphicon glyphicon-edit"
								href="<c:url value="/video/videoedit.action?id=${li.id}"></c:url>"></a></td>
							<td><a class="glyphicon glyphicon-trash"   href="<c:url value="/video/videodelete.action?id=${li.id}"></c:url>"
								></a>
								
								
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</form>
		<sxw:page
			url="${pageContext.request.contextPath}/video/videolist.action" />
	</div>
	 
</body>
</html>
