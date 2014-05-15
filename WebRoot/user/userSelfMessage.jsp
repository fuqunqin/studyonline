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
					<a href="#div11">个人资料</a>
				</li>
			</ul>
			<div id="div11">
				<table border="0" width='94%' cellspacing='0' cellpadding='0'>
					<tr valign="bottom">
						<td width="25%"
							style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							用户名：
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							${user.loginName }
						</td>
					</tr>
					<tr valign="bottom">
						<td style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							证件类型：
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							${user.certificate.description }
						</td>
					</tr>
					<tr valign="bottom">
						<td style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							证件类型：
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							${user.certificateNumber }
						</td>
					</tr>
					<tr valign="bottom">
						<td style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							邮箱：
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							${user.email }
						</td>
					</tr>
					<tr valign="bottom">
						<td style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							注册时间：
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
							<fmt:formatDate value="${user.registerDate }"
								pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr valign="bottom">
						<td style='border-top: 1px dotted #C2CCE3; height: 30;'></td>
						<td style='border-top: 1px dotted #C2CCE3;'>
						</td>
						<td style='border-top: 1px dotted #C2CCE3;'>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td colspan="2" width="450px" align="right">
							<img src="${pageContext.request.contextPath }/images/jiantou.gif"
								border="0" width="20px" height="20px" align="top" />
						</td>
						<td>
							<a style="color: red;"
								href="${pageContext.request.contextPath }/user/modifySelfMessage.jsp">修改个人资料</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
