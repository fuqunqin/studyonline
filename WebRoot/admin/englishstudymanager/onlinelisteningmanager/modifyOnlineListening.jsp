<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				};
			}
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyOnlineListening.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						在线听力名称：
					</td>
					<td colspan="3">
						<input type="text" name="title" id="title" size="80"
							value="${onlineListening.title }" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						上传时间：
					</td>
					<td colspan="3">
						<fmt:formatDate value="${onlineListening.publishDate }"
							pattern="yyyy-MM-dd" />
						<input type="hidden" name="publishDateStr"
							value="<fmt:formatDate value='${onlineListening.publishDate }'
							pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						上传文件：
					</td>
					<td colspan="3">
						<font color="red">*上传资料不得修改，如上传错误请删除整条信息重新上传，谢谢！</font>
						<input type="hidden" name="listenUrl"
							value="${onlineListening.listenUrl }" />
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
			<input type="hidden" name="onlineListeningId"
				value="${onlineListening.id }" />
		</form>
	</body>
</html>
