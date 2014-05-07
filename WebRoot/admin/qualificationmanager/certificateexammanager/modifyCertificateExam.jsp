<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/HtmlEditor/editorArea.css"></link>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/QualificationTypeDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/jquery_last.js"></script>
		<script defer="defer" type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/DateTimeMask.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#examDateStr").focus(
					function(){
						WdatePicker({
							skin:'whyGreen',
							oncleared:function(){
								$(this).blur();
						}
					})
				});
				QualificationTypeDwr.query(function(qualificationTypes){
					dwr.util.removeAllOptions("qualificationTypes");
					dwr.util.addOptions("qualificationTypes",qualificationTypes, "id", "typeName");
				});
				document.getElementById("tiJiao").onclick=function(){
					var title=document.getElementById("title").value;
					if(title==null||title==""){
						alert("请输入标题名称");
						document.getElementById("title").focus();
						return false;
					}
					var examDateStr=document.getElementById("examDateStr").value;
					if(examDateStr==null||examDateStr==""){
						alert("请输入考试时间");
						document.getElementById("examDateStr").focus();
						return false;
					}
					var userBook=document.getElementById("userBook").value;
					if(userBook==null||userBook==""){
						alert("请输入所用材料");
						document.getElementById("userBook").focus();
						return false;
					}
				};
			});
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyCertificateExam.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr>
					<td>
						标题：
					</td>
					<td colspan="3">
						<input type="text" name="title" id="title" size="80"
							value="${certificateExam.title }" />
					</td>
				</tr>
				<tr height="30">
					<td width="25%">
						所属类别：
					</td>
					<td width="25%">
						<select name="qualificationType" id="qualificationTypes"></select>
					</td>
					<td width="25%">
						考试时间：
					</td>
					<td width="25%">
						<input type="text" id="examDateStr" readonly="readonly"
							name="examDateStr"
							value="<fmt:formatDate value='${certificateExam.examDate }'
						pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr height="30">
					<td colspan="4">
						所用材料：(可简略介绍)
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<textarea name="userBook" id="userBook" cols="110" rows="20">${certificateExam.userBook }</textarea>
					</td>
				</tr>
				<tr height="30">
					<td width="25%">
						考试时间：
					</td>
					<td colspan="3">
						<fmt:formatDate value="${certificateExam.publishDate }"
							pattern="yyyy-MM-dd" />
						<input type="hidden" name="publishDateStr"
							value="<fmt:formatDate value='${certificateExam.publishDate }'
							pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
			</table>
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="0">
				<tr height="30" align="center">
					<td>
						<input type="submit" value="提交" id="tiJiao">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
			<input type="hidden" name="certificateExamId"
				value="${certificateExam.id }" />
		</form>
	</body>
</html>
