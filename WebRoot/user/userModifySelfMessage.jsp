<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/UserDwr.js'></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link id="c3" type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>

		<style type="text/css">
</style>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#div1").tabs();	
			});
			function validateEmail(){
				var email=document.getElementById("email").value;
				if(email==null||email==""){
					alert("邮箱地址不能为空");
					document.getElementById("email").focus();
					return false;
				}
				var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
				var emailBool=reg.test(email);
				if(emailBool==false){
					alert("邮箱地址不合法");
					document.getElementById("email").focus();
					return false;
				}
			}
			function validatePassword(){
				jQuery.noConflict();
				var loginName=document.getElementById("loginName").value;
				var firstLoginPassword=document.getElementById("firstLoginPassword").value;
				UserDwr.queryUserLoginPassword(loginName,firstLoginPassword,function(bool){
					if(bool==false){
						alert("您输入的密码错误");
						document.getElementById("firstLoginPassword").value="";
					}
				})
			}
			function submitPassword(){
				var firstLoginPassword=document.getElementById("firstLoginPassword").value;
				if(firstLoginPassword==null||firstLoginPassword==""){
					alert("请输入原密码");
					return false;
				}
				var loginPassword=document.getElementById("loginPassword").value;
				if(loginPassword==null||loginPassword==""){
					alert("请输入新密码");
					return false;
				}
				var beginLoginPassword=document.getElementById("beginLoginPassword").value;
				if(loginPassword!=beginLoginPassword){
					alert("两次输入的新密码不一致");
					return false;
				}
			}
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
					<a href="#div11">邮箱修改</a>
				</li>
				<li>
					<a href="#div22">证件修改</a>
				</li>
				<li>
					<a href="#div33">密保修改</a>
				</li>
				<li>
					<a href="#div44">密码修改</a>
				</li>
			</ul>
			<div id="div11">
				<form
					action="${pageContext.request.contextPath }/user/modifySelf.do?modifyFlag=email"
					method="post">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								邮箱地址：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="text" value="${user.email }" id="email"
									name="email" />
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="修改"
									onclick="return validateEmail();" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="div22">
				<form
					action="${pageContext.request.contextPath }/user/modifySelf.do?modifyFlag=certificate"
					method="post">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								证件类型：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<select name="certificate">
									<c:forEach var="certificate" items="${certificates}">
										<option value="${certificate.id }"
											<c:if test="${certificate.id==user.certificate.id}">selected="selected"</c:if>>
											${certificate.description }
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								证件号码：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="text" value="${user.certificateNumber }"
									name="certificateNumber" />
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="修改" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="div33">
				<form
					action="${pageContext.request.contextPath }/user/modifySelf.do?modifyFlag=security"
					method="post">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								密保问题：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<select name="security">
									<c:forEach var="security" items="${securities}">
										<option value="${security.id }"
											<c:if test="${security.id==user.security.id}">selected="selected"</c:if>>
											${security.description }
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								证件号码：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="text" value="${user.securityAnswer }"
									name="securityAnswer" />
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="修改" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="div44">
				<form
					action="${pageContext.request.contextPath }/user/modifySelf.do?modifyFlag=loginPassword"
					method="post">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								输入原密码：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="password" value="" onchange="validatePassword();"
									id="firstLoginPassword" />
								<input type="hidden" value="${user.loginName }" id="loginName" />
							</td>
						</tr>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								输入新密码：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="password" name="loginPassword" id="loginPassword" />
							</td>
						</tr>
						<tr>
							<td align="right" width="45%"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								再次输入新密码：
							</td>
							<td style='border-top: 1px dotted #C2CCE3;'>
								<input type="password" name="beginLoginPassword"
									id="beginLoginPassword" />
							</td>
						</tr>
						<tr align="center">
							<td colspan="2">
								<input type="submit" value="修改"
									onclick="return submitPassword();" />
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
