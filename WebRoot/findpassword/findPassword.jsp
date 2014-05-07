<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/AdminDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SecurityDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<style type="text/css">
body {
	background-image:
		url("${pageContext.request.contextPath}/images/register.jpg");
	background-repeat: repeat;
}
</style>
		<script type="text/javascript">
			window.onload=function(){
				SecurityDwr.query(function(securities){
					dwr.util.removeAllOptions("securities");
					dwr.util.addOptions("securities",securities, "id", "description");
				});
			}
			function adminSubmit(){
				var loginName=document.getElementById("loginName").value;
				if(loginName==null||loginName==""){
					alert("请输入用户名");
					document.getElementById("loginName").focus();
					return false;
				}
				var securityAnswer=document.getElementById("securityAnswer").value;
				if(securityAnswer==null||securityAnswer==""){
					alert("密保答案不能为空");
					document.getElementById("securityAnswer").focus();
					return false;
				}
			}
			function adminSubmit2(){
				var loginPassword=document.getElementById("loginPassword").value;
				if(loginPassword==null||loginPassword==""){
					alert("密码不能为空");
					document.getElementById("loginPassword").focus();
					return false;
				}
				var aginLoginPassword=document.getElementById("aginLoginPassword").value;
				if(loginPassword!=aginLoginPassword){
					alert("两次输入密码不一致");
					document.getElementById("aginLoginPassword").value="";
					document.getElementById("aginLoginPassword").focus();
					return false;
				}
			}
		</script>
	</head>
	<body topmargin="10px">
		<table align="center" width="99%">
			<tr align="right" height="50px">
				<td>
					<a href="${pageContext.request.contextPath }/admin/login.jsp"
						style="color: red;font-size: 13px">返回登录</a>
				</td>
			</tr>
			<tr height="50px">
				<td>
					&nbsp;
				</td>
			</tr>
			<tr align="center" height="50px">
				<td>
					<font color="red" size="5">输入相应的信息找回密码</font>
				</td>
			</tr>
		</table>
		<c:if test="${findFlag==null}">
			<form method="post"
				action="${pageContext.request.contextPath }/findPassword.do">
				<table align="center">
					<tr>
						<td width="100px">
							管理用户名：
						</td>
						<td width="100px">
							<input type="text" value="" name="loginName" />
						</td>
						<td width="30px">
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>
							密保问题：
						</td>
						<td>
							<select name="security" style="width: 150px;" id="securities">
							</select>
						</td>
						<td>
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>
							密保答案:
						</td>
						<td>
							<input type="text" value="" name="securityAnswer"
								id="securityAnswer" style="width: 150px" />
						</td>
						<td>
							<font color="red">*</font>
						</td>
					</tr>
					<tr align="center">
						<td colspan="3">
							<input type="submit" value="确定" style="font-size: 15px"
								onclick="return adminSubmit();">
							&nbsp;
							<input type="reset" value="重置" style="font-size: 15px">
						</td>
					</tr>
				</table>
				<table align="center">
					<tr align="center">
						<td>
							<font color="red">${findError }</font>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${findFlag!=null}">
			<form method="post"
				action="${pageContext.request.contextPath }/findPassword2.do">
				<table align="center">
					<tr>
						<td width="100px">
							管理用户名：
						</td>
						<td width="100px">
							${admin.loginName }
						</td>
						<td width="30px">
						</td>
					</tr>
					<tr>
						<td>
							新密码：
						</td>
						<td>
							<input type="password" value="" name="loginPassword"
								id="loginPassword" style="width: 150px" />
						</td>
						<td>
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td>
							再次输入新密码：
						</td>
						<td>
							<input type="password" value="" name="aginLoginPassword"
								id="aginLoginPassword" style="width: 150px" />
						</td>
						<td>
							<font color="red">*</font>
						</td>
					</tr>
					<tr align="center">
						<td colspan="3">
							<input type="submit" value="修改" style="font-size: 15px"
								onclick="return adminSubmit2();">
							&nbsp;
							<input type="reset" value="重置" style="font-size: 15px">
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</body>
</html>
