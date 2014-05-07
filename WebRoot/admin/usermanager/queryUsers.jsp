<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function adminAddUser(){
				window.location.href="${pageContext.request.contextPath}/admin/usermanager/addUser.jsp";
			}
		</script>
	</head>
	<body>

		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="bg_tr" align="center">
				<td width="5%">
					编号
				</td>
				<td width="20%">
					用户名
				</td>
				<td width="20%">
					邮箱
				</td>
				<td width="20%">
					状态
				</td>
				<td colspan="2" width="10%">
					操作
				</td>
			</tr>
			<c:forEach var="user" items="${users }">
				<tr class="td_bg" align="center">
					<td>
						${user.id }
					</td>
					<td>
						${user.loginName }
					</td>
					<td>
						${user.email }
					</td>
					<td>
						${user.status.description }
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/queryUser.do?id=${user.id }">查看</a>
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/updateUser.do?id=${user.id }">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center">
			<form action="">
				第
				<font color="red">${page.pageIndex }</font>页/共
				<font color="red">${page.totalPage }</font>页
				<select name="pageIndex">
					<c:forEach var="pageIndex" begin="1" end="${page.totalPage}"
						step="1">
						<option value="${pageIndex }"
							<c:if test="${pageIndex==page.pageIndex }">selected="selected"</c:if>>
							${pageIndex }
						</option>
					</c:forEach>
				</select>
				<input value="Go" type="submit" />
			</form>
			<input value="添加用户" type="button" onclick="adminAddUser();" />
		</div>
	</body>
</html>
