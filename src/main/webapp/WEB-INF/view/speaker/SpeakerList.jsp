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
     <title>主讲人管理列表</title>
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-confirm.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery-confirm.min.css">
      
  
  
  <script type="text/javascript">

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
			<jsp:param value="speaker" name="fromJsp"/>
		</jsp:include>
    
    
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>主讲人列表-主讲人管理</h2>
    </div>
       
    
  
      <div class="container">
        <div class="navbar-header">
         
          <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/speaker/addSpeaker.action">添加主讲人</a>
           
        </div>
        
         <div id="navbar" class="navbar-collapse collapse">
        
        
          <form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/admin/speaker/listSpeaker.action" method="post">
          
             <div class="form-group">
              	名称 <input type="text" name="speakerKeyName" placeholder="主讲人名称" class="form-control">
            </div>
      
       		<div class="form-group">
             	 职位 <input type="text" name="speakerKeyJob" placeholder="主讲人职位" class="form-control">
            </div>

		<button type="submit" class="btn btn-primary">查询</button>

          </form>
        </div>

        </div>
 
    
   
    <div class="container">
   	<div class="bs-example" data-example-id="hoverable-table">
    <table class="table table-hover">
      <thead>
        <tr>
          <th>序号</th>
          <th>名称</th>
          <th>职位</th>
          <th>简介</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      
       	<c:forEach var="speaker" items="${page.rows }" varStatus="status">
        <tr>
          <!-- <td><input class="checkbox" type="checkbox" id="blankCheckbox" name="selectFlag"  aria-label="..."></td> -->
          <th scope="row">${status.count+((page.page-1)*10)}</th>
          <td>${speaker.speakerName }</td>
          <td>${speaker.speakerJob }</td>
          <td>${speaker.speakerDescr }</td>      <%-- href="${pageContext.request.contextPath }/speaker/deleteSpeaker.action?id=${speaker.id}" --%>
          <td ><a  class="glyphicon glyphicon-edit" href="${pageContext.request.contextPath }/admin/speaker/updateSpeaker.action?id=${speaker.id}"></a></td>
          <td ><a  class="glyphicon glyphicon-trash"  onclick="delcfm('${pageContext.request.contextPath }/admin/speaker/deleteSpeaker.action?id=${speaker.id}')"></a></td>
        </tr>
          </c:forEach>
        
      </tbody>
    </table>
    <input type="hidden" name="id" value="${speaker.id }">
  </div>
  
 	 <jdw:page  url="${pageContext.request.contextPath}/admin/speaker/listSpeaker.action"></jdw:page>
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
		</div>/.modal-content
	</div>/.modal-dialog
</div>
    
    
    
    
    
    
    
	</body>
</html>
