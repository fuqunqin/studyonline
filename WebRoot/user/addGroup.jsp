<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#div1").tabs();
				$("#tiJiao").click(function(){
					var groupName=$("#groupName").val();
					if(groupName==null||groupName==""){
						alert("请输入兴趣小组名称");
						$("#groupName").focus();
						return false;
					}
				});
			});
		</script>
	</head>
	<body>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<div id="div1" style="border-color: #0054AA; height: 1050px">
			<ul>
				<li>
					<a href="#page">创建小组</a>
				</li>
			</ul>
			<div id="page">
				<form method="post" 
					action="${pageContext.request.contextPath }/user/addInterestGroup.do">
					<table class="table" cellspacing="1" cellpadding="2" width="94%"
						align="center" border="0">
						<tr class="td_bg">
							<td
								style='border-top: 1px dotted #C2CCE3; height: 50; width: 350px'>
								小组名称：
							</td>
							<td colspan="3"
								style='border-top: 1px dotted #C2CCE3; height: 50;'>
								<input type="text" name="groupName" id="groupName" size="60" />
							</td>
						</tr>
						<tr height="30" class="td_bg">
							<td width="25%"
								style='border-top: 1px dotted #C2CCE3; height: 80;'>
								小组公告：
							</td>
							<td  colspan="3"
								style='border-top: 1px dotted #C2CCE3;'>
								<textarea rows="5" cols="60" name="groupNotice" id="groupNotice"></textarea>
							</td>
						</tr>
					</table>
					<table cellspacing="0" cellpadding="0" width="60%" align="center"
						border="0">
						<tr height="30" align="center">
							<td>
								<input type="submit" value="提交" id="tiJiao">
							</td>
							<td>
								<input type="reset" value="重置">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
