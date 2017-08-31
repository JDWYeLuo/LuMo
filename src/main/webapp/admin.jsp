<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--<meta name="description" content />
    <meta name="author" content />-->
     <title>admin</title>
     
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     

	</head>
	
	
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath }/admin/video/videoOrganizer.action">视频管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">  <!-- target="pageBox" class="active"-->
            <li ${param.fromJsp=="video"?"class='active'":"" }><a  href="${pageContext.request.contextPath }/admin/video/videoOrganizer.action">视频管理</a></li>
            <li ${param.fromJsp=="speaker"?"class='active'":"" }><a  href="${pageContext.request.contextPath }/admin/speaker/listSpeaker.action">主讲人管理</a></li>
            <li ${param.fromJsp=="course"?"class='active'":"" }><a  href="${pageContext.request.contextPath }/admin/course/listCourse.action">课程管理</a></li>
            <li ${param.fromJsp=="statistics"?"class='active'":"" }><a  href="${pageContext.request.contextPath }/admin/video/viewList.action">统计分析</a></li>
           </ul>
           		<ul class="nav navbar-nav navbar-right">
               <%-- ${admin.loginName } --%>
            <li><a href="#name">角色</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/video/videoOrganizer.action" class="glyphicon glyphicon-log-out"></a></li>
          </ul>
        </div>
      </div>
    </nav>
		
		
	<%-- 	 <div class="right-side" >
	    		<iframe name="pageBox" style="width: 100%; height: 945px;" src="<c:url value="/video/videoOrganizer.action" />"></iframe>
		 
	    </div>  --%>   

		
	</body>
</html>
