<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<script type="text/javascript" src="js/page.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				jQuery.page("page",40); 
				$("#div1").tabs();	
			});
			function removeGroupUser(value){
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/user/removeGroupUser.do",
					data:"userId="+value,
					success:function(msg){
						if(msg="true"){
							window.location.href="${pageContext.request.contextPath}/user/queryGroupUsers.do?id="+$("#igId").val();
							alert("移除成功");
						}
					}
				});
			}
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<input type="hidden" value="${userInterestGroup.id }" id="igId" />
		<div id="div1" style="border-color: #0054AA; height: 1000px;">
			<ul>
				<li>
					<a href="#page">${userInterestGroup.groupName }小组成员</a>
				</li>
			</ul>
			<div id="page">
				<table border="0" width='99%' cellspacing='0' cellpadding='0'>
					<c:forEach var="u" items="${userInterestGroup.users }">
						<tr>
							<td style='border-top: 1px dotted #C2CCE3; height: 24;'>
								${u.loginName }
							</td>
							<td style='border-top: 1px dotted #C2CCE3; height: 24;'>
								${u.email }
							</td>
							<td align="right"
								style='border-top: 1px dotted #C2CCE3; height: 24'>
								<c:if
									test="${userInterestGroup.user.id==user.id&&u.id!=user.id}">
									<a href="#" onclick="removeGroupUser(${u.id });" style="color: red">移除该人</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td
							style='border-top: 1px dotted #C2CCE3; height: 24px; width: 350px'>
						</td>
						<td align="right"
							style='border-top: 1px dotted #C2CCE3; height: 24px'>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
