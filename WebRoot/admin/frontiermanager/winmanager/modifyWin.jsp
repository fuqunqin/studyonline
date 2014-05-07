<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SubjectDwr.js'></script>
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
				$("#winDateStr").focus(
					function(){
						WdatePicker({
							skin:'whyGreen',
							oncleared:function(){
								$(this).blur();
						}
					})
				});
				SubjectDwr.query(function(subjects){
					dwr.util.removeAllOptions("subjects");
					dwr.util.addOptions("subjects",subjects );
				});
				document.getElementById("tiJiao").onclick=function(){
					var winName=document.getElementById("winName").value;
					if(winName==null||winName==""){
						alert("请输入科研成果名称");
						document.getElementById("winName").focus();
						return false;
					}
					var winUserName=document.getElementById("winUserName").value;
					if(winUserName==null||winUserName==""){
						alert("请输入获奖人姓名");
						document.getElementById("winUserName").focus();
						return false;
					}
					var winDateStr=document.getElementById("winDateStr").value;
					if(winDateStr==null||winDateStr==""){
						alert("请选择获奖时间");
						document.getElementById("winDateStr").focus();
						return false;
					}
				};
			});
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyWin.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						科研成果名称：
					</td>
					<td colspan="3">
						<input type="text" name="winName" id="winName" size="80"
							value="${win.winName }" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属学科：
					</td>
					<td colspan="3">
						<select name="subject" id="subjects"></select>
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						获奖人：
					</td>
					<td width="25%">
						<input type="text" name="winUserName" id="winUserName"
							value="${win.winUserName }" />
					</td>
					<td width="25%">
						获奖时间：
					</td>
					<td width="25%">
						
						<input type="text" readonly="readonly" name="winDateStr"
							id="winDateStr"
							value="<fmt:formatDate value='${win.winDate }' pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td colspan="4">
						科研成果描述：
					</td>
				</tr>
				<tr class="td_bg">
					<td colspan="4">
						<textarea name="winDescription" cols="110" rows="20">${win.winDescription }</textarea>
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
			<input type="hidden" value="${win.id }" name="winId" />
			<input type="hidden" name="publishDateStr" id="publishDateStr"
				value="<fmt:formatDate value='${win.publishDate }' pattern='yyyy-MM-dd' />" />
		</form>
	</body>
</html>
