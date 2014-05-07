<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	cursor: pointer;
}
</style>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/AdminDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SecurityDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/CertificateDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript">
			window.onload=function(){
			/**
				CertificateDwr.query(function(certificates){
					dwr.util.removeAllOptions("certificates");
					dwr.util.addOptions("certificates",certificates, "id", "description");
				});
				SecurityDwr.query(function(securities){
					dwr.util.removeAllOptions("securities");
					dwr.util.addOptions("securities",securities, "id", "description");
				});
				**/
				$("loginName").onchange=function(){
					var loginName=$("loginName").value;
					AdminDwr.query(loginName,function(bool){
						if(bool==true){
							alert("该管理员已存在");
							$("loginName").value="";
						}
					});
				};
				$("adminSubmit").onclick=function(){
					var loginName=$("loginName").value;
					if(loginName==null||loginName==""){
						alert("用户名不能为空");
						$("loginName").focus();
						return false;
					}
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
					var telephone=$("telephone").value;
					if(telephone==null||telephone==""){
						alert("联系电话不能为空");
						$("telephone").value="";
						$("telephone").focus();
						return false;
					}
					var address=$("address").value;
					if(address==null||address==""){
						alert("联系地址不能为空");
						$("address").value="";
						$("address").focus();
						return false;
					}
					var menuId=document.getElementsByName("menuId");
					if(menuId.length<1){
						alert("请选择管理员的权限");
						return false;
					}
				}
			}
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/addAdmin.do">
			<table align="center">
				<tr align="center">
					<td colspan="3">
						<h4>
							添加管理员
						</h4>
					</td>
				</tr>
				<tr>
					<td width="100px">
						管理用户名：
					</td>
					<td width="100px">
						<input type="text" value="" name="loginName" id="loginName" />
					</td>
					<td width="30px">
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" value="" name="loginPassword"
							id="loginPassword" />
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
						<input type="password" value="" name="aginLoginPassword"
							id="aginLoginPassword" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<!-- 
				<tr>
					<td>
						证件类型：
					</td>
					<td>
						<select name="certificate" id="certificates" style="width: 155px;">
						</select>
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				-->
				<tr>
					<td>
						证件类型：
					</td>
					<td>
						<select name="certificate" id="certificates" style="width: 155px;">
							<c:forEach var="certificate" items="${certificates }">
								<option value="${certificate.id }">
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
						<input type="text" value="" name="certificateNumber"
							id="certificateNumber" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<!-- 
				<tr>
					<td>
						密保问题：
					</td>
					<td>
						<select name="security" id="securities" style="width: 155px;">
						</select>
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				-->
				<tr>
							<td>
								密保问题：
							</td>
							<td>
								<select name="security" id="securities" style="width: 150px;">
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
							id="securityAnswer" />
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
						<input type="text" value="" name="email" id="email" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						联系电话：
					</td>
					<td>
						<input type="text" value="" name="telephone" id="telephone" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td>
						联系地址：
					</td>
					<td>
						<input type="text" value="" name="address" id="address" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
			</table>
			<table width="38%" align="center">
				<tr>
					<td width="100px">
						权限：
					</td>
					<td>
						<c:forEach var="menu" items="${menues }">
							<c:if test="${menu.key.id!=80 }">
								<input type="checkbox" name="menuId" value="${menu.key.id }"
									style="width: 15px" />${menu.key.menuName }</c:if>
						</c:forEach>
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr align="center">
					<td colspan="3">
						<input type="submit" value=" 注 册 " id="adminSubmit"
							style="width: 50px;">
						&nbsp;
						<input type="reset" value=" 重 置 " style="width: 50px;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
