<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
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

INPUT {
	BORDER-TOP-WIDTH: 1px;
	BORDER-LEFT-WIDTH: 1px;
	FONT-SIZE: 12px;
	BORDER-BOTTOM-WIDTH: 1px;
	BORDER-RIGHT-WIDTH: 1px;
}

FORM {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px
}

/*主体宽度设置↓*/
.width {
	width: 760;
}

/*顶部的开关是否设置display:none则不显示↓*/
.topshow {
	display: none
}

/*顶部的空行是否开关设置display:none则不显示↓*/
.topspace {
	height: 5px;
	display: none
}

/*底部的空行是否开关设置display:none则不显示↓*/
.footspace {
	height: 20px;
	background:
		url('${pageContext.request.contextPath}/mainimages/footbg.jpg');
	display: none
}

/*底部版权设置*/
.foot {
	width: 760;
	background: #C2CCE3
}

/*顶部BARNER图片设置↓*/
.webtop {
	background: url('${pageContext.request.contextPath}/mainimages/top.jpg')
		;
	height: 92px;
	width: 760px;
}

/*顶部的按扭开关设置↓*/
.off {
	background: url('${pageContext.request.contextPath}/mainimages/off.gif')
		;
}

.on {
	background: url('${pageContext.request.contextPath}/mainimages/on.gif');
}

.close {
	background:
		url('${pageContext.request.contextPath}/mainimages/close.gif');
}

.overoff {
	background:
		url('${pageContext.request.contextPath}/mainimages/overoff.gif');
}

.overon {
	background:
		url('${pageContext.request.contextPath}/mainimages/overon.gif');
}

.overclose {
	background:
		url('${pageContext.request.contextPath}/mainimages/overclose.gif');
}

/*菜单设置↓*/
.topmenucss {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
}

.footmenucss {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
}

/*顶部导航设置*/
.menufont {
	color: #FFF;
}

a.menufont:link {
	COLOR: #FFF;
	TEXT-DECORATION: none;
}

a.menufont:visited {
	COLOR: #FFF;
	TEXT-DECORATION: none;
}

a.menufont:hover {
	COLOR: #FFFF00;
	TEXT-DECORATION: none;
}

.menu {
	font-size: 9pt;
	font-family: 宋体;
	color: 666666;
}

.overmenu {
	background: #C2CCE3;
	border: #00ccff solid 1px;
	font-size: 9pt;
	color: 000;
	cursor: hand;
}

/*上边标题框架↓*/
.topleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/top_left.gif');
	height: 20px;
	width: 6px
}

.topcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/top_center.gif');
	width: 756px;
}

.topright {
	background:
		url('${pageContext.request.contextPath}/mainimages/top_right.gif');
	height: 20px;
	width: 6px
}

/*下边标题框架↓*/
.footleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/footleft.gif');
	height: 4px;
	width: 4px
}

.footcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 760px;
}

.footright {
	background:
		url('${pageContext.request.contextPath}/mainimages/footright.gif');
	height: 4px;
	width: 4px
}

/*左右边框架↓*/
.left {
	background:
		url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px
}

.right {
	background:
		url('${pageContext.request.contextPath}/mainimages/right.gif');
	width: 4px
}

/*左边标题框架↓*/
.lefttopleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	width: 182px;
	height: 30px;
}

.lefttopcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	width: 182px;
	height: 30px;
	color: #FFF
}

.lefttopright {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopright.gif')
		;
	width: 6px;
	height: 30px;
}

/*左边内容框架↓*/
.leftcenterleft {
	background: #C2CCE3;
	width: 184px;
}

.leftcentercenter {
	background: #C2CCE3;
	width: 184px;
}

.leftcenterright {
	background:
		url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px;
}

/*左边底部框架↓*/
.leftfootleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 184px
}

.leftfootcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 184px
}

.leftfootright {
	background:
		url('${pageContext.request.contextPath}/mainimages/footright.gif');
	width: 4px;
	height: 4px;
}

