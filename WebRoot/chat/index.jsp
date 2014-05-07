<%@ page language="java" pageEncoding="GB2312" contentType="text/html; charset=GB2312"%>
<html>
	<head>
		<script type="text/javascript">
			function openlogin(){
				window.open("login.jsp","","width=600px,height=460px");
				window.opener=null;
				this.close();
			}
		</script>
	</head>
	<body onload="openlogin()">
	</body>
</html>
