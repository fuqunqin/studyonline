<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/ShareTypeDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SubjectDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#div1").tabs();	
				SubjectDwr.query(function(subjects){
					dwr.util.removeAllOptions("subjects");
					dwr.util.addOptions("subjects",subjects);
				});
				ShareTypeDwr.query(function(shareTypes){
					dwr.util.removeAllOptions("shareTypes");
					dwr.util.addOptions("shareTypes",shareTypes);
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
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<div id="div1" style="border-color: #0054AA; height: 1000px;">
			<ul>
				<li>
					<a href="#page">添加共享</a>
				</li>
			</ul>
			<div id="page">
				<form method="post" enctype="multipart/form-data"
					action="${pageContext.request.contextPath }/user/addShare.do">
					<table class="table" cellspacing="1" cellpadding="2" width="94%"
						align="center" border="0">
						<tr class="td_bg">
							<td style='border-top: 1px dotted #C2CCE3; height: 50; width: 350px'>
								共享资料名称：
							</td>
							<td colspan="3" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								<input type="text" name="shareName" id="shareName" size="60" />
							</td>
						</tr>
						<tr height="30" class="td_bg">
							<td width="25%" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								所属学科：
							</td>
							<td width="25%" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								<select name="subject" id="subjects"></select>
							</td>
							<td width="25%" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								所属类别：
							</td>
							<td width="25%" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								<select name="shareType" id="shareTypes"></select>
							</td>
						</tr>
						<tr class="td_bg">
							<td width="25%" style='border-top: 1px dotted #C2CCE3; height: 50; '>
								上传：
							</td>
							<td colspan="3" style='border-top: 1px dotted #C2CCE3; height: 50; '>
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
			</div>
		</div>
	</body>
</html>
