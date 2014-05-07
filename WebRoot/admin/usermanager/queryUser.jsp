<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyUser(){
				var userId=document.getElementById("userId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateUser.do?id="+userId;
			}
			function deleteUser(){
				var userId=document.getElementById("userId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteUsers.do?ids="+userId;
			}
			function activeUser(){
				var userId=document.getElementById("userId").value;
				window.location.href="${pageContext.request.contextPath}/admin/activeUsers.do?ids="+userId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					用户名：
				</td>
				<td colspan="3">
					${user.loginName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					证件类型：
				</td>
				<td width="25%">
					${user.certificate.description }
				</td>
				<td width="25%">
					证件号码：
				</td>
				<td width="25%">
					${user.certificateNumber }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td>
					邮箱：
				</td>
				<td colspan="3">
					${user.email }
				</td>
			</tr>
			<tr class="td_bg">
				<td>
					用户加入的小组
				</td>
				<td colspan="3">
					<c:forEach var="interestGroup" items="${user.interestGroups}">
						<font color="red">${interestGroup.groupName }</font>
						<br />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${interestGroup.groupNotice }
					</c:forEach>
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyUser();">
				</td>
				<td>
					<c:if test="${user.status.id==-1}">
						<input type="button" value="禁用" onclick="deleteUser();">
					</c:if>
					<c:if test="${user.status.id==1}">
						<input type="button" value="激活" onclick="activeUser();">
					</c:if>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${user.id }" id="userId" />
	</body>
</html>
