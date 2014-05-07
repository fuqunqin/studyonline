<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				};
			});
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyShare.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						共享资料名称：
					</td>
					<td colspan="3">
						<input type="text" name="shareName" value="${share.shareName }"
							id="shareName" size="80" />
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
						上传人：
					</td>
					<td width="25%">
						<c:if test="${share.user==null }">
							管理员
						</c:if>
						<c:if test="${share.user!=null }">
							${share.user.loginName }
						</c:if>
					</td>
					<td width="25%">
						上传时间：
					</td>
					<td width="25%">
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
	</body>
</html>
