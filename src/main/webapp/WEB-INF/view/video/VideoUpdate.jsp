<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--<meta name="description" content />
    <meta name="author" content />-->
     <title>修改视频信息</title>
     
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     
  
     
	</head>
	
	
	
	
	<body>
		
		<!-- <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">视频管理</a></li>
            <li><a href="#about">主讲人管理</a></li>
            <li><a href="#contact">课程管理</a></li>
            <li><a href="#contact">统计分析</a></li>
            <li> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
            <li><a href="#name">角色</a></li>
            <li><a href="#000" class="glyphicon glyphicon-log-out"></a></li>
          </ul>
        </div>
      </div>
    </nav> -->
    
    
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>添加视频信息-视频管理</h2>
    </div>
       
    	<div class="container">
  <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/video/videoUpdate02.action" method="post">
  	
   <input type="hidden" name="id" value="${video.id }">
  	
  <div class="form-group">
    <label for="input01" class="col-sm-2 control-label">视频标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="videoTitle" value="${video.videoTitle }" id="input01" placeholder="视频标题">
    </div>
  </div>
  
  	<div class="form-group">
    <label for="input07" class="col-sm-2 control-label">主讲人</label>
     <div class="col-sm-10">
 	 <select name="speakerId"  class="form-control"  >
			<option value="0">请选择主讲人</option>
		<c:forEach var="speaker" items="${speaker}">
			<option value="${speaker.id}"  ${video.speakerId ==speaker.id?"selected":"" }>${speaker.speakerName } </option>
		</c:forEach>
	</select>

	</div>
	</div>

	<div class="form-group">
    <label for="input08" class="col-sm-2 control-label">所属课程</label>
     <div class="col-sm-10">
 	 <select name="courseId" class="form-control" >
	<option value="0">请选择课程</option>
		<c:forEach var="course" items="${course}">
			<option value= "${course.id}"  ${video.courseId ==course.id?"selected":"" }>${course.courseName }</option>
		</c:forEach>
	</select>

	</div>
	</div>
  
  
  
  
  
  <div class="form-group">
    <label for="input02" class="col-sm-2 control-label">视频时长</label>
    <div class="col-sm-10">
      <input type="text"  class="form-control" id="input02" placeholder="视频时长(秒)" name="videoLength" value="${video.videoLength }">
    </div>
  </div>
  
   <div class="form-group">
    <label for="input03"  class="col-sm-2 control-label">封面图片</label>
    <div class="col-sm-10">
      <input type="text" name="videoImageUrl" value="${video.videoImageUrl }" class="form-control" id="input03" placeholder="视频封面图片地址,网络图片">
    </div>
  </div>
  
  
   <div class="form-group">
    <label for="input04" class="col-sm-2 control-label">视频播放地址</label>
    <div class="col-sm-10">
      <input type="text" name="videoUrl" value="${video.videoUrl }" class="form-control" id="input04" placeholder="视频播放地址,网络地址">
    </div>
  </div>
  
  <div class="form-group">
    <label for="input05" class="col-sm-2 control-label">视频简介</label>
    <div class="col-sm-10">
      <!--<input type="password" class="form-control" id="input05" placeholder="视频简介">-->
      <textarea class="form-control" name="videoDescr"  rows="5" >${video.videoDescr }</textarea>
    </div>
    
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
   
    <!-- <input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp; -->
    <button type="submit" class="btn btn-primary">保存</button>
      <a href="javascript:history.go(-1)" class="btn btn-default">返回列表</a>
    </div>
  </div>

  
 </form>
    
    </div>
    
	</body>
</html>
