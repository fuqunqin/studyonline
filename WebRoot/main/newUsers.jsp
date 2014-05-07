<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<table>
			<tr>
				<td height=5></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class='lefttopcenter'>
					&emsp;
					<img border=0
						src='${pageContext.request.contextPath }/mainimages/mor.gif'
						align=absmiddle>
					&nbsp;最新会员
				</td>
				<td class='lefttopright'></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0' height="200px">
			<tr>
				<td valign='top' class='leftcentercenter' height=115 align='center'>
					<table>
						<tr>
							<td height=5></td>
						</tr>
					</table>
					
					<table>
						<tr>
							<td height=5></td>
						</tr>
					</table>
					<c:forEach var="mainu" items="${mainus}">
						<table border=0 width='100%' cellspacing='0' cellpadding='0'>
							<tr>
								<td height=17>
									&nbsp;
									<img
										src="${pageContext.request.contextPath }/mainimages/usertitle.gif"
										align=absmiddle border=0 width=15 height=15>
									&nbsp;${mainu.loginName }
								</td>
								<td width=80 align=center>
									<fmt:formatDate value="${mainu.registerDate }"
										pattern="yyyy-MM-dd" />
								</td>
							</tr>
						</table>
						<table>
							<tr>
								<td height=5></td>
							</tr>
						</table>
					</c:forEach>
				</td>
				<td class=leftcenterright></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class='leftfootcenter'></td>
				<td class='leftfootright'></td>
			</tr>
		</table>
	</body>
</html>
