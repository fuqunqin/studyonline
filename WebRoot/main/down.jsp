<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
/*底部版权设置*/
.foot {
	width: 980;
	background: #C2CCE3
}

/*下边标题框架↓*/
.footleft {
	//background:url('${pageContext.request.contextPath}/mainimages/footleft.gif');
	height: 4px;
	width: 4px
}

.footcenter {
	background:url('${pageContext.request.contextPath}/mainimages/footcenter.gif');
	height: 4px;
	width: 980px;
}

.footright {
	//background:url('${pageContext.request.contextPath}/mainimages/footright.gif');
	height: 4px;
	width: 4px
}
</style>
	</head>

	<body>
		<table border='0' cellspacing='0' cellpadding='0' align='center'
			class='footmenucss'>
			<tr>
				<td class=''></td>
				<td align='center' class='width'>
					<table border='0' cellspacing='0' cellpadding='0' align='center'
						width='98%' height="30">
						<tr>
							<td>
								<center>
									<marquee height="15" onMouseOver=this.stop()
										onMouseOut=this.start() scrollamount=3 scrolldelay=100
										direction=left style="color: red; text-align: center;">
									</marquee>
								</center>
							</td>
						</tr>
					</table>
				</td>
				<td class=''></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0' align='center'
			class=bgcolor>
			<tr>
				<td class='left'></td>
				<td height='50' align='center' class='foot'
					style='word-break: break-all; table-layout: fixed; line-height: 150%;'>
					<font class='menufont'><table cellspacing='4'
							cellpadding='0'>
							<tr>
								<td>
									<div align='center'>
										Copyright 2010-2014 All Rights Reserved
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align='center'>
										在线学习网络平台 @版权所有2014
										<a href='${pageContext.request.contextPath }/adminLogin.jsp'
											target='_blank' class=bottom>[后台管理]</a>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align='center'>
										地址:浙江科技学院 邮编:310023
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div align='center'>
										
										电子邮箱：fuqunqin@163.com 电话：18768177582
									</div>
								</td>
							</tr>
						</table> </font>

				</td>
				<td class=right></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0' align='center'>
			<tr>
				<td class=footleft></td>
				<td width='740' class=footcenter align='center'></td>
				<td class=footright></td>
			</tr>
		</table>
		<div class=footspace></div>
	</body>
</html>
