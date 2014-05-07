<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyAccreditation(){
				var accreditationId=document.getElementById("accreditationId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateAccreditation.do?id="+accreditationId;
			}
			function deleteAccreditation(){
				var accreditationId=document.getElementById("accreditationId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteAccreditations.do?ids="+accreditationId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					标题：
				</td>
				<td colspan="3">
					${accreditation.title }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属类别：
				</td>
				<td width="25%">
					${accreditation.qualificationType.typeName }
				</td>
				<td width="25%">
					发布时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${accreditation.publishDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td colspan="4">
					动态内容：
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					${accreditation.content }
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyAccreditation();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteAccreditation();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${accreditation.id }" id="accreditationId" />
	</body>
</html>
