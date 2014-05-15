<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link id="c3" type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#div1").tabs();	
			});
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<div id="div1" style="border-color: #0054AA; height: 1000px;">
			<ul>
				<li>
					<a href="#div11">在线听力</a>
				</li>
			</ul>
			<div id="div11">
				<table border="0" width='94%' cellspacing='0' cellpadding='0'>
					<tr bgcolor="#F6F6F6">
						<td colspan="4" height="15"></td>
					</tr>
					<tr bgcolor="#F6F6F6">
						<td width="5px"></td>
						<td colspan="2" valign="middle">
							<font size="3"><b> ${onlineListening.title } </b> </font>
						</td>
						<td width="5px"></td>
					</tr>
					<tr bgcolor="#F6F6F6">
						<td width="5px"></td>
						<td>
						</td>
						<td align="right">
							发布日期:
							<fmt:formatDate value="${onlineListening.publishDate }"
								pattern="yyyy-MM-dd" />
						</td>
						<td width="5px"></td>
					</tr>
					<tr bgcolor="#F6F6F6">
						<td colspan="4" height="15px">
						</td>
					</tr>
					<tr>
						<td colspan="4" height="15px">
						</td>
					</tr>
					<tr>
						<td width="5px"></td>
						<td colspan="2">
							<audio src="${onlineListening.listenUrl }" controls = "controls"></audio>
						</td>
						<td width="5px"></td>
					</tr>
					<tr height="50px">
						<td colspan="4"></td>
					</tr>
					<tr>
						<td colspan="3" align="right">
							<c:if test="${nextOnlineListening!=null}">上一篇:<a
									style="color: red"
									href="${pageContext.request.contextPath }/queryOnlineListening.do?id=${nextOnlineListening.id }">${nextOnlineListening.title}</a>
							</c:if>
							<c:if test="${nextOnlineListening==null}">上一篇:无</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${previousOnlineListening!=null}">下一篇:<a
									href="${pageContext.request.contextPath }/queryOnlineListening.do?id=${previousOnlineListening.id }"
									style="color: red">${previousOnlineListening.title}</a>
							</c:if>
							<c:if test="${previousOnlineListening==null}">下一篇:无</c:if>
						</td>
						<td width="5px"></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
