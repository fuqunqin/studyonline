<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyEnglishStudy(){
				var englishStudyId=document.getElementById("englishStudyId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateEnglishStudy.do?id="+englishStudyId;
			}
			function deleteEnglishStudy(){
				var englishStudyId=document.getElementById("englishStudyId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteEnglishStudies.do?ids="+englishStudyId;
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
					${englishStudy.title }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					发布时间：
				</td>
				<td colspan="3">
					<fmt:formatDate value="${englishStudy.publishDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td colspan="4">
					内容：
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					${englishStudy.content }
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyEnglishStudy();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteEnglishStudy();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${englishStudy.id }" id="englishStudyId" />
	</body>
</html>
