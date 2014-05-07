<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			var i=5;
			function returnHistory(){
				document.getElementById('curDate').innerHTML=i--+'秒后返回操作...';
				if(i<0){
					window.location.href="${pageContext.request.contextPath}/admin/selfmanager/modifySafe.jsp";
				}else{
					window.setTimeout('returnHistory()',1000);
				} 
			}
		</script>
	</head>

	<body topmargin="50px" onload="returnHistory();">
		<center>
			您输入的原密码有误!
			<br />
			<div id="curDate"></div>
		</center>
	</body>
</html>
