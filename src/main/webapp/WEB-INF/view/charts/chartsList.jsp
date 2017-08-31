<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type"
	content="text/javascript; charset=gb2312" />
<title>视频列表</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp">
	<jsp:param value="charts" name="fromJsp"/>
	</jsp:include>
	
		<div class="container">
		<div class="jumbotron">
			<h1>统计-统计分析</h1>
		</div>
		
		<div id="main" style="height:400px"></div>
	</div>




<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['课程平均播放次数'],
                        subtext: '数据来源:zhiyou100.com'
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data :  ${data} ,
                        },
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"平均播放次数",
                            "type":"bar",
                            "data":${value}
                        }
                    ]
                };
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    </script>


</body>
</html>