.bookreply {
	FILTER: Glow(color =       '#0000f0', Strength =       '2');
	COLOR: #C2CCE3;
	HEIGHT: 0px;
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
	width: 560px;
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

.rightcentercenter {
	background: #ffffff;
	width: 562px;
}

.rightcenterright {
	background:
		url('${pageContext.request.contextPath}/mainimages/right.gif');
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
	width: 562px;
	height: 4px;
}

.rightfootright {
	background:
		url('${pageContext.request.contextPath}/mainimages/footright.gif');
	width: 4px;
	height: 4px;
}

/*点击|推荐|相关-开始*/
.showtopleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/topleft.gif');
	width: 6px;
	height: 28px;
}

.showtopcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	width: 364px;
	height: 28px;
}

.showtopright {
	background:
		url('${pageContext.request.contextPath}/mainimages/topright.gif');
	width: 6px;
	height: 28px;
}

.showcenterleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px;
}

.showcentercenter {
	background: #ffffff;
	width: 366px;
}

.showcenterright {
	background:
		url('${pageContext.request.contextPath}/mainimages/right.gif');
	width: 4px;
}

.showfootleft {
	background:
		url('${pageContext.request.contextPath}/mainimages/footleft.gif');
	width: 4px;
	height: 4px;
}

.showfootcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 366px
}

.showfootright {
	background:
		url('${pageContext.request.contextPath}/mainimages/footright.gif');
	width: 4px;
	height: 4px;
}

/*查看频道框架↓*/
.showtop {
	color: #FFFFFF;
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	border-bottom: 1px solid #666666;
	width: 100%;
	height: 28px;
}

.showcenter {
	background: #ffffff;
	width: 100%;
	height: auto;
}

.showfoot {
	background:
		url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	width: 100%;
	height: 4px;
}

/*各栏目的表格背景变换↓*/
.trover {
	background: #ffffff;
}

.tr {
	background: #ffffff;
}

.bg {
	background: #ffffff;
}

/*大表格的背景选项↓*/
.bgcolor {
	background: #dddddd;
}

/*鼠标移动到计数器的时候↓*/
.tongji {
	
}

.gopic {
	overflow: hidden;
	width: 558;
}

.yecao {
	border: solid 1px #666666;
	color: #666666;
	font-size: 12px;;
	background: ffffff;
}

/*表格调整↓*/
.yecao {
	color: #666666;
	font-family: Arial, Hevlvetica, sans-serif;
	font-size: 12px;
	border: 1px solid #666666;
	width: auto;
	background: url('${pageContext.request.contextPath}/mainimages/gs.gif');
	height: 20px;
	margin: 0px;
	cursor: pointer;
}

