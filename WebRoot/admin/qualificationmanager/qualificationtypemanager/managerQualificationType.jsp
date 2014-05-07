<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			function validateQualificationType(){
				var typeName=document.getElementById("typeName").value;
				if(typeName==null||typeName==""){
					alert("请输入您要添加的资格认证类别");
					return false;
				}else if(!confirm("确定提交吗？")){
					return false;
				}
			}
			
		</script>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tbody>
				<tr>
					<th class="bg_tr" align="left" colspan="5" height="25">
						资格认证类别管理(共有
						<font color="red">${fn:length(pubmedTypes)}</font> 项)
					</th>
				</tr>
				<tr align="center">
					<td class="td_bg" width="20%" height="25">
						资格认证类别编号
					</td>
					<td class="td_bg" width="40%">
						资格认证类别描述
					</td>
				</tr>
				<c:forEach var="qualificationType" items="${qualificationTypes }">
					<tr align="center">
						<td class="td_bg" height="25">
							${qualificationType.id }
						</td>
						<td class="td_bg">
							${qualificationType.typeName }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<hr color="red" />
		<table cellspacing="0" cellpadding="0" width="99%" align="center"
			border="0">
			<tr align="center">
				<td>
					<form
						action="${pageContext.request.contextPath }/admin/addQualificationType.do"
						method="post">
						添加资格认证类别：
						<input type="text" name="typeName" id="typeName" />
						<input type="submit" value="添加"
							onclick="return validateQualificationType();" />
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>

