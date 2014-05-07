<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<script type="text/javascript" src="js/page.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				jQuery.page("page",40); 
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
					<a href="#page">新系统消息</a>
				</li>
			</ul>
			<div id="page">
				<table border="0" width='99%' cellspacing='0' cellpadding='0'>
					<c:forEach var="userMessage" items="${userMessages }">

						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 50; width: 350px'>
								&nbsp;&nbsp;&nbsp; ${userMessage.message }(
								<a style="color: red"
									href="${pageContext.request.contextPath }/user/markUserMessage.do?id=${userMessage.id }">不再显示</a>)
							</td>
							<td valign="bottom" width="120px" align="right"
								style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${userMessage.publishDate }"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>

					</c:forEach>
					<tr>
						<td
							style='border-top: 1px dotted #C2CCE3; height: 30px; width: 350px'>
						</td>
						<td valign="bottom" width="120px" align="right"
							style='border-top: 1px dotted #C2CCE3; height: 30px'>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
