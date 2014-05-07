<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师科研成果管理系统注册</title>
		<style type="text/css">
body {
	background-repeat: repeat;
}

input {
	width: 155px;
	color: #007AB5;
}
</style>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript">
			window.onload=function(){
				$("userSubmit").onclick=function(){
					var loginPassword=$("loginPassword").value;
					if(loginPassword==null||loginPassword==""){
						alert("密码不能为空");
						$("loginPassword").focus();
						return false;
					}
					var aginLoginPassword=$("aginLoginPassword").value;
					if(loginPassword!=aginLoginPassword){
						alert("两次输入密码不一致");
						$("aginLoginPassword").value="";
						$("aginLoginPassword").focus();
						return false;
					}
					var certificateNumber=$("certificateNumber").value;
					if(certificateNumber==null||certificateNumber==""){
						alert("证件号码不能为空");
						$("certificateNumber").value="";
						$("certificateNumber").focus();
						return false;
					}
					var securityAnswer=$("securityAnswer").value;
					if(securityAnswer==null||securityAnswer==""){
						alert("密保问题不能为空");
						$("securityAnswer").value="";
						$("securityAnswer").focus();
						return false;
					}
					var email=$("email").value;
					if(email==null||email==""){
						alert("邮箱地址不能为空");
						$("email").value="";
						$("email").focus();
						return false;
					}
					var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
					var emailBool=reg.test(email);
					if(emailBool==false){
						alert("邮箱地址不合法");
						$("email").value="";
						$("email").focus();
						return false;
					}
				}
			}
		</script>
	</head>
	<body topmargin="20px">
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifyUser.do">
			<table align="center">
				<tr align="center">
					<td colspan="3">
						<h4>
							修改用户信息
						</h4>
					</td>
				</tr>
				<tr>
					<td width="100px">
						用户名：
					</td>
					<td width="100px" colspan="2">
						${user.loginName }
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" value="${user.loginPassword }"
							name="loginPassword" id="loginPassword" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						再次输入密码：
					</td>
					<td>
						<input type="password" value="${user.loginPassword }"
							name="aginLoginPassword" id="aginLoginPassword" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						证件类型：
					</td>
					<td>
						<select name="certificate" id="certificates" style="width: 155px;">
							<c:forEach var="certificate" items="${certificates }">
								<option value="${certificate.id }"
									<c:if test="${certificate.id==user.certificate.id}">selected="selected"</c:if>>
									${certificate.description }
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						证件号码：
					</td>
					<td>
						<input type="text" value="${user.certificateNumber }"
							name="certificateNumber" id="certificateNumber" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						邮箱地址：
					</td>
					<td>
						<input type="text" value="${user.email }" name="email" id="email" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr align="center">
					<td colspan="3">
						<input type="submit" value=" 修 改 " id="userSubmit"
							style="width: 50px;">
						&nbsp;
						<input type="reset" value=" 重 置 " style="width: 50px;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
