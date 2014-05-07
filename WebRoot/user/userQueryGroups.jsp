<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<script type="text/javascript" src="js/page.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				jQuery.page("page",40); 
				$("#div1").tabs();	
			});
			function checkUser(value){
				$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/checkUser.do",
					data:"interestGroupId="+value,
					success:function(msg){
						if(msg=="loginError"){
							alert("您还没有登陆！");
						}
						if(msg=="loginedError"){
							alert("您已经进入该小组!");
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
					<a href="#page">我的兴趣小组</a>
				</li>
			</ul>
			<div id="page">
				<table border="0" width='99%' cellspacing='0' cellpadding='0'>
					<c:forEach var="interestGroup" items="${userInterestGroups }">

						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 200px'>
								<b>${interestGroup.groupName }</b>--创建人：${interestGroup.user.loginName
								}
							</td>
							<td align="right"
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 250px'>
								<c:if test="${interestGroup.user.id==user.id}">
									<a
										href="${pageContext.request.contextPath }/user/modifyGroup.do?id=${interestGroup.id }"
										style="color: red">修改信息</a>&nbsp;&nbsp;&nbsp;
								 </c:if>
								<a
									href="${pageContext.request.contextPath }/user/queryGroupUsers.do?id=${interestGroup.id }"
									style="color: red">查看成员</a>&nbsp;&nbsp;&nbsp;
								<a href="#" style="color: red"
									onclick="checkUser(${interestGroup.id})">进入讨论</a>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								&nbsp;&nbsp;&nbsp;&nbsp;${interestGroup.groupNotice }
								<c:if test="${interestGroup.user.id==user.id}">
								 (<a
										href="${pageContext.request.contextPath }/user/jieSanGroup.do?id=${interestGroup.id }"
										style="color: red">解散该组</a>)
								 </c:if>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<fmt:formatDate value="${interestGroup.groupDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td
							style='border-top: 1px dotted #C2CCE3; height: 30px; width: 350px'>
						</td>
						<td valign="bottom" width="120px" align="right"
							style='border-top: 1px dotted #C2CCE3; height: 30px'>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
