<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<!--引入模板-->
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--<meta name="description" content />
    <meta name="author" content />-->
    <title>登录</title>
   
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>
     <style>
     	
    .login { 
    
    background-color: #fff;
    width: 300px;
    padding-top: 30px;
    border-radius: 5px;
    
     position:absolute; 
     top:50%; 
     left:50%; 
     margin-left:-200px; 
     margin-top:-200px; 
}
	.login img {
    display: block;
    width: 300px;
    margin: 0 auto;
}
	
	.btn{
		
		width: 300px;
	}
     </style>
     
     
     <script type="text/javascript">

$(function(){
	
	$("#checkForm").validate({
		rules:{
			loginName:{
				
				required:true
		
			},
			loginPwd:{
				required:true
			}
		},    
		messages:{
			loginName:{
				required:"用户名不得为空"
				
			},
			loginPwd:{
				required:"请输入密码"
			}
		} 
	

	});
	
});




</script>
     
     
     
     
     
     
  </head>
  


  
  <body>
  	<!--<div class="container">   /maven-project/src/main/webapp/img/logo.png-->
  
  	<div class="login"> 
  		<img src="${pageContext.request.contextPath }/img/logo.png" />
  	<form action="${pageContext.request.contextPath }/admin/login/indexLogin.action" id="checkForm" method="post">
  	 	<div>
  	 	<!--<label for="username" ></label>-->
        <input type="text" id="loginName" class="form-control" name="loginName"  placeholder="用户名" >&nbsp;
    	</div>
    	<div>
    	<!--<label for="password" ></label>-->
        <input type="password" id="loginPwd" class="form-control" name="loginPwd" placeholder="登录密码" >&nbsp;
    	</div>
 
    	
    	
    	<p style="color: red; font-size: 15px;">${errorMessage }</p>
    	<!-- <button type="submit" class="btn btn-success" >登录</button> -->
    	<input  type="submit" class="btn btn-success" value="登录"/>
   </form>
   </div>
 <!--  </div>-->
  </body>
</html>
