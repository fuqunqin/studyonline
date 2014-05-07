<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			function adminSubmit(){
				var firstLoginPassword=document.getElementById("firstLoginPassword").value;
				if(firstLoginPassword==null||firstLoginPassword==""){
					alert("请输入原密码");
					document.getElementById("firstLoginPassword").focus();
					return false;
				}
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
			function adminSubmit2(){
				var firstLoginPassword=document.getElementById("firstLoginPassword2").value;
				if(firstLoginPassword==null||firstLoginPassword==""){
					alert("请输入原密码");
					document.getElementById("firstLoginPassword2").focus();
					return false;
				}
				var securityAnswer=document.getElementById("securityAnswer").value;
				if(securityAnswer==null||securityAnswer==""){
					alert("密保答案不能为空");
					document.getElementById("securityAnswer").focus();
					return false;
				}
			}	
		</script>
		<style type="text/css">
body {
	font: 62.5% "Trebuchet MS", sans-serif;
}
</style>
	</head>
	<body>
		<div id="div1">
			<ul>
				<li>
					<a href="#div11">修改密码</a>
				</li>
				<li>
					<a href="#div22">修改密保</a>
				</li>
			</ul>
			<div id="div11">
				<form method="post"
					action="${pageContext.request.contextPath }/admin/modifySelfSafe.do?flag=1">
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
								原密码：
							</td>
							<td>
								<input type="password" value="" name="firstLoginPassword"
									id="firstLoginPassword" style="width: 150px" />
							</td>
							<td>
								<font color="red">*</font>
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
									onclick="return adminSubmit();">
								&nbsp;
								<input type="reset" value="重置" style="font-size: 15px">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div id="div22">
				<form method="post"
					action="${pageContext.request.contextPath }/admin/modifySelfSafe.do?flag=2">
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
								输入密码：
							</td>
							<td>
								<input type="password" value="" name="firstLoginPassword"
									id="firstLoginPassword2" style="width: 150px" />
							</td>
							<td>
								<font color="red">*</font>
							</td>
						</tr>
						<tr>
							<td>
								密保问题：
							</td>
							<td>
								<select name="security" style="width: 150px;">
									<c:forEach var="security" items="${securities }">
										<option value="${security.id }">
											${security.description }
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
								密保答案:
							</td>
							<td>
								<input type="text" value="" name="securityAnswer"
									id="securityAnswer" style="width: 150px"/>
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
			</div>
		</div>
	</body>
</html>
