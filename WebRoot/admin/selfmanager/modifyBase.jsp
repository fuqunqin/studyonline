<%@ page language="java" pageEncoding="UTF-8"%>
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
					var certificateNumber=$("certificateNumber").value;
					if(certificateNumber==null||certificateNumber==""){
						alert("证件号码不能为空");
						$("certificateNumber").value="";
						$("certificateNumber").focus();
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
				}
			}
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifySelfBase.do">
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
						${admin.loginName }
					</td>
					<td width="30px">
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
									<c:if test="${certificate.id==admin.certificate.id }">selected="selected"</c:if>>
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
						<input type="text" value="${admin.certificateNumber }"
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
						<input type="text" value="${admin.email }" name="email" id="email" />
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
						<input type="text" value="${admin.telephone }" name="telephone"
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
						<input type="text" value="${admin.address }" name="address"
							id="address" />
					</td>
					<td>
						<font color="red">*</font>
					</td>
				</tr>
			</table>
			<table width="38%" align="center">
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
