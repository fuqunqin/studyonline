<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function modifyShare(){
				var shareId=document.getElementById("shareId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateShare.do?id="+shareId;
			}
			function deleteShare(){
				var shareId=document.getElementById("shareId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteShares.do?ids="+shareId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					共享资料名称：
				</td>
				<td colspan="3">
					${share.shareName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属学科：
				</td>
				<td width="25%">
					${share.subject.subjectName }
				</td>
				<td width="25%">
					所属类别：
				</td>
				<td width="25%">
					${share.shareType.typeName }
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					上传资料：
				</td>
				<td colspan="3">
					<a
						href="${pageContext.request.contextPath }/admin/downLoadShare.do?shareUrl=${share.shareUrl }"><font
						color="red">下载</font> </a>
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					上传人：
				</td>
				<td width="25%">
					<c:if test="${share.user==null }">
						管理员
					</c:if>
					<c:if test="${share.user!=null }">
						${share.user.loginName }
					</c:if>
				</td>
				<td width="25%">
					上传时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${share.shareDate }" pattern="yyyy-MM-dd" />
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyShare();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteShare();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${share.id }" id="shareId"/>
	</body>
</html>
