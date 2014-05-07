<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/HtmlEditor/editorArea.css"></link>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/addFrontier.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						标题：
					</td>
					<td colspan="3" align="center">
						${frontier.title }
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属学科：
					</td>
					<td width="25%">
						${frontier.subject.subjectName }
					</td>
					<td width="25%">
						学科动态类别：
					</td>
					<td width="25%">
						${frontier.frontierType.frontierType }
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td colspan="4">
						动态内容：
					</td>
				</tr>
				<tr class="td_bg">
					<td colspan="4">
						${frontier.content }
					</td>
				</tr>
				<tr class="td_bg">
					<td>
						发布日期:
					</td>
					<td colspan="3">
						<fmt:formatDate value="${frontier.publishDate }"
							pattern="yyyy-MM-dd" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
