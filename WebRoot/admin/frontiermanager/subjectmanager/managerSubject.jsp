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
			function validateSubject(){
				var subjectName=document.getElementById("subjectName").value;
				if(subjectName==null||subjectName==""){
					alert("请输入您要添加的学科类型");
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
					<th class="bg_tr" align="left" colspan="2" height="25">
						学科管理(共有
						<font color="red">${fn:length(subjects)}</font> 项)
					</th>
				</tr>
				<tr align="center">
					<td class="td_bg" width="20%" height="25">
						学科编号
					</td>
					<td class="td_bg" width="40%">
						学科名称
					</td>
				</tr>
				<c:forEach var="subject" items="${subjects }">
					<tr align="center">
						<td class="td_bg" height="25">
							${subject.id }
						</td>
						<td class="td_bg">
							${subject.subjectName }
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
						action="${pageContext.request.contextPath }/admin/addSubject.do"
						method="post">
						添加学科类型：
						<input type="text" name="subjectName" id="subjectName" />
						<input type="submit" value="添加"
							onclick="return validateSubject();" />
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>

