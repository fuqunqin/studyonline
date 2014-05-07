<%@ page language="java" pageEncoding="GB2312"
	contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>聊天室登录</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/css/styles.css">
		<script language="javascript">
			function showMess(mess){
				document.getElementById("mess").innerHTML="<font color='red'>"+mess+"</font>";
			}
			//检查用户名是否登录
			function checkUserIsExits(){
				var objName = document.myform.name;
				
				if(objName.value==""){
					objName.focus();
					showMess("请输入用户名!");
					return;
				}else{
					for(var i=0;i<objName.value.length;i++){
						var ch = objName.value.charAt(i);
						if(ch=='<' || ch =='>' || ch=='-' || ch=='/' || ch=='\\'){
							objName.focus();
							showMess("不能含有<,>,-等特殊字符！");
							return;
						}
					}
				}
				var url = "${pageContext.request.contextPath}/checkUser.do?user="+objName.value;
				sendRequest(url);
			}
			
			//定义XMLHttpRequest对象
			var xmlRequest;
			//创建对象
			function createXMLHttpRequest(){
				if(window.XMLHttpRequest) { //Mozilla 浏览器
					xmlRequest = new XMLHttpRequest();
				}else if (window.ActiveXObject) { // IE浏览器
					try {
						xmlRequest = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							xmlRequest = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {}
					}
				}
			}
			
			//发送请求函数
			function sendRequest(url){
				createXMLHttpRequest(); //创建对象
				url=encodeURI(url); 
				url=encodeURI(url); 
				xmlRequest.open("GET",url,true);
				xmlRequest.onreadystatechange = checkResponse; //响应的函数
				xmlRequest.send(null);
			}
			
			//响应的函数
			function checkResponse(){
				if(xmlRequest.readyState==4){
					if(xmlRequest.status ==200) {
						//信息已经成功返回
						showloginInfo();
					}else{
						showMess("您所请求的页面有异常！");
					}
				}
			}
			
			//显示函数
			function showloginInfo(){
				//取得 checkUser.jsp返回的XML文本  
				var message = xmlRequest.responseXML.getElementsByTagName("userinfo")[0].firstChild.nodeValue;
				showMess(message);
				//因为之前解析XML 一直出现错误 所以改用了XML文本  先显示 后取出来
				if(message=="可以使用"){
					showMess("<font color='blue'>可以使用该名称！</font>");
					document.getElementById("sub").disabled=false; //使按钮可用
				}
			}
		</script>
	</head>
	<body>
		<div id="mainDiv">
			<form action="${pageContext.request.contextPath}/doLogin.do"
				name="myform" method="post">
				<table align="left" width="300">
					<caption align="left">
						<font color="blue" size="6" face="隶书">o 兴趣小组聊天室 O</font>
					</caption>
					<tr>
						<td>
							用户名:
						</td>
						<td>
							<input type="text" class="normalTxt" name="name"
								onblur="checkUserIsExits()">
						</td>
					</tr>

					<tr>
						<td colspan="2">
							<input type="submit" id="sub" class="normalBtn" value="登  录"
								disabled="true">
							&nbsp;
							<input type="reset" class="normalBtn" value="重  置">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<label id="mess">
								&nbsp;
							</label>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<br>
							<br>
							<br>
							<a href="javascript:close()">退出</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
