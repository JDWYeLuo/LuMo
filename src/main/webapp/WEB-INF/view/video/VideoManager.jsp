<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="jdw" uri="http://zhiyou100.com/common/"  %>
<!DOCTYPE html>
<html>
	<head>
	 <!-- <meta charset="utf-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1"> -->
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
     <title>视频管理系统</title>
    
     <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
     <link href="${pageContext.request.contextPath }/css/jquery-confirm.css" rel="stylesheet">
    
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
     <script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>
    
     
     <script type="text/javascript">


var deleteNum = 0;
function checkDelete(ele){
	
	if(ele.checked){
		
		deleteNum++;
		
	}else{
		
		deleteNum--;
		
	}
	
	$("#countSpan").text(deleteNum);
	
	 if(deleteNum == $("input[name=checkid]" ).length){
		 
		$("#checkAll").prop("checked",true);
		
	}else{
		
		$("#checkAll").prop("checked",false);
		
	} 
	 
 }

function checkAllElement(ele){
	 $("input[name=checkid]").prop("checked",ele.checked);
	 if(ele.checked){
		 deleteNum = $("input[name=checkid]").length;
	 }else{
		 deleteNum = 0;
	 }
	 $("#countSpan").text(deleteNum);
	
}

 function batchDelete() { 
	
	var $a = $("input[name='checkid']")
	var $b = $("input[name='checkAll']")
	
	

	var arr = new Array();
	
	
	
	if($b[0].checked==true){
		
		for(var i = 0; i < $a.length;i++){
			arr[i] = $a[i].value;
		    
		}
	}
	
	 if($b[0].checked==false){
			for(var i = 0; i <$a.length;i++){
				if($a[i].checked==true){
					arr[i] = $a[i].value;
				
				}
			}
	}
    
    		
    		
    var orConfirm =confirm("是否删除?");
	 
	 if(orConfirm){
    	 location. href="${pageContext.request.contextPath }/admin/video/deletePage.action?id="+arr 
		 
		/* a.href="${pageContext.request.contextPath }/admin/video/videoOrganizer.action"; */
	 }

} 



function delcfm(url){
	$('#url').val(url);
	$('#delcfmModal').modal();
}
function urlSub(){
	var url = $.trim($("#url").val());
	window.location.href=url;
}

/* 

   function batchDelete(){
	

	  if(deleteNum == 0){
		$.alert({
		    title: '警告',
		    content: '未选中',
		});
		return;
	}
	 $.confirm({
		    title: '提示',
		    content: '请确定,即将全部删除!!',
		    buttons: {
		        confirm: {
		        	text: '确定',
	
		        	action: function () {
		           		$("#deleteForm").submit();
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});  
} 
  */
/*  function deleteInfo(id){
	 $.confirm({
		    title: '提示',
		    content: '是否确认',
		    buttons: {
		        confirm: {
		        	text: '非常肯定',
		        	action: function () {
		           		$.ajax({
		           			url:"${pageContext.request.contextPath}/video/delete.action",
		           			dataType:"text",
		           			type:"post",
		           			data:{"id":id},
		           			success:function(msg){
		           				if(msg=="success"){
		           					location.reload();
		           				}
		           			}
		           		});
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});
} 
 */


</script>
     

     
	</head>
	
	
	
	
	<body>
		<jsp:include page="/admin.jsp">
			<jsp:param value="video" name="fromJsp"/>
		</jsp:include>
    <div class="container">
    <div class="jumbotron container" style=" border-radius:10px; ">
        <h2>编辑视频信息-视频管理</h2>
    </div>
       
    
  
      
        <div class="navbar-header">
         
          <a class="btn btn-primary" href="${pageContext.request.contextPath }/admin/video/videoAdd.action">添加视频</a>
          <!-- <a class="btn btn-primary" type="submit" >批量删除<span class="badge">0</span></a> -->
          
          <button class="btn btn-primary" type="button"  onclick="batchDelete()" >
          		批量删除 <span class="badge" id="countSpan">0</span></button> 
          
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        
        <div class="container">
        
          <form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/admin/video/videoOrganizer.action" method="post">
            <div class="form-group">
              <input type="text" name="videoKeyTitle" placeholder="视频标题" class="form-control">
            </div>
      
	
	<select name="speakerId"  class="form-control"  >
			<option value="0">请选择主讲人</option>
		<c:forEach var="speaker" items="${speaker}">
			<option value="${speaker.id}" ${speakerId eq speaker.id ? "selected":""}>${speaker.speakerName } </option>
		</c:forEach>
	</select>
	
	<select name="courseId" class="form-control" >
	<option value="0">请选择课程</option>
		<c:forEach var="course" items="${course}">
			<option value= "${course.id}" ${courseId eq course.id ? "selected":""}>${course.courseName }</option>
		</c:forEach>
	</select>


		<button type="submit" class="btn btn-primary">查询</button>

          </form>
        </div>
      </div>
 
    
    <!-- <div class="container"> -->
     <form action="${pageContext.request.contextPath }/admin/video/batchDelete.action" id="deleteForm" method="get">
     
     
     
     
     	
    	<div class="bs-example" data-example-id="hoverable-table"> 
    <table class="table table-hover">
      <thead>
        <tr>     <!-- name="ifAll" id="ifAll" onClick="checkAll() -->
          <th><input  type="checkbox" id="checkAll"  name="checkAll" onClick="checkAllElement(this)" aria-label="..."></th>
          <th>序号</th>
          <th>名称</th>
          <th>介绍</th>
          <th>讲师</th>
          <th>课程</th>
          <th>时长(秒)</th>
          <th>播放次数</th>
          <th>编辑</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      
       <c:forEach var="video" items="${page.rows }" varStatus="status">
       
        <tr>
          <td><input  type="checkbox"  onClick="checkDelete(this)" name="checkid" value="${video.id}" aria-label="..."></td>
          <th scope="row">${status.count+((page.page-1)*10)}</th>    <!-- +(pageInfo.currentPage-1)*10 -->
          <td>${video.videoTitle }</td>
          <td>${video.videoDescr }</td>
          <td>${video.SName}</td>
          <td>${video.CName}</td>
          <td>${video.videoLength }</td>
          <td>${video.videoPlayTimes }</td>     <%-- href="${pageContext.request.contextPath }/admin/video/videoDelete.action?id=${video.id}" --%>
          <td ><a  class="glyphicon glyphicon-edit"  href="${pageContext.request.contextPath }/admin/video/videoUpdate.action?id=${video.id}"></a></td>
          <td ><a  class="glyphicon glyphicon-trash"   onclick="delcfm('${pageContext.request.contextPath }/admin/video/videoDelete.action?id=${video.id}')" ></a></td>
        </tr>
         </c:forEach>
        
        
      
      </tbody>
    </table>
    <input type="hidden" name="id" value="${video.id }">
  </div>
  		 <jdw:page  url="${pageContext.request.contextPath}/admin/video/videoOrganizer.action"></jdw:page>
  	</form>	 
   </div>  
   <!--  </div>  -->
    
     
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
