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
			function adminAddAdmin(){
				window.location.href="${pageContext.request.contextPath}/admin/adminmanager/addAdmin.jsp";
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
					管理员登陆名
				</td>
				<td width="20%">
					联系电话
				</td>
				<td width="20%">
					状态
				</td>
				<td colspan="2" width="10%">
					操作
				</td>
			</tr>
			<c:forEach var="admin" items="${admins }">
				<tr class="td_bg" align="center">
					<td>
						${admin.id }
					</td>
					<td>
						${admin.loginName }
					</td>
					<td>
						${admin.telephone }
					</td>
					<td>
						${admin.status.description }
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/queryAdmin.do?id=${admin.id }">查看</a>
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/updateAdmin.do?id=${admin.id }">修改</a>
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
			<input value="添加管理员" type="button" onclick="adminAddAdmin();" />
		</div>
	</body>
</html>
