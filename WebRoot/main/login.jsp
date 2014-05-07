<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			function refreshImg(){
	    		document.getElementById("changeImg").src="${pageContext.request.contextPath }/validateImage?id="+new Date();
	    	}
	    	function logoutSelf(){
	    		if(confirm("确定注销吗？\n注销后您将不能再使用您的账号，如想继续使用需与管理员联系，请慎用！")){
	    			return true;
	    		}else return false;
	    	}
		</script>
	</head>
	<body>
		<c:if test="${user==null}">
			<table>
				<tr>
					<td width="10" height=5></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td class="lefttopcenter">
						&emsp;
						<img border="0"
							src='${pageContext.request.contextPath }/mainimages/mor.gif'
							align="absmiddle" />
						&nbsp;会员登陆
					</td>
					<td class="lefttopright"></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td valign='top' class='leftcentercenter'>
						<div>
							<form method="post"
								action="${pageContext.request.contextPath }/userLogin.do">
								<table>
									<tr>
										<td height="5" colspan="3">
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td height="5" colspan="3">
										</td>
									</tr>
								</table>
								<table align="center" width="80%">
									<tr>
										<td height="25">
											用户名:
										</td>
										<td colspan="2">
											<input name="loginName" type='text' style="width: 100px"
												maxlength='20' class="web58818" />
										</td>

									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr height="25">
										<td>
											密&nbsp;&nbsp;码：
										</td>
										<td colspan="2">
											<input name="loginPassword" type='password'
												style="width: 100px" maxlength='20' class="web58818" />
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr height="25">
										<td>
											验证码：
										</td>
										<td>
											<input name="validateImg" type="text" size="4" maxlength="4"
												class="web58818" />
										</td>
										<td>
											<img src="${pageContext.request.contextPath }/validateImage"
												border="0" onclick="refreshImg();" id="changeImg" />
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr>
										<td colspan="3" height="25">
											<input name='submit' type='submit' value="登 录"
												style="width: 60px; height: 20px; cursor: pointer; border: 1px solid #666666;" />
											<input name='reg' type='button' value='注 册'
												onclick="window.location.href='${pageContext.request.contextPath }/main/register.jsp'"
												style="width: 60px; height: 20px; cursor: pointer; border: 1px solid #666666;" />
										</td>
									</tr>
								</table>
							</form>
							<center>
								<table width="99%">
									<tr>
										<td>
											<c:if test="${loginWrong==null}">
												<font color="red">&nbsp;&nbsp;&nbsp;&nbsp;</font>
											</c:if>
											<c:if test="${loginWrong!=null}">
												<font color="red">${loginWrong }</font>
											</c:if>
										</td>
										<td align="right">
											
										</td>
									</tr>
								</table>
							</center>
						</div>
					</td>
					<td class="leftcenterright"></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td class='leftfootcenter'></td>
					<td class='leftfootright'></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${user!=null}">
			<table>
				<tr>
					<td width="10" height=5></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td class="lefttopcenter">
						&emsp;
						<img border="0"
							src='${pageContext.request.contextPath }/mainimages/mor.gif'
							align="absmiddle" />
						&nbsp;${user.loginName }登录成功
					</td>
					<td class="lefttopright"></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td valign='top' class='leftcentercenter'>
						<div>
							<form method="post" action="">
								<table>
									<tr>
										<td height="18" colspan="2">
										</td>
									</tr>
								</table>

								<table align="center" width="80%">
									<tr height="25" align="center">
										<td width="50%">
											<a
												href="${pageContext.request.contextPath }/user/selfMessage.jsp">个人资料</a>
										</td>
										<td>
											<a
												href="${pageContext.request.contextPath }/user/userMessages.jsp">系统消息<font
												color="red">(${fn:length(userMessages) })</font> </a>
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr height="25" align="center">
										<td>
											<a
												href="${pageContext.request.contextPath }/user/queryUserShares.do">我的共享</a>
										</td>
										<td>
											<a
												href="${pageContext.request.contextPath }/user/addUserShares.jsp">
												添加共享</a>
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr height="25" align="center">
										<td>
											<a
												href="${pageContext.request.contextPath }/user/queryInterestGroups.do">我的小组
											</a>
										</td>
										<td>
											<a
												href="${pageContext.request.contextPath }/user/addInterestGroup.jsp">
												创建小组</a>
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
									<tr height="25" align="center">
										<td>
											<a onclick="return logoutSelf();"
												href="${pageContext.request.contextPath }/user/logout.do">注销</a>
										</td>
										<td>
											<a href="${pageContext.request.contextPath }/user/exit.do">退出</a>
										</td>
									</tr>
									<tr>
										<td height="5" colspan="3"></td>
									</tr>
								</table>
							</form>
						</div>
					</td>
					<td class="leftcenterright"></td>
				</tr>
			</table>
			<table border='0' cellspacing='0' cellpadding='0'>
				<tr>
					<td class='leftfootcenter'></td>
					<td class='leftfootright'></td>
				</tr>
			</table>
		</c:if>
	</body>
</html>
