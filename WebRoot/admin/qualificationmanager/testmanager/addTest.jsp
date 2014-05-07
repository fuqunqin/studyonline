<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/QualificationTypeDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SubjectDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript">
			window.onload=function(){
				QualificationTypeDwr.query(function(qualificationTypes){
					dwr.util.removeAllOptions("qualificationTypes");
					dwr.util.addOptions("qualificationTypes",qualificationTypes, "id", "typeName");
				});
				$("tiJiao").onclick=function(){
					var title=$("title").value;
					if(title==null||title==""){
						alert("请输入标题");
						$("title").focus();
						return false;
					}else{
						return true;
					}
				};
			}
		</script>
	</head>
	<body>
		<form method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath }/admin/addTest.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						资格测试试题名称：
					</td>
					<td colspan="3">
						<input type="text" name="title" id="title" size="80" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属类别：
					</td>
					<td colspan="3">
						<select name="qualificationType" id="qualificationTypes"></select>
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
