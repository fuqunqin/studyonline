<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			window.onload=function(){
				document.getElementById("tiJiao").onclick=function(){
					var title=document.getElementById("title").value;
					if(title==null||title==""){
						alert("请输入在线听力名称");
						document.getElementById("title").focus();
						return false;
					}
					var uploadFile=document.getElementById("uploadFile").value;
					var pos = uploadFile.lastIndexOf(".");
					var lastname = uploadFile.substring(pos,uploadFile.length);
					if(lastname.toLowerCase()!='.mp3'){
						alert("请添加mp3格式的音频文件");
						document.getElementById("uploadFile").focus();
						return false;
					}
					if(uploadFile==null||uploadFile==""){
						alert("请添加上传文件");
						document.getElementById("uploadFile").focus();
						return false;
					}
				};
			}
		</script>
	</head>
	<body>
		<form method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath }/admin/addOnlineListening.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						在线听力名称：
					</td>
					<td colspan="3">
						<input type="text" name="title" id="title" size="80" />
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						上传：
					</td>
					<td colspan="3">
						<input type="file" name="uploadFile" id="uploadFile" />
						<font color="red">（*上传文件格式为mp3音频格式，大小不得超过100M）</font>
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
