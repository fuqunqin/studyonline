<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线学习网络平台管理系统</title>
    <style type="text/css">
    	.adminLogin{
    		cursor: pointer;
			border: none;
			width: 49px;
			height: 18px;
    		background-image: url("${pageContext.request.contextPath }/images/dl.gif");
    	}
    	.adminReset{
    		cursor: pointer;
			border: none;
			width: 49px;
			height: 18px;
    		background-image: url("${pageContext.request.contextPath }/images/d2.gif");
    	}
    </style>
    <script type="text/javascript">
    	function refreshImg(){
    		document.getElementById("changeImg").src="${pageContext.request.contextPath }/validateImage?id="+new Date();
    	}
    	function validateAdmin(){
    		var loginName=document.getElementById("loginName").value;
    		if(loginName==null||loginName==""){
    			alert("用户名不能为空！");
    			document.getElementById("loginName").focus();
    			return false;
    		}
    		var loginPassword=document.getElementById("loginPassword").value;
    		if(loginPassword==null||loginPassword==""){
    			alert("密码不能为空！");
    			document.getElementById("loginPassword").focus();
    			return false;
    		}
    		var validateImg=document.getElementById("validateImg").value;
    		if(validateImg==null||validateImg==""){
    			alert("验证码不能为空！");
    			document.getElementById("validateImg").focus();
    			return false;
    		}
    	}
    </script>
  </head>
  <body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="${pageContext.request.contextPath }/adminLogin.do" method="post">
<table id="__01" width="1003" height="613" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">
			<img src="${pageContext.request.contextPath }/images/login_01.gif" width="1003" height="53" alt=""></td>
	</tr>
	<tr>
		<td rowspan="6">
			<img src="${pageContext.request.contextPath }/images/login_02.gif" width="20" height="560" alt=""></td>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/login_03.gif" width="962" height="136" alt=""></td>
		<td rowspan="6">
			<img src="${pageContext.request.contextPath }/images/login_04.gif" width="21" height="560" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/login_05.gif" width="962" height="25" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/login_06.gif" width="962" height="53" alt=""></td>
	</tr>
	<tr>
		<td>
			<img src="${pageContext.request.contextPath }/images/login_07.gif" width="394" height="129" alt=""></td>
		<td background="${pageContext.request.contextPath }/images/login_08.gif" width="244" height="129" valign="bottom"><table>
		<tr><td colspan="3"><font color="FFFF" size="2">${loginWrong }<html:errors /><a href="${pageContext.request.contextPath }/admin/findpassword/findPassword.jsp" style="color: red;">忘记密码?</a></font></td></tr>
		<tr><td>用户名:</td><td colspan="2"><input id="loginName" type="text" name="loginName" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"></td></tr>
		<tr><td>密码:</td><td colspan="2"><input id="loginPassword" type="password" name="loginPassword" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff"></td></tr>
		<tr><td>验证码:</td><td><input id="validateImg" type="text" name="validateImg" style="width:50px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff" maxlength="4"></td><td><img src="${pageContext.request.contextPath }/validateImage" onclick="refreshImg();" id="changeImg"/></td></tr>
		<tr height="35"><td colspan="3" align="center"><input type="submit" value="" class="adminLogin" onclick="return validateAdmin();"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="resetAdmin();"><input type="reset" value="" class="adminReset"/></a></td></tr></table></td>
		<td>
			<img src="${pageContext.request.contextPath }/images/login_09.gif" width="324" height="129" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/login_10.gif" width="962" height="158" alt=""></td>
	</tr>
	<tr>
		<td colspan="3">
			<img src="${pageContext.request.contextPath }/images/login_11.gif" width="962" height="59" alt=""></td>
	</tr>
</table>
</form>
  </body>
</html>
