<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="/maven-project/static/css/base.css">
    <link rel="stylesheet" href="/maven-project/static/css/forget_password.css">
    <link rel="icon" href="favicon.png" type="image/png">
    
     <script src="/maven-project/js/jquery-1.12.4.min.js"></script>
     <script src="/maven-project/js/bootstrap.min.js"></script>
     <script src="/maven-project/static/js/jquery.validate.min.js"></script>
    
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>  
</head>

<body>
    <header>
        <div class="container">
            <img src="/maven-project/static/img/logo.png" alt="智游">
        </div>
    </header>
    <main>
        <div class="container">
            <form class="ma" action="/maven-project/front/user/resetpwd.action" method="post" id="reset001">
               <input type="hidden" name="email" value="${email}"/>
                <input type="hidden" name="captcha" value="${captcha}"/>
                <div class="form_header">
                    <div class="form_title">
                        <h2>重置密码</h2>
                    </div>
                    
                </div>
                
                <div class="form_body">
                    <input type="password" placeholder="请输入新密码" id="password" name="password">
                    <input type="password" style="width:100%" placeholder="再次输入新密码" id="pwdAgain" name="pwdAgain">
                    <input type="submit" style="margin:0px;width:100%" value="提交">
                </div>
                
            </form>
        </div>
    </main>
    
    <script type="text/javascript">
    
	 
    $(function(){
 	   

 		//注册请求的处理
 		$('#reset001').validate({
 			
 			
 			rules:{//写校验规则的
 				password:{
 					required:true,
 					minlength:3
 					
 				},
 				pwdAgain:{
 					required:true,
 					minlength:3
 				}
 			},
 			messages:{//写提示信息的
 				
 				password:'密码是必须填写的，3-30个字符',
 				pwdAgain:'两次密码必须输入一致'
 			}
 		});	
 		
 	   
    }); 
    
    
    
    
    </script>
    
    
    
</body>

</html>