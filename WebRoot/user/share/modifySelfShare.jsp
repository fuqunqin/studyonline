<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/usercss.css"
			rel="stylesheet" type="text/css">
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
		<div id="div1" style="border-color: #0054AA; height: 1000px">
			<ul>
				<li>
					<a href="#page">修改我的共享</a>
				</li>
			</ul>
			<div id="page">
				<form method="post"
					action="${pageContext.request.contextPath }/user/modifyShare.do">
					<table class="table" cellspacing="1" cellpadding="2" width="94%"
						align="center" border="0">
						<tr class="td_bg">
							<td>
								共享资料名称：
							</td>
							<td colspan="3">
								<input type="text" name="shareName" value="${share.shareName }"
									id="shareName" size="60" />
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
								上传资料：
							</td>
							<td colspan="3">
								<font color="red">*上传资料不得修改，如上传错误请删除整条信息重新上传，谢谢！</font>
								<input type="hidden" value="${share.shareUrl }" name="shareUrl" />
							</td>
						</tr>
						<tr class="td_bg">
							<td width="25%">
								上传时间：
							</td>
							<td colspan="3">
								<fmt:formatDate value="${share.shareDate }" pattern="yyyy-MM-dd" />
								<input type="hidden" name="shareDateStr"
									value="<fmt:formatDate value='${share.shareDate }' pattern='yyyy-MM-dd' />" />
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
					<input type="hidden" value="${share.id }" name="shareId" />
				</form>
			</div>
		</div>
	</body>
</html>
