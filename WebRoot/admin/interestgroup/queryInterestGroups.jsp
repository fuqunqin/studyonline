<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
	</head>
	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tr class="bg_tr" align="center">
				<td width="10%">
					小组编号
				</td>
				<td width="30%">
					小组名称
				</td>
				<td width="20%">
					小组成立人
				</td>
				<td width="30%">
					成立时间
				</td>
				<td width="10%">
					操作
				</td>
			</tr>
			<c:forEach var="interestGroup" items="${interestGroups }">
				<tr class="td_bg" align="center">
					<td>
						${interestGroup.id }
					</td>
					<td>
						${interestGroup.groupName }
					</td>
					<td>
						${interestGroup.user.loginName }
					</td>
					<td>
						<fmt:formatDate value="${interestGroup.groupDate }"
							pattern="yyyy-MM-dd" />
					</td>
					<td>
						<a style="color: red"
							href="${pageContext.request.contextPath }/admin/deleteGroup.do?id=${interestGroup.id }">删除小组</a>
					</td>
				</tr>
				<tr class="td_bg">
					<td colspan="5">
						<marquee height="10" onMouseOver=this.stop()
							onMouseOut=this.start() scrollamount=3 scrolldelay=100
							direction=left style="color: red; text-align: center;">
							小组公告: ${interestGroup.groupNotice }&nbsp;&nbsp;&nbsp;&nbsp;小组成员:
							<c:forEach var="u" items="${interestGroup.users }">
								${u.loginName}&nbsp;
							</c:forEach>
						</marquee>
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
		</div>
	</body>
</html>
