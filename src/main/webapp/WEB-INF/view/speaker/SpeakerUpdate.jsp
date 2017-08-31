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
     <title>添加主讲人</title>
     
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     

	</head>
	
	
	
	
	<body>
		
		
    
    
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>添加主讲人-主讲人管理</h2>
    </div>
       
    <div class="container">
  <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/speaker/updateSpeaker02.action" method="post">
  	
  	 <input type="hidden" name="id" value="${speaker.id }">
  	
  <div class="form-group">
    <label for="input01" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="input01" name="speakerName" value="${speaker.speakerName } " placeholder="主讲人姓名">
    </div>
  </div>
  
  	

  
  
  <div class="form-group">
    <label for="input02" class="col-sm-2 control-label">职位</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerJob" value="${speaker.speakerJob } " id="input02" placeholder="主讲人职业">
    </div>
  </div>
  
   <div class="form-group">
    <label for="input03" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="input03" name="speakerHeadUrl" value="${speaker.speakerHeadUrl } " placeholder="主讲人头像">
    </div>
  </div>
  
  

  <div class="form-group">
    <label for="input05" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
     
      <textarea class="form-control" name="speakerDescr" rows="5" >${speaker.speakerDescr }</textarea>
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
