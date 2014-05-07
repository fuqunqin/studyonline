<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
a {
	text-transform: none;
	text-decoration: none;
	color: #000;
}

a:hover {
	color: #666666;
	text-decoration: none;
}

table {
	font-size: 9pt;
	font-family: 宋体;
	border-collapse: collapse;
}
</style>
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
					&nbsp;最新兴趣小组
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
					<c:forEach var="mainIg" items="${mainigs}">
						<table border=0 width='100%' cellspacing='0' cellpadding='0'>
							<tr>
								<td height=17>
									&nbsp;
									<img src="${pageContext.request.contextPath }/images/group.gif"
										align=absmiddle border=0 width=20 height=15>
									&nbsp;${mainIg.groupName }
								</td>
								<td align=center>
								</td>
							</tr>
						</table>
					</c:forEach>
					<table>
						<tr>
							<td height=5></td>
						</tr>
					</table>
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
		<table>
			<tr>
				<td height=5></td>
			</tr>
		</table>
	</body>
</html>
