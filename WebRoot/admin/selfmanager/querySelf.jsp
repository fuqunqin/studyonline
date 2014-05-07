<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyAdminBase(){
				window.location.href="${pageContext.request.contextPath}/admin/selfmanager/modifyBase.jsp";
			}
			function modifyAdminSafe(){
				window.location.href="${pageContext.request.contextPath}/admin/selfmanager/modifySafe.jsp";
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
					${admin.loginName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					证件类型：
				</td>
				<td width="25%">
					${admin.certificate.description }
				</td>
				<td width="25%">
					证件号码：
				</td>
				<td width="25%">
					${admin.certificateNumber }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td>
					邮箱：
				</td>
				<td>
					${admin.email }
				</td>
				<td>
					联系电话：
				</td>
				<td>
					${admin.telephone }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td>
					联系地址：
				</td>
				<td colspan="3">
					${admin.address }
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改基本信息" onclick="modifyAdminBase();">
				</td>
				<td>
					<input type="button" value="修改安全信息" onclick="modifyAdminSafe();">
				</td>
			</tr>
		</table>
	</body>
</html>
