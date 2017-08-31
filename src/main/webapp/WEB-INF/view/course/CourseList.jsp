<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jdw" uri="http://zhiyou100.com/common/"  %>
<!DOCTYPE html>
<html>
	<head>
	 <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!--<meta name="description" content />
    <meta name="author" content />-->
     <title>课程管理系统</title>
    
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    
     <script>
     
     
     function delcfm(url){
 		$('#url').val(url);
 		$('#delcfmModal').modal();
 	}
 	function urlSub(){
 		var url = $.trim($("#url").val());
 		window.location.href=url;
 	}
	

	
	
</script>
	</head>
	
	
	
	
	<body>
		<jsp:include page="/admin.jsp">
			<jsp:param value="course" name="fromJsp"/>
		</jsp:include>
	
    
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>课程列表-课程管理</h2>
    </div>
       
    
  
      <div class="container">
        <div class="navbar-header">
         
          <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/course/addCourse.action">添加课程</a>
           
        </div>
       
        </div>
   
 
 
 
    <div class="container">
   	<div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>序号</th>
          <th>标题</th>
          <th>学科</th>
          <th>简介</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      
       <c:forEach var="course" items="${page.rows }" varStatus="status">
      
        <tr>
          <th scope="row">${status.count+((page.page-1)*10)}</th>
          <td>${course.courseName }</td>
          <td>${course.SName }</td>
          <td>${course.courseDescr }</td>    <%-- href="${pageContext.request.contextPath }/admin/course/deleteCourse.action?id=${course.id}"  --%>
          <td ><a  class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/admin/course/updateCourse.action?id=${course.id}"></a></td>
          <td ><a  class="glyphicon glyphicon-trash"   onclick="delcfm('${pageContext.request.contextPath }/admin/course/deleteCourse.action?id=${course.id}')" ></a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <input type="hidden" name="id" value="${course.id }">
  </div>
  
         <jdw:page  url="${pageContext.request.contextPath}/admin/course/listCourse.action"></jdw:page>
    </div>
    
    
    <div class="modal fade" id="delcfmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">提示信息</h4>
			</div>
			
			<div class="modal-body">
			  你确定要删除吗?
			</div>
			<div class="modal-footer">
				<input type="hidden" id="url" />
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<a  class="btn btn-success"   data-dismiss= "modal"  onclick="urlSub()"  >确定</a>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div>

    
	</body>
</html>
