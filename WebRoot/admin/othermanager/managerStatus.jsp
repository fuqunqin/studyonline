<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
	</head>

	<body>
		<table class="table" cellspacing="1" cellpadding="2" width="99%"
			align="center" border="0">
			<tbody>
				<tr>
					<th class="bg_tr" align="left" colspan="5" height="25">
						状态管理(共有
						<font color="red">${fn:length(statuses)}</font> 项)
					</th>
				</tr>
				<tr align="center">
					<td class="td_bg" width="50%" height="25">
						状态编号
					</td>
					<td class="td_bg" width="50%">
						状态描述
					</td>
				</tr>
				<c:forEach var="status" items="${statuses }">
					<tr align="center">
						<td class="td_bg" height="25">
							${status.id }
						</td>
						<td class="td_bg">
							${status.description }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>