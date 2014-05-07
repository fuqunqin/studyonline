<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function modifyCertificateExam(){
				var certificateExamId=document.getElementById("certificateExamId").value;
				window.location.href="${pageContext.request.contextPath}/admin/updateCertificateExam.do?id="+certificateExamId;
			}
			function deleteCertificateExam(){
				var certificateExamId=document.getElementById("certificateExamId").value;
				window.location.href="${pageContext.request.contextPath}/admin/deleteCertificateExams.do?ids="+certificateExamId;
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
					${certificateExam.title }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					所属类别：
				</td>
				<td width="25%">
					${certificateExam.qualificationType.typeName }
				</td>
				<td width="25%">
					考试时间：
				</td>
				<td width="25%">
					<fmt:formatDate value="${certificateExam.examDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td colspan="4">
					所用材料：
				</td>
			</tr>
			<tr class="td_bg">
				<td colspan="4">
					${certificateExam.userBook }
				</td>
			</tr>
			<tr height="30" class="td_bg">
				<td width="25%">
					发布时间：
				</td>
				<td colspan="3">
					<fmt:formatDate value="${certificateExam.publishDate }"
						pattern="yyyy-MM-dd" />
				</td>
			</tr>
		</table>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="0">
			<tr height="30" align="center">
				<td>
					<input type="button" value="修改" onclick="modifyCertificateExam();">
				</td>
				<td>
					<input type="button" value="删除" onclick="deleteCertificateExam();">
				</td>
			</tr>
		</table>
		<input type="hidden" value="${certificateExam.id }"
			id="certificateExamId" />
	</body>
</html>