/*按钮设置↓*/
.put {
	filter: progid :       dximagetransform .       microsoft .   
		
		
		 gradient(gradienttype =       0, startcolorstr =       #ffffff,
		endcolorstr =   
		   #E2EF93);
	border: 1px solid #666666;
	font-size: 9pt;
	width: 75px;
	cursor: hand;
	padding-top: 2px;
	height: 20px;
}

.overput {
	filter: progid :       dximagetransform .       microsoft .   
		
		
		 gradient(gradienttype =       0, startcolorstr =       #ffffff,
		endcolorstr =   
		   #9ACBEE);
	border: 1px solid #666666;
	font-size: 9pt;
	width: 75px;
	cursor: hand;
	padding-top: 2px;
	height: 20px;
}

.menutxt {
	COLOR: #425264
}

.menutxt A {
	COLOR: #425264
}

.menutxt A:hover {
	COLOR: #5f7690
}

/*主下拉菜单*/
.mtDropdownMenu {
	LEFT: -1000px;
	OVERFLOW: hidden;
	POSITION: absolute;
	TOP: -1000px;
	margin-top: 4px;
}

.mtDropdownMenu .content {
	POSITION: absolute
}

.mtDropdownMenu .items {
	BORDER-RIGHT: #999 1px solid;
	BORDER-TOP: #999 1px solid;
	Z-INDEX: 2;
	LEFT: 0px;
	BORDER-LEFT: #999 1px solid;
	BORDER-BOTTOM: #999 1px solid;
	POSITION: relative;
	TOP: 0px
}

.top .items {
	color: #FFFFFF;
}

.mtDropdownMenu .item {
	BORDER-RIGHT: medium none;
	BORDER-TOP: medium none;
	FONT-SIZE: 12px;
	BORDER-LEFT: medium none;
	CURSOR: hand;
	COLOR: #4a4b4b;
	BORDER-BOTTOM: medium none;
	TEXT-DECORATION: none
}

.mtDropdownMenu .background {
	Z-INDEX: 1;
	FILTER: alpha(opacity =       85);
	LEFT: 0px;
	POSITION: absolute;
	TOP: 0px;
	moz-opacity: .8
}

.mtDropdownMenu .shadowRight {
	Z-INDEX: 3;
	FILTER: alpha(opacity =       40);
	WIDTH: 2px;
	POSITION: absolute;
	TOP: 3px;
	moz-opacity: .4
}

.mtDropdownMenu .shadowBottom {
	Z-INDEX: 1;
	FILTER: alpha(opacity =       40);
	LEFT: 3px;
	POSITION: absolute;
	HEIGHT: 2px;
	moz-opacity: .4
}

.mtDropdownMenu .hover {
	BACKGROUND: #FFFFFF;
	COLOR: #FF9900
}

.mtDropdownMenu .item IMG {
	MARGIN-LEFT: 12px
}

}
/*其他下拉菜单,勿改*/
.menuskin {
	border: #969696 1px solid;
	background: url(g.gif) #efefef;
	visibility: hidden;
	position: absolute;
	padding: 4px;
}

.menuskin a {
	text-transform: none;
	text-decoration: none;
	color: #000;
}

.menuskin a:hover {
	text-transform: none;
	text-decoration: none;
	color: #000;
}

.menuitems {
	width: 80px;
	padding: 5px;
	margin: 0px;
	text-align: center;
}

#mouseoverstyle {
	width: 80px;
	padding: 4px;
	margin: 0px;
	text-align: center;
	border: #000 1px solid;
	BACKGROUND-COLOR: #ffffff;
}

#lrcollbox td,#lrcollbox font {
	font-family: 黑体;
	font-size: 12px;
}

#lrcoll td {
	color: #ffffff;
	cursor: default;
}

#lrcbox {
	color: #ffffff
}

#lrcbc {
	color: #FFFF33
}

A:visited {
	TEXT-DECORATION: none;
	color: #000000;
}

A:active {
	COLOR: #000000;
	TEXT-DECORATION: none;
}

A:link {
	TEXT-DECORATION: none;
	Color: #000000
}

#idDownload {
	behavior: url(#default#download);
}

A:hover {
	TEXT-DECORATION: underline;
	Color: #666
}

#lrcfilter {
	filter: alpha(opacity =       0)
}

/*“更多……”设置*/
.othernav {
	color: #fff
}
</style>
	</head>
	<body topmargin='0' leftmargin='0'>
		<jsp:include page="/main/top.jsp"></jsp:include>
		<table border='0' cellspacing='0' cellpadding='0' align='center'
			class='bgcolor'>
			<tr>
				<td class='left'></td>
				<td class='width'>
					<table width='100%' border='0' cellspacing='0' cellpadding='0'>
						<tr>
							<td valign='top'>
								<jsp:include page="/main/login.jsp"></jsp:include>
								<jsp:include page="/main/t1.jsp"></jsp:include>
								<jsp:include page="/main/t2.jsp"></jsp:include>
								<jsp:include page="/main/t3.jsp"></jsp:include>
								<jsp:include page="/main/yq1.jsp"></jsp:include>
								<jsp:include page="/main/yq1.jsp"></jsp:include>
							</td>
							<td width="5"></td>
							<td valign='top' align=right>
								<jsp:include page="/main/subject.jsp"></jsp:include>
								<jsp:include page="/main/m1.jsp"></jsp:include>
								<jsp:include page="/main/m2.jsp"></jsp:include>
								<jsp:include page="/main/englishStudy.jsp"></jsp:include>
								<jsp:include page="/main/englishStudy.jsp"></jsp:include>
							</td>
						</tr>
					</table>
				</td>
				<td class=right></td>
			</tr>
		</table>
		<jsp:include page="/main/down.jsp"></jsp:include>
	</body>
</html>
