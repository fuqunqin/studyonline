<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
					dwr.util.addOptions("qualificationTypes",qualificationTypes);
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
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyTest.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						资格测试试题名称：
					</td>
					<td colspan="3">
						<input type="text" name="title" value="${test.title }" id="title"
							size="80" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属类别：
					</td>
					<td width="25%">
						<select name="qualificationType" id="qualificationTypes"></select>
					</td>
					<td width="25%">
						上传时间：
					</td>
					<td width="25%">
						<fmt:formatDate value="${test.uploadeDate }" pattern="yyyy-MM-dd" />
						<input type="hidden" name="uploadeDateStr"
							value="<fmt:formatDate value='${test.uploadeDate }' pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						上传资料：
					</td>
					<td colspan="3">
						<font color="red">*上传资料不得修改，如上传错误请删除整条信息重新上传，谢谢！</font>
						<input type="hidden" value="${test.uploadeUrl }" name="uploadeUrl" />
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
			<input type="hidden" value="${test.id }" name="testId" />
		</form>
	</body>
</html>
