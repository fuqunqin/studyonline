<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/usercss.css"
			rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/UserDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/CertificateDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SecurityDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				//$("#div1").tabs();
				CertificateDwr.query(function(certificates){
					//alert("弹窗"+certificates);
					dwr.util.removeAllOptions("certificates");
					dwr.util.addOptions("certificates",certificates);
				});
				SecurityDwr.query(function(securities){
					dwr.util.removeAllOptions("securities");
					dwr.util.addOptions("securities",securities);
				});
				
				$("#userSubmit").click(function(){
					var loginName=$("#loginName").val();
					if(loginName==null||loginName==""){
						alert("用户名不能为空");
						$("#loginName").focus();
						return false;
					}
					var loginPassword=$("#loginPassword").val();
					if(loginPassword==null||loginPassword==""){
						alert("密码不能为空");
						$("#loginPassword").focus();
						return false;
					}
					var aginLoginPassword=$("#aginLoginPassword").val();
					if(loginPassword!=aginLoginPassword){
						alert("两次输入密码不一致");
						$("#aginLoginPassword").val("");
						$("#aginLoginPassword").focus();
						return false;
					}
					var certificateNumber=$("#certificateNumber").val();
					if(certificateNumber==null||certificateNumber==""){
						alert("证件号码不能为空");
						$("#certificateNumber").focus();
						return false;
					}
					var securityAnswer=$("#securityAnswer").val();
					if(securityAnswer==null||securityAnswer==""){
						alert("密保问题不能为空");
						$("#securityAnswer").focus();
						return false;
					}
					var email=$("#email").val();
					if(email==null||email==""){
						alert("邮箱地址不能为空");
						$("#email").focus();
						return false;
					}
					var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
					var emailBool=reg.test(email);
					if(emailBool==false){
						alert("邮箱地址不合法");
						$("#email").focus();
						return false;
					}
				});
			});
			$("#loginName").change(function(){
					var loginName=$("#loginName").val();
					UserDwr.query(loginName,function(bool){
						if(bool==true){
							alert("该用户已存在");
							$("#loginName").val("");
							$("#loginName").focus();
						}
					});
				});
		</script>
	</head>
	<body>
		<table width="99%">
			<tr>
				<td>
					<table>
						<tr>
							<td height="5"></td>
						</tr>
					</table>
					<div id="div1" style="border-color: #0054AA; height: 1050px">
						<ul>
							<li>
								<a href="#div11">注册</a>
							</li>
						</ul>
						<div id="#div11">
							<form method="post"
								action="${pageContext.request.contextPath }/register.do">
								<table align="center">
									<tr align="center">
										<td colspan="3">
											<h4>
												添加新用户
											</h4>
										</td>
									</tr>
									<tr>
										<td width="100px">
											用户名：
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
									<tr>
										<td>
											证件类型：
										</td>
										<td>
											<select name="certificates" id="certificates"
												style="width: 155px;">
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
									<tr>
										<td>
											密保问题：
										</td>
										<td>
											<select name="securitys" id="securities" style="width: 155px;">
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
									<tr align="center">
										<td colspan="3">
											<input type="submit" value=" 注 册 " id="userSubmit"
												style="width: 50px;">
											&nbsp;
											<input type="reset" value=" 重 置 " style="width: 50px;">
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>
