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

<link href="${pageContext.request.contextPath}/css/jquery-confirm.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-confirm.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<script>
      


      var a=0; 
function cishu(n){	
	 if(n.checked==true){ 
		a++;
	 }else{
		a--;
	}
	$("#dianjicishu").text(a);	
	if(a==$("input[name=ids]").length){
		$("#allchoose").prop("checked",true);
	}else{
		$("#allchoose").prop("checked",false);
	}
}

function deletevideos() {
	
	if(a==0){
   $.alert({
	   title: '警告',
	    content: '没选中,删什么删',
   })
		return;
	}
	$.confirm({
	    title: '提示!',
	    content: '是否全部删除!',
	    buttons: {
	        confirm: {
	            text:"非常肯定",
	            action: function(){
	            $("#deleteVideos").submit();
	    
	            }
	        },
	                  取消: function () {   
	        }       
	    }
	});		
}

	function allclick(ele){
	$("input[name=ids]").prop("checked",ele.checked);
	if(ele.checked){
		a=$("input[name=ids]").length;
	}else{
		a=0;
	}
	$("#dianjicishu").text(a);	
}

	function confirm(id){
		$.confirm({
		    title: '提示!',
		    content: '是否确认删除!',
		    buttons: {
		        confirm: {
		            text:"非常肯定",
		            action: function(){
		            	$.ajax({	
		            		url:"${pageContext.request.contextPath}/video/videodelete.action",
		            		datatype:"text",	
		            		type:"post",
		            		data:{"id":id},
		            		success:function(msg){
		            			if(msg=="success"){
		            				location.reload();
		            			}
		            			
		            		}
		            	});
		            }
		        },
		                  取消: function () {   
		        }       
		    }
		});		
	}
	
	
	
	
</script>

</head>
<body>


	<jsp:include page="/WEB-INF/view/header.jsp">
	<jsp:param value="video" name="fromJsp"/>
	</jsp:include>

	<div class="container">
		<div class="jumbotron">
			<h1>视频列表-视频管理</h1>
		</div>

		<div class="row">
			<div class="col-md-4">
				<a href="<c:url value="/admin/video/addvideo.action"></c:url>"><button type="button" class="btn btn-primary btn-lg active">添加视频</button></a>
	
	
	<button type="button" class="btn btn-primary btn-lg active"  onclick="deletevideos()">批量删除(<span id="dianjicishu">0</span>)</button>
			</div>
			<form class="form-inline"
				action="<c:url value="/admin/video/videolist.action"></c:url>">
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

		<form class="form-inline" id="deleteVideos" action="<c:url value="/admin/video/deletevideos.action"></c:url>">
			<table class="table table-hover">
				<tr>
					<th><input type="checkbox" id="allchoose" onclick="allclick(this)" ></th>
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
				<c:if test="${not empty page.rows}">
					<c:forEach items="${page.rows}" var="li" varStatus="status">
						<tr>
							<td><input type="checkbox" value="${li.id}" name="ids" id="ids" onclick="cishu(this)" ></td>
							<th scope="row">${ status.count}</th>
							<td>${li.videoTitle}</td>
							<td>${li.videoDescr}</td>
							<td>${li.spk.speakerName }</td>
							<td>${li.cs.courseName}</td>
							<td>${li.videoLength}</td>
							<td>${li.videoPlayTimes }</td>
							<td><a class="glyphicon glyphicon-edit"
								href="<c:url value="/admin/video/videoedit.action?id=${li.id}"></c:url>"></a></td>
							<td><a class="glyphicon glyphicon-trash"  onclick="confirm(${li.id})" >
								</a>
								
								
							</td>
						</tr>
					</c:forEach>
					</c:if>
               <c:if test="${empty page.rows}">
                  <tr><td>当前查询结果为空!</td></tr>
               </c:if>
				</tbody>
			</table>
		</form>
		<sxw:page
			url="${pageContext.request.contextPath}/admin/video/videolist.action" />
	</div>
	 
</body>
</html>
