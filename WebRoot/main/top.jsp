<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/datepicker/jquery_last.js"></script>
	
		<style type="text/css">
		
		
body{
			background-color: #f1f2f6;
		}
/*主体宽度设置↓*/
.width {
	width: 980;
}

/*左右边框架↓*/
.left {
	background:
		//url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px
}

.right {
	background:
		//url('${pageContext.request.contextPath}/mainimages/right.gif');
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
	width: 222px;
	height: 30px;
	color: #FFF
}

.lefttopright {
	background:
		//url('${pageContext.request.contextPath}/mainimages/lanmutopright.gif')
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
	width: 222px;
}

.leftcenterright {
	background:
		//url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px;
}

/*左边底部框架↓*/
.leftfootleft {
	background:
		//url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 184px
}

.leftfootcenter {
	background:
		//url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 184px
}

.leftfootright {
	background:
		//url('${pageContext.request.contextPath}/mainimages/footright.gif');
	width: 4px;
	height: 4px;
}
/*右边标题框架↓*/
.righttopleft {
	background:
		//url('${pageContext.request.contextPath}/mainimages/lanmutopleft.gif');
	width: 6px;
	height: 30px;
}

.righttopcenter {
	background:
		url('${pageContext.request.contextPath}/mainimages/lanmutopcenter.gif')
		;
	width: 718px;
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
		//url('${pageContext.request.contextPath}/mainimages/left.gif');
	width: 4px;
}

.rightcentercenter {
	background: #ffffff;
	width: 720px;
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
	width: 716px;
	height: 4px;
}

.rightfootright {
	background:
		url('${pageContext.request.contextPath}/mainimages/footright.gif');
	width: 4px;
	height: 4px;
}

div.submore{
	display: inline;
	float:right;
	margin-right: 40px;
}

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

/*菜单设置↓*/
.topmenucss {
	background:
		url('${pageContext.request.contextPath}/mainimages/daohanglanBg.jpg')
		;
}

.footmenucss {
	background:
		url('${pageContext.request.contextPath}/mainimages/daohanglanBg.jpg')
		;
}

/*顶部导航设置*/
.menufont {
	color: #FFF;
}
img.headbar{
	width:980px;
	height: 200px;
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
	width: 260px;
	topleft
}

.topcenter {
	background-color:#f1f2f6;
	width: 720px;
	height: 75px;
}

.topright {
	background:
		url('${pageContext.request.contextPath}/mainimages/top_right.gif');
	height: 20px;
	width: 6px
}

.classrighttable{
	width: 720px;
}
.weblogo{
	
 	left: 0px;
}


