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
					<a href="#div11">资料共享</a>
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
							<font size="3"><b> ${share.shareName } </b> </font>
						</td>
						<td width="5px"></td>
					</tr>
					<tr bgcolor="#F6F6F6">
						<td width="5px"></td>
						<td>
							<font color="red">${share.subject.subjectName
								}----${share.shareType.typeName } (上传人:<c:if
									test="${share.user==null }">
						管理员
					</c:if> <c:if test="${share.user!=null }">
						${share.user.loginName }
					</c:if>) </font>
						</td>
						<td align="right">
							上传日期:
							<fmt:formatDate value="${share.shareDate }" pattern="yyyy-MM-dd" />
						</td>
						<td width="5px"></td>
					</tr>
					<tr bgcolor="#F6F6F6">
						<td colspan="4" height="15px">
						</td>
					</tr>
					<tr>
					<td width="5px"></td>
						<td colspan="4">
							<c:if test="${flex!=null&&flex}">
							<iframe src="../flexpaper/flexpaper.jsp?url=${share.shareUrl}" height="480px"width="660px"></iframe>
							</c:if>
						</td>
						<td width="5px"></td>
					</tr>
					<tr>
						<td width="5px"></td>
						<td colspan="4">
							<a
								href="${pageContext.request.contextPath }/user/downLoad.do?downUrl=${share.shareUrl }"><font
								color="red">下载</font> </a>
						</td>
						<td width="5px"></td>
					</tr>
					<tr height="50px">
						<td colspan="4"></td>
					</tr>
					<tr>
						<td colspan="3" align="right">
							<c:if test="${nextShare!=null}">上一篇:<a style="color: red"
									href="${pageContext.request.contextPath }/queryShare.do?id=${nextShare.id }">${nextShare.shareName}</a>
							</c:if>
							<c:if test="${nextShare==null}">上一篇:无</c:if>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<c:if test="${previousShare!=null}">下一篇:<a
									href="${pageContext.request.contextPath }/queryShare.do?id=${previousShare.id }"
									style="color: red">${previousShare.shareName}</a>
							</c:if>
							<c:if test="${previousShare==null}">下一篇:无</c:if>
						</td>
						<td width="5px"></td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
