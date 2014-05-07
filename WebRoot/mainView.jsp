<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>在线学习网络平台</title>
		<style type="text/css">
a {
	text-transform: none;
	text-decoration: none;
	color: #000;
}

a:hover {
	color: #666666;
	text-decoration: none;
}

table {
	font-size: 9pt;
	font-family: 宋体;
	border-collapse: collapse;
}

/*右边标题框架↓*/
.righttopleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopleft.gif');
	width: 6px;
	height: 30px;
}

.righttopcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	height: 30px;
	color: #FFF
}

.righttopcenter A:link {
	color: #FFFFFF
}

.righttopcenter A:visited {
	TEXT-DECORATION: none;
	color: #FFFFFF;
}

.righttopright {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopright.gif')
		;
	width: 6px;
	height: 30px;
}

/*右边内容框架↓*/
.rightcenterleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px;
}

/*右边底部框架↓*/
.rightfootleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/footleft.gif');
	width: 4px;
	height: 4px;
}

.rightfootcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	width: 580px;
	height: 4px;
}

/*“更多……”设置*/
.othernav {
	color: #fff
}
</style>
	</head>
	<body topmargin='0' leftmargin='0'>
		<jsp:include page="/main/subject.jsp"></jsp:include>
		<jsp:include page="/main/pubmedTribe.jsp"></jsp:include>
		<jsp:include page="/main/qualification.jsp"></jsp:include>
		<jsp:include page="/main/englishStudy.jsp"></jsp:include>
		<jsp:include page="/main/interestGroup.jsp"></jsp:include>
	</body>
</html>
