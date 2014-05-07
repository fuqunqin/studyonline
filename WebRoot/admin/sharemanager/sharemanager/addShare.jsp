<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/ShareTypeDwr.js'></script>
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
				SubjectDwr.query(function(subjects){
					dwr.util.removeAllOptions("subjects");
					dwr.util.addOptions("subjects",subjects, "id", "subjectName");
				});
				ShareTypeDwr.query(function(shareTypes){
					dwr.util.removeAllOptions("shareTypes");
					dwr.util.addOptions("shareTypes",shareTypes, "id", "typeName");
				});
				document.getElementById("tiJiao").onclick=function(){
					var shareName=document.getElementById("shareName").value;
					if(shareName==null||shareName==""){
						alert("请输入共享资料名称");
						document.getElementById("shareName").focus();
						return false;
					}
					var uploadFile=document.getElementById("uploadFile").value;
					if(uploadFile==null||uploadFile==""){
						alert("请添加上传文件");
						document.getElementById("uploadFile").focus();
						return false;
					}
				};
			});
		</script>
	</head>
	<body>
		<form method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath }/admin/addShare.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						共享资料名称：
					</td>
					<td colspan="3">
						<input type="text" name="shareName" id="shareName" size="80" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属学科：
					</td>
					<td width="25%">
						<select name="subject" id="subjects"></select>
					</td>
					<td width="25%">
						所属类别：
					</td>
					<td width="25%">
						<select name="shareType" id="shareTypes"></select>
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						上传：
					</td>
					<td colspan="3">
						<input type="file" name="uploadFile" id="uploadFile" />
						<font color="red">（*上传文件大小不得超过100M）</font>
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
		</form>
		<font color="red">${adminUpLoadFileFalse }</font>
	</body>
</html>
