<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="/zy/static/css/base.css">
    <link rel="stylesheet" href="/zy/static/css/profile.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
    <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
               <ul class="profile_tab_header f_left clearfix">
                    <li><a href="/zy/front/user/profile.action">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="/zy/front/user/avatar.action">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="/zy/front/user/password.action">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                            <c:if test="${empty user.headUrl}">
                                <img  src="${pageContext.request.contextPath}/static/img/avatar_lg.png">
                            </c:if>

                            <c:if test="${not empty user.headUrl}">
                                <img width="200px" height="200px" src="/pic/${user.headUrl}">
                            </c:if>
                        </div>
                        <div class="profile_ifo_area">
                            <form action="/zy/front/user/profile1.action" method="post">
                                <div class="form_group">
                                    <span class="dd">昵&#x3000;称：</span><input type="text" name="nickName" value="${user.nickName}" >
                                </div>
                                <div class="form_group">
                                    <span class="dd">性&#x3000;别：</span>
                                    <input type="radio" id="man" <c:if test="${user.sex==1}">checked='checked'</c:if> value="1" name="sex"><label for="man">男</label>
                                    <input type="radio" id="woman" <c:if test="${user.sex==2}">checked='checked'</c:if> value="2" name="sex"><label for="woman">女</label>
                                </div>
                                <div class="form_group">
                                    <span class="dd">生&#x3000;日:</span>
                               
                                    <input type="date" name="birthday" value='<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>'>

                                </div>
                                
                                <div class="form_group">
                                    <span class="dd">邮&#x3000;箱：</span>
                                    <span >${user.email}</span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">所在地：</span>
                                    <input type="hidden" id="uprovince" value="${user.province }">
                                    <input type="hidden" id="ucity" value="${user.city }">
                                    <div id="city">
                                        <select class="prov" name="province"></select>
                                        <select class="city" name="city"></select>
                                    </div>
                                </div>
                                <div class="form_submit dd">
                                    <input type="submit"  value="保&#x3000;存">
                                    <a href="front/user/profile.do">重置</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="ufooter.jsp"></jsp:include>
     <%@include file="../include/script.html"%>
    <script src="/zy/static/js/jquery.cityselect.min.js"></script>
    <script type="text/javascript">

		$(function(){

			var province = $('#uprovince').val();
			var city = $('#ucity').val();

			console.log(province+"-"+city);
			
			if(null!=province && province!=""){			
				$("#city").citySelect({
					prov: province,  //默认省份
					city: city,  //默认城市
					nodata: "none"
				});
			}else{ 
				$("#city").citySelect({
					prov: "河南",  //默认省份
					city: "郑州",  //默认城市
					nodata: "none"
				});
			}

		});

    </script>
</body>

</html>