/* Slideshow */
.slideshow{  margin:0px auto; width:980px; height:200px; border:1px solid #CCC; overflow:hidden; position:relative;}
#showimg{ z-index:10;}
#showimg img{ width:980px; height:200px; display:block;}
.opacity{
	float:left;
	width:980px;
	height:30px;
	/*background-color:#F0F0F0;*/
	position:absolute;
	z-index:99;
	left:3px;
	bottom:1px;
	filter:alpha(opacity=50);
	-moz-opacity:0.5;
	opacity:0.5;
	overflow:hidden;
}
.operate{ position:absolute; z-index:1000; right:3px; bottom:3px;}
.operate span{ float:left; padding:1px 10px; margin-left:1px; height:22px; line-height:22px; font-weight:bold; cursor:pointer; color:#000; text-align:center;}
.operate span.hov{ color:#FFF; background-color:#0962C6;}
#msg{
	float:left;
	width:980px;
	height:26px;
	line-height:26px;
	position:absolute;
	z-index:100;
	left:1px;
	bottom:3px;
	overflow:hidden;
}
#msg li{ padding-left:14px; height:24px; line-height:24px; font-size:14px; font-weight:bold; color:#004C94; text-align:left; display:block;}

</style>

	</head>
	<body>
		<table border='0' cellspacing='0' cellpadding='0' align='center'>
			<tr>
				
				<td class='topleft' align='center'>
					<img class="weblogo" src='${pageContext.request.contextPath}/mainimages/weblogo.png'>
				</td>
				<td class='topcenter' align="left" valign="middle">
					<font color="">在线学习网络平台</font>
				</td>
			
			</tr>
		</table>
		
		<table border='0' cellspacing='0' cellpadding='0' align='center'>
			<tr>
				<td class='left'></td>
				<td height='35' class='width'>
					<table border='0' cellspacing='0' cellpadding='0' align='center'
						class='footmenucss' width='100%'>
						<tr>
							<td>
								<table border='0' cellspacing='0' cellpadding='0' width='100%'>
									<tr>
										<td width='8'></td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a href='${pageContext.request.contextPath }/index.jsp'
															id='menu1' class='menufont'>本站首页</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/querySubjects.do'
															class='menufont'>学科前沿</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/queryPubmedTribes.do'
															class='menufont'>考研部落</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/queryQualifications.do'
															class='menufont'>资格认证</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/queryEnglishes.do'
															class='menufont'>英语学习</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/queryShares.do'
															class='menufont'>资料共享</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a
															href='${pageContext.request.contextPath }/queryInterestGroups.do'
															id='menu5' class='menufont'>兴趣小组</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a href='mailto:evan0625@163.com' id='menu7'
															class='menufont'>联系我们</a>
													</td>
												</tr>
											</table>
										</td>
										<td width=64 align='center' height=35>
											<table>
												<tr>
													<td width='62' height='22' align='center'>
														<a href='${pageContext.request.contextPath }/about.jsp' id='menu27' class='menufont'>关于毕设</a>
													</td>
												</tr>
											</table>
										</td>
										<td width='1' align='center' height='30'>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td class=right></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0' align='center'>
			<tr>
				<td class='left'></td>
				<td height="100%">
					<!-- <img class="headbar" src="${pageContext.request.contextPath }/mainimages/logo2.png"border="0" />
						-->
				</td>
				<td class='right'></td>
			</tr>
		</table>
		
		<!-- Slideshow Begin-->
		<div class="slideshow" id="slideshow"> 
          <div id="showimg">
           <a href="#" target=""><img src="${pageContext.request.contextPath }/mainimages/slider(2).jpg" class="attachment-full wp-post-image" alt="" /></a>
           <a href="#" target=""><img src="${pageContext.request.contextPath }/mainimages/slider(1).jpg" class="attachment-full wp-post-image" alt="" /></a>
           <a href="#" target=""><img src="${pageContext.request.contextPath }/mainimages/slider(3).jpg" class="attachment-full wp-post-image" alt="" /></a>
           <a href="#" target=""><img src="${pageContext.request.contextPath }/mainimages/slider(4).jpg" class="attachment-full wp-post-image" alt="" /></a>
          </div>
        <div class="opacity"></div>
        <div class="operate" id="operate">
           <span class="hov">1</span><span>2</span><span>3</span><span>4</span>
        </div>
        <ul id="msg">
          <li><a href="#" target=""></a></li>
          <li><a href="#" target=""></a></li>
          <li><a href="#" target=""></a></li>
          <li><a href="#" target=""></a></li>
       </ul>
    </div>
	  <script language="javascript" >
$(function(){
	 var index = 0;
	 $("#operate span").mouseover(function(){
		index  =  $("#operate span").index(this);
		showImg(index);
	});	
	 //滑入 停止动画，滑出开始动画.
	 $('#slideshow').hover(function(){
			  if(MyTime){
				 clearInterval(MyTime);
			  }
	 },function(){
			  MyTime = setInterval(function(){
			    showImg(index)
				index++;
				if(index==4){index=0;}
			  } , 3000);
	 });
	 //自动开始
	 var MyTime = setInterval(function(){
		showImg(index)
		index++;
		if(index==4){index=0;}
	 } , 3000);
})
//关键函数：通过控制i ，来显示不通的幻灯片
function showImg(i){
		$("#showimg img")
			.eq(i).stop(true,true).fadeIn(1000)
			.parent().siblings().find("img").hide();
		$("#msg li")
			.eq(i).stop(true,true).fadeIn(1000)
			.siblings().hide();
		 $("#operate span")
			.eq(i).addClass("hov")
			.siblings().removeClass("hov");
}
</script> 
    <!-- Slideshow end-->
	</body>
</html>
