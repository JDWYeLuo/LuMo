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
     <title>添加课程</title>
     
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     

	</head>
	
	
	
	
	<body>
		
	
    
    
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>添加课程-课程管理</h2>
    </div>
       
    <div class="container">
  <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/course/updateCourse02.action" method="post">
  	
  	
  	 <input type="hidden" name="id" value="${course.id }">

  <div class="form-group">
    <label for="input07" class="col-sm-2 control-label">所属学科</label>
     <div class="col-sm-10">
 	 <select name="subjectId"  class="form-control"  >
			<option value="0">请选择所属学科</option>
		<c:forEach var="subject" items="${subject}">
			<option value="${subject.id}" ${course.subjectId ==subject.id?"selected":"" }>${subject.subjectName }</option>
		</c:forEach>
	</select>

	</div>
	</div>
  	

  
  
  <div class="form-group">
    <label for="input02" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="courseName" value="${course.courseName }" id="input02" placeholder="课程标题">
    </div>
  </div>
  


  <div class="form-group">
    <label for="input05" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
      <!--<input type="text" class="form-control" id="input05" placeholder="视频简介">-->
      <textarea class="form-control" rows="5" name="courseDescr" >${course.courseDescr }</textarea>
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">保存</button>
      <a href="javascript:history.go(-1)" class="btn btn-default">返回列表</a>
    </div>
  </div>
  
  

  
 </form>
    
      </div>
    
	</body>
</html>
