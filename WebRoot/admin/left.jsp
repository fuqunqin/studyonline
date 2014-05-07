<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}

.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
	<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #ffffff;
	POSITION: relative;
	TOP: 2px
}

.menu_title2 SPAN {
	FONT-WEIGHT: bold;
	LEFT: 3px;
	COLOR: #FFCC00;
	POSITION: relative;
	TOP: 2px
}
</style>
	<script>
	window.onload=function(){
		var menu=document.getElementsByTagName("tr");
		for(var p in menu){
			if(p.indexOf("submenu")==0){
				var m=document.getElementById(p);
				m.style.display="none";
			}
		}
	}
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</script>

	<table width="165" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td height="28" background="../images/main_40.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="19%">
							&nbsp;
						</td>
						<td width="81%" height="20">
							<span class="STYLE1">管理菜单</span>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<c:forEach var="menu" items="${menues }">
			<tr>
				<td valign="top">
					<table border="0" align="center" cellpadding="0" cellspacing="0"
						width="151">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="23" background="../images/main_47.gif"
											id="imgmenu${menu.key.id }" class="menu_title"
											onMouseOver="this.className='menu_title2';"
											onClick="showsubmenu('${menu.key.id }')"
											onMouseOut="this.className='menu_title';"
											style="cursor: hand">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="18%">
														&nbsp;
													</td>
													<td width="82%" class="STYLE1">
														${menu.key.menuName }
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr id="submenu${menu.key.id }">
										<td background="../images/main_51.gif">
											<div class="sec_menu">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td>
															<c:forEach var="m" items="${menu.value}">
																<table width="90%" border="0" align="center"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td width="16%" height="10">
																			<div align="center">
																				<img src="../images/left.gif" width="10" height="10" />
																			</div>
																		</td>
																		<td width="84%">
																			<table width="95%" border="0" cellspacing="0"
																				cellpadding="0">
																				<tr>
																					<td height="20" style="cursor: hand;"
																						onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3';"
																						onmouseout="this.style.borderStyle='none';"
																						onclick="window.parent.document.all('I2').src='${m.url }'";>
																						<span class="STYLE3">${m.menuName }</span>
																					</td>
																				</tr>
																			</table>
																		</td>
																	</tr>
																</table>
															</c:forEach>
														</td>
													</tr>
													<tr>
														<td height="5">
															<img src="../images/main_52.gif" width="151" height="5" />
														</td>
													</tr>
												</table>
											</div>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</html>