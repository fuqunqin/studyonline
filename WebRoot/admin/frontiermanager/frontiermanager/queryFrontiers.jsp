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
			function adminAddFrontier(){
				window.location.href="${pageContext.request.contextPath}/admin/frontiermanager/frontiermanager/addFrontier.jsp";
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
					所属学科
				</td>
				<td width="10%">
					所属类别
				</td>
				<td width="50%">
					标题
				</td>
				<td colspan="3" width="15%">
					操作
				</td>
			</tr>
			<c:forEach var="frontier" items="${frontieres }">
				<tr class="td_bg" align="center">
					<td>
						${frontier.id }
					</td>
					<td>
						${frontier.subject.subjectName }
					</td>
					<td>
						${frontier.frontierType.frontierType }
					</td>
					<td>
						${frontier.title }
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/queryFrontier.do?id=${frontier.id }">查看</a>
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/updateFrontier.do?id=${frontier.id }">修改</a>
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/deleteFrontier.do?id=${frontier.id }">删除</a>
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
			<input value="添加学科动态" type="button" onclick="adminAddFrontier();" />
		</div>
	</body>
</html>
