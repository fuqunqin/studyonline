<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifySutraBook(){
				var sutraBookId=document.getElementById("sutraBookId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateSutraBook.do?id="+sutraBookId;
			}
			function deleteSutraBook(){
				var sutraBookId=document.getElementById("sutraBookId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteSutraBooks.do?ids="+sutraBookId;
			}
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="td_bg">
				<td>
					经典图书名称：
				</td>
				<td colspan="3" align="center">
					${sutraBook.bookName }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属学科：
				</td>
				<td width="25%">
					${sutraBook.subject.subjectName }
				</td>
				<td width="25%">
					出版社：
				</td>
				<td width="25%">
					${sutraBook.publicCompany }
				</td>
			</tr>
			<tr class="td_bg">
				<td width="25%">
					作者：
				</td>
				<td width="25%">
					${sutraBook.bookUserName }
				</td>
				<td width="25%">
					出版时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${sutraBook.publicDate }" pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					图书简介：
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					${sutraBook.bookSynopsis }
				</td>
			</tr>
			<tr class="td_bg">
				<td>
					发布日期:
				</td>
				<td colspan="3">
					<fmt:formatDate value="${sutraBook.publishDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifySutraBook();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteSutraBook();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${sutraBook.id }" id="sutraBookId" />
	</body>
</html>
