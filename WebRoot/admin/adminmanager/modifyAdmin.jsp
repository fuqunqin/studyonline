<%@ page language="java" pageEncoding="UTF-8"
	import="cn.edu.zust.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
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
			action="${pageContext.request.contextPath }/admin/modifyAdmin.do">
			<table align="center">
				<tr align="center">
					<td colspan="3">
						<h4>
							修改管理员
						</h4>
					</td>
				</tr>
				<tr>
					<td width="100px">
						管理用户名：
					</td>
					<td width="100px">
						${a.loginName }
					</td>
					<td width="30px">
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="password" value="${a.loginPassword }"
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
						<input type="password" value="${a.loginPassword }"
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
						<select name="certificate" style="width: 155px;">
							<c:forEach var="certificate" items="${certificates }">
								<option value="${certificate.id }"
									<c:if test="${certificate.id==a.certificate.id }">selected="selected"</c:if>>
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
						<input type="text" value="${a.certificateNumber }"
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
						<input type="text" value="${a.email }" name="email" id="email" />
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
						<input type="text" value="${a.telephone }" name="telephone"
							id="telephone" />
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
						<input type="text" value="${a.address }" name="address"
							id="address" />
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
						<c:forEach var="menu" items="${a.menues }">
							<input type="checkbox" name="menuId" value="${menu.id }"
								style="width: 15px" checked="checked" />${menu.menuName }
						</c:forEach>
						<c:forEach var="m" items="${ms }">
							<c:if test="${m.id!=80 }">
								<input type="checkbox" name="menuId" value="${m.id }"
									style="width: 15px" />${m.menuName }</c:if>
						</c:forEach>
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
				<tr align="center">
					<td colspan="3">
						<input type="submit" value=" 修 改 " id="adminSubmit"
							style="width: 50px;">
						&nbsp;
						<input type="reset" value=" 重 置 " style="width: 50px;">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
