<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			function jiaRuGroup(value){
				var loginName=$("#loginName").val();
				if(loginName==null||loginName==""){
					alert("加入小组前先登陆，谢谢！");
					return;
				}
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/user/jiaRuGroup.do",
					data:"id="+value,
					success:function(msg){
						alert(msg);
					}
				});
			}
			function checkUser(value){
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/checkUser.do",
					data:"interestGroupId="+value,
					success:function(msg){
						if(msg=="loginError"){
							alert("您还没有登陆！");
						}else if(msg=="loginedError"){
							alert("您已经进入该小组!");
						}else if(msg=="notJiaRuError"){
							alert("您没有加入该兴趣小组，请加入后再进入讨论！");
						}
						else{
							window.open("${pageContext.request.contextPath}/chat.do?interestGroupId="+value,"","width=600px,height=500px");
						}
					}
				});
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
					<a href="#div11">兴趣小组</a>
				</li>
			</ul>
			<div id="div11">
				<font color="red">*如要加入兴趣小组或进入讨论，请先登陆...</font>
				<table border="0" width='94%' cellspacing='0' cellpadding='0'>
					<c:forEach var="interestGroup" items="${interestGroups }">
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 200px'>
								<b>${interestGroup.groupName }</b>--创建人：${interestGroup.user.loginName
								}
							</td>
							<td align="right"
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 250px'>

								<a href="#" style="color: red"
									onclick="jiaRuGroup(${interestGroup.id });">加入小组</a>
								<a href="#" style="color: red"
									onclick="checkUser(${interestGroup.id  })">进入讨论</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;${interestGroup.groupNotice }
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<fmt:formatDate value="${interestGroup.groupDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</c:forEach>
				</table>
				<c:if test="${spage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${spage.totalPage}" step="1">
						<c:if test="${spage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${spage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryShares.do?spageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<input type="hidden" value="${user.loginName }" id="loginName"/>
	</body>
</html>
