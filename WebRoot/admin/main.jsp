<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>在线学习网络平台管理系统</title>
	</head>
	<frameset rows="98,*,8" frameborder="no" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath }/admin/top.jsp"
			name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
		<frame src="${pageContext.request.contextPath }/admin/center.jsp"
			name="mainFrame" id="mainFrame" />
		<frame src="${pageContext.request.contextPath }/admin/down.jsp"
			name="bottomFrame" scrolling="no" noresize="noresize"
			id="bottomFrame" />
	</frameset>
	<noframes>
		<body>
		</body>
	</noframes>
	<noscript>
			<iframe src="*.jsp"></iframe>
			<iframe src="*.do"></iframe>
		</noscript>
</html>
