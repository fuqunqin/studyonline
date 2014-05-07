<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function modifyTest(){
				var testId=document.getElementById("testId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateTest.do?id="+testId;
			}
			function deleteTest(){
				var testId=document.getElementById("testId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteTests.do?ids="+testId;
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
					${test.title }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属类别：：
				</td>
				<td width="25%">
					${test.qualificationType.typeName }
				</td>
				<td width="25%">
					上传时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${test.uploadeDate }" pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					上传资料：
				</td>
				<td colspan="3">
					<a
						href="${pageContext.request.contextPath }/admin/downLoadTest.do?uploadeUrl=${test.uploadeUrl }"><font
						color="red">下载</font> </a>
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyTest();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteTest();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${test.id }" id="testId" />
	</body>
</html>
