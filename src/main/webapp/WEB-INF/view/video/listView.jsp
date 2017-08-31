<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jdw" uri="http://zhiyou100.com/common/"  %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>统计分析</title>
    
      <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script> 
    

    

    
</head>
<body>
			<jsp:include page="/admin.jsp">
			<jsp:param value="statistics" name="fromJsp"/>
		    </jsp:include>


		<div class="jumbotron container" style="border-radius:10px;" >
        <h2>统计分析</h2>
    	</div>



    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:500px"></div>
    <!-- ECharts单文件引入 -->
    <script src="/maven-project/js/echarts.js"></script>
    <script type="text/javascript">
    

    
    
    
    
        // 路径配置
        require.config({
            paths: {
                echarts: '${pageContext.request.contextPath }/dist'
            }
        });
        
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
            	
            	var theData = "${data}".split(",");
            	var theTimes = "${times}".split(",");
            	
            	
            	
            	
                // 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                	
                	
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['课程平均播放次数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : theData
                        }
                    ],
                    yAxis : [
                        {
                            type : '平均播放次数(times)'
                        }
                    ],
                    series : [
                        {
                            "name":"平均播放次数",
                            "type":"bar",
                            "data":theTimes
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
        
    </script>
    
</body>