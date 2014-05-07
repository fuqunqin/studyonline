<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function modifyWin(){
				var winId=document.getElementById("winId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateWin.do?id="+winId;
			}
			function deleteWin(){
				var winId=document.getElementById("winId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteWins.do?ids="+winId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					科研成果名称：
				</td>
				<td colspan="3" align="center">
					${win.winName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属学科：
				</td>
				<td colspan="3">
					${win.subject.subjectName }
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					获奖人：
				</td>
				<td width="25%">
					${win.winUserName }
				</td>
				<td width="25%">
					获奖时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${win.winDate }" pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					动态内容：
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					${win.winDescription }
				</td>
			</tr>
			<tr class="td_bg">
				<td>
					发布日期:
				</td>
				<td colspan="3">
					<fmt:formatDate value="${win.publishDate }" pattern="yyyy-MM-dd" />
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyWin();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteWin();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${win.id }" id="winId" />
	</body>
</html>
