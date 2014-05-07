<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyAdmin(){
				var adminId=document.getElementById("adminId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateAdmin.do?id="+adminId;
			}
			function deleteAdmin(){
				var adminId=document.getElementById("adminId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteAdmin.do?id="+adminId;
			}
			function activeAdmin(){
				var adminId=document.getElementById("adminId").value;
				window.location.href="${pageContext.request.contextPath}/admin/activeAdmin.do?ids="+adminId;
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
					${a.loginName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					证件类型：
				</td>
				<td width="25%">
					${a.certificate.description }
				</td>
				<td width="25%">
					证件号码：
				</td>
				<td width="25%">
					${a.certificateNumber }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td>
					邮箱：
				</td>
				<td>
					${a.email }
				</td>
				<td>
					联系电话：
				</td>
				<td>
					${a.telephone }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td>
					联系地址：
				</td>
				<td colspan="3">
					${a.address }
				</td>
			</tr>
			<tr class="td_bg">
				<td>
					权限设置：
				</td>
				<td colspan="3">
					<c:forEach var="menu" items="${a.menues }">
						${menu.menuName }
					</c:forEach>
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyAdmin();">
				</td>
				<td>
					<c:if test="${a.status.id==-1}">
						<input type="button" value="禁用" onclick="deleteAdmin();">
					</c:if>
					<c:if test="${a.status.id==1}">
						<input type="button" value="激活" onclick="activeAdmin();">
					</c:if>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${a.id }" id="adminId" />
	</body>
</html>
