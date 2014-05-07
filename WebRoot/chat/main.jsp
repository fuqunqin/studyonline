<%@ page language="java" pageEncoding="GB2312"%>
<html>
	<head>
		<title>XX兴趣小组聊天室</title>
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
		<script language="javascript">
			window.onunload = closeWindow;
			
			function closeWindow(){
					clearUser();
			}
			
			function clearUser(){
				var url = "${pageContext.request.contextPath}/doLayout.do";
				xmlRequest = createXMLHttpRequest(); //创建对象
				//状态改变
				xmlRequest.onreadystatechange = clearStatus;
				xmlRequest.open("GET",url,true);
				xmlRequest.send(null);  // 发送请求
				window.close();
			}
			
			//回调函数
			function clearStatus(){
				if(xmlRequest.readyState==4){
					if(xmlRequest.status ==200) {
						//alert("退出成功！");
					}else{
						alert(xmlRequest.status);
					}
				}
			}
		
			//定义XMLHttpRequest对象
			var xmlRequest;
			
			//创建对象
			function createXMLHttpRequest(){
				if(window.XMLHttpRequest) { //Mozilla 浏览器
					return new XMLHttpRequest();
				}else if (window.ActiveXObject) { // IE浏览器
					try {
						return new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							return new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {}
					}
				}
			}
			
			//显示消息
			function showMess(value,color){
				document.getElementById("divMess").innerHTML="<font color='"+color+"'>"+value+"</font>";
			}
			
			
			//发送聊天信息
			function sendMessage(){
				var objMessage = document.getElementById("message");
				if(objMessage.value==""){
					showMess("内容不能为空！","red");
					objMessage.focus();
					return;
				}
				
				for(var i=0;i<objMessage.value.length;i++){
						var ch = objMessage.value.charAt(i);
						if(ch=='<' || ch =='>' || ch=='-' || ch=='/' || ch=='\\'){
							objMessage.focus();
							showMess("不能含有<,>,-等特殊字符！","red");
							return;
						}
				}
				
				if(objMessage.value.length>100){
					showMess("100字以内！","red");
					objMessage.focus();
					return;
				}
				//请求到 doinput 参数是输入的内容
				var url = "${pageContext.request.contextPath}/doInput.do?message="+objMessage.value;
				document.getElementById("message").value="";
				sendRequest(url);
				
			}
			//发送请求函数
			function sendRequest(url){
				xmlRequest = createXMLHttpRequest(); //创建对象
				url=encodeURI(url); 
				url=encodeURI(url); 
				//状态改变
				xmlRequest.onreadystatechange = dataChanged;
				xmlRequest.open("POST",url,true);
				xmlRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
				xmlRequest.send(url);  // 发送请求
			}
			
			//响应的函数
			function dataChanged(){
				if(xmlRequest.readyState==4){
					if(xmlRequest.status ==200) {
						//信息已经成功返回
						showChatMessage();
					}else{
						showMess("您所请求的页面有异常！");
					}
				}
			}
			
			function showChatMessage(){
				var message = xmlRequest.responseXML.getElementsByTagName("message")[0].firstChild.nodeValue;
				document.frames("chat").document.body.innerText = message;
			}
			
			//每隔三秒钟查询一次
			window.setInterval("sendRequest('${pageContext.request.contextPath}/doInput.do')",300);
			var id ;
			function setAuto(){
				id = setInterval("document.frames('chat').document.body.scrollTop=document.frames('chat').document.body.scrollHeight",300);
			}
			function clearAuto(){
				clearInterval(id);
			}
		</script>

	</head>
	<body
		onload="sendRequest('${pageContext.request.contextPath}/doInput.do');setAuto();window.status='提示:合理上网，注意用眼过度!'">
		<div id="contentDiv">
			<div id="titleDiv">
				<marquee direction="left" scrolldelay="200">${sessionuser }..欢迎来到XXX兴趣小组聊天室..o(∩_∩)o..
				</marquee>
			</div>
			<div id="chatDiv">
				<iframe src="chat.jsp" name="chat" frameborder="1" scrolling="auto"
					height="350px" width="470px">
				</iframe>
				<span id="divMess" style="width: 240px;">请输入内容(100字以内)! </span>
				<div style="display: inline; text-align: right; width: 200px">
					<a href="javascript:setAuto()">自动滚动</a>&nbsp;
					<a href="javascript:clearAuto()">取消滚动</a> &nbsp;
					<a href="${pageContext.request.contextPath}/doLayout.do">退出</a>
				</div>
				<div>
					<textarea rows="3" cols="56" id="message"></textarea>
				</div>
				<div style="text-align: right; padding-right: 0px;">
					<input type="button" value="确定" class="longBtn"
						onclick="sendMessage()">
				</div>
			</div>
			<div id="userDiv">
				<iframe src="user.jsp" name="userframe" frameborder="1"
					scrolling="auto" height="440px" width="110px">
				</iframe>
			</div>
		</div>
	</body>
</html>