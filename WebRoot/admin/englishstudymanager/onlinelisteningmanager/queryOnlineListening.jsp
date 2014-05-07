<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function modifyOnlineListening(){
				var onlineListeningId=document.getElementById("onlineListeningId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateOnlineListening.do?id="+onlineListeningId;
			}
			function deleteOnlineListening(){
				var onlineListeningId=document.getElementById("onlineListeningId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteOnlineListenings.do?ids="+onlineListeningId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					在线听力名称：
				</td>
				<td colspan="3">
					${onlineListening.title }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					上传时间：
				</td>
				<td colspan="3">
					<fmt:formatDate value="${onlineListening.publishDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					上传资料：
				</td>
				<td colspan="3">
					<embed src="${onlineListening.listenUrl }">
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyOnlineListening();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteOnlineListening();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${onlineListening.id }"
			id="onlineListeningId" />
	</body>
</html>
