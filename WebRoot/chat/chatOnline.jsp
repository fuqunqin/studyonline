<%@ page language="java" pageEncoding="GB2312"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>${chatIg.groupName }兴趣小组</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/datepicker/jquery_last.js"></script>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/css/styles.css">
		<style type="text/css">
#contentDiv {
	background-color: #dd9a22;
	font-size: 11px;
}

body {
	font-size: 11px;
	background-color: #eeeeee;
}

a {
	font-size: 12px;
	color: blue;
	text-decoration: none;
}

a:hover {
	font-size: 12px;
	color: green;
	text-decoration: underline;
}

#chatDiv {
	border: 1px solid #eeeeee;
	float: left;
	width: 470px;
	margin: 3px;
	color: blue;
	background-color: #eeeeee;
}

#userDiv {
	border: 0px solid black;
	float: left;
	width: 117px;
	height: 440px;
	margin-top: 3px;
	line-height: 18px;
	text-decoration: underline;
	padding-left: 5px;
}
</style>
	<script type="text/javascript">
		window.onunload=function(){
			doLayout();
		}
		$(document).ready(function(){
			 sendMessage2();
			 setAuto();
		});
		function sendMessage(){
			var message=$("#message").val();
			var interestGroupId=$("#interestGroupId").val();
			$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/doInput.do",
					data:"message="+message+"&interestGroupId="+interestGroupId,
					success:function(msg){
						//alert(unescape(msg));
						$("#message").val("");
						$("#chatMessages").val(msg);
					}
				});
		}
		function sendMessage2(){
			var interestGroupId=$("#interestGroupId").val();
			$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/doInput.do",
					data:"interestGroupId="+interestGroupId,
					success:function(msg){
						//alert(unescape(msg));
						//$("#message").val("");
						$("#chatMessages").val(msg);
					}
				});
			window.setTimeout('sendMessage2()',1000);
		}
		function doLayout(){
			var interestGroupId=$("#interestGroupId").val();
			$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/doLayout.do",
					data:"interestGroupId="+interestGroupId,
					success:function(msg){
						window.close();
					}
				});
		}
		var id ;
			function setAuto(){
				id = setInterval("document.getElementById('chatMessages').scrollTop=document.getElementById('chatMessages').scrollHeight",300);
			}
			function clearAuto(){
				clearInterval(id);
			}
	</script>
	</head>

	<body>
		<center>
		<div id="contentDiv" style="width: 600px;height: 500px">
			<div id="titleDiv" style="width: 470px;height: 20px;margin-top: 10px">
				<marquee direction="left" scrolldelay="200">
					${user.loginName }..欢迎来到${chatIg.groupName }兴趣小组聊天室..o(∩_∩)o..
				</marquee>
			</div>
			<div id="chatDiv" style="width: 470px">
				<div id="chatJsp" style="height: 350px; width: 470px;">
					<textarea rows="25" cols="64" readonly="readonly" id="chatMessages" >${messageList }</textarea>
				</div>
				<span id="divMess" style="width: 100px;"><b style="color: red;">请输入内容:</b></span>
				<div style="display: inline; text-align: right; width: 360px">
					<a href="javascript:setAuto()">自动滚动</a>&nbsp;
					<a href="javascript:clearAuto()">取消滚动</a> &nbsp;
					<a href="#" onclick="doLayout();">退出</a>
				</div>
				<div style="width: 470px">
					<textarea rows="3" cols="64" id="message"></textarea>
				</div>
				<div style="padding-right: 0px; width: 450px" align="right">
					<input name="button" type="button" class="longBtn"
						onClick="sendMessage();" value="确定">
				</div>
			</div>
			<div id="userDiv" style="height: 110px;">
			<textarea rows="31" cols="12" readonly="readonly"><c:forEach var="u" items="${chatIg.users}">${u.loginName}&#13;</c:forEach></textarea>
			</div>
		</div>
		</center>
		<input type="hidden" value="${chatIg.id }" id="interestGroupId"/>
	</body>
</html>
