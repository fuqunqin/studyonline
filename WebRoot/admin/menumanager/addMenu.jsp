<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type="text/javascript">
			window.onload=function(){
				$("parentId").onchange=function(){
					var index=$("parentId").selectedIndex;
					var value=$("parentId")[index].value;
					if(value==-1){
						$("url").value="";
						$("urlView").style.display="none";
					}else{
						$("urlView").style.display="block";
					}
				}
			}
			function $(id){
				return document.getElementById(id);
			}
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/admin/addMenu.do"
			method="post">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr>
					<th class="bg_tr" align="left" colspan="2" height="25">
						添加菜单
					</th>
				</tr>
				<tr>
					<td class="td_bg" width="30%" height="25">
						菜单名称：
					</td>
					<td class="td_bg">
						<input type="text" value="" name="menuName" id="menuName" />
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="td_bg" height="25">
						父菜单：
					</td>
					<td class="td_bg">
						<select name="parentId" id="parentId">
							<option value="-1">
								--------
							</option>
							<c:forEach var="menu" items="${menues }">
								<option value="${menu.key.id }">
									${menu.key.menuName }
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr style="display: none;" id="urlView">
					<td class="td_bg" height="25">
						跳转路径：
					</td>
					<td class="td_bg">
						<input type="text" value="" id="url" name="url"
							onchange="validateRank();" />
					</td>
				</tr>
				<tr>
					<td class="td_bg" height="25" colspan="2">
						<input type="submit" value="确定" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="取消" onclick="history.go(-1);" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
