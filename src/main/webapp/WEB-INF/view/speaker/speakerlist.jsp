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
		<title>主讲人列表</title>
		
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
  <h1>主讲人列表-主讲人管理</h1>
</div>
<div  class="row">
        	<div  class="col-md-4"  >   
        <a href="<c:url value="/admin/speaker/addspeaker.action"></c:url>"> <button type="button" class="btn btn-primary btn-lg active">添加主讲人</button></a>	
        </div>
			<form class="form-inline" action="${pageContext.request.contextPath}/admin/speaker/speakerlist.action">
  <div class="form-group col-md-offset-2" >
   
   名称 <input type="text" class="form-control" id="exampleInputName2" placeholder="主持人名称" name="speakerName" value="${speakerName}">
  </div>
  <div class="form-group">
<div class="btn-group">
   职位 <input type="text" class="form-control" id="exampleInputName2" placeholder="职位" name="speakerJob" value="${speakerJob}">
</div>
  
</div>
 
  <button type="submit" class="btn btn-primary active">查询</button>
</form>
		</div>
			 
      <table class="table table-hover">
      
        <tr>
        
          <th>序号</th>
          <th>名称</th>
          <th>职位</th>
          <th class="col-md-6">简介</th>
          <th>编辑</th>
          <th>删除</th>
          
        </tr>
     
      <tbody>
         <c:forEach items="${page.rows}" var="li" varStatus="status">
        <tr>
          <th scope="row">${status.count}</th>
          <td>${li.speakerName}</td>
          <td>${li.speakerJob}</td> 
          <td>${li.speakerDescr}</td>
          <td><a class="glyphicon glyphicon-edit" href="<c:url value="/admin/speaker/speakeredit.action?id=${li.id}"></c:url>"></a></td>
          <td><a class="glyphicon glyphicon-trash"href="<c:url value="/admin/speaker/speakerdelete.action?id=${li.id}"></c:url>"></a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
	<sxw:page url="${pageContext.request.contextPath}/admin/speaker/speakerlist.action"/>
		</div>
	</body>
</html>
