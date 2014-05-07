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
		<div id="div1" style="border-color: #0054AA; height: 1050px">
			<ul>
				<li>
					<a href="#div11">资料共享</a>
				</li>
			</ul>
			<div id="div11">
				<c:forEach var="share" items="${shares }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 320px'>
								&nbsp;[${share.subject.subjectName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryShare.do?id=${share.id }"><font
									color='#000000'> <c:if
											test="${fn:length(share.shareName)>15}">
													${fn:substring(share.shareName, 0, 15)}...
												</c:if> <c:if test="${fn:length(share.shareName)<=15}">
												${share.shareName }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${share.shareDate }" pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${spage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${spage.totalPage}" step="1">
						<c:if test="${spage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${spage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryShares.do?spageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</body>
</html>
