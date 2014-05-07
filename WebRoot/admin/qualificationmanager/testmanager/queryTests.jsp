<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript">
			function adminAddTest(){
				window.location.href="${pageContext.request.contextPath}/admin/qualificationmanager/testmanager/addTest.jsp";
			}
			var flag=false;
			function selectAll(){
				var ids=document.getElementsByName("ids");
				var bool=flag;
				if(bool==false){
					for(var i=0;i<ids.length;i++){
						ids[i].checked=true;
					}
					flag=true;
				}else{
					for(var i=0;i<ids.length;i++){
						ids[i].checked=false;
					}
					flag=false;
				}
			}
			function quXiaoSelect(){
				document.getElementById("allSelect").checked=false;
				flag=false;
			}
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/admin/deleteTests.do"
			method="post">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="bg_tr" align="center">
					<td width="5%">
						<input type="checkbox" id="allSelect" onclick="selectAll();" />
					</td>
					<td width="5%">
						编号
					</td>
					<td width="15%">
						资格类别
					</td>
					<td width="50%">
						资格试题名称
					</td>
					<td colspan="2" width="10%">
						操作
					</td>
				</tr>
				<c:forEach var="test" items="${tests }">
					<tr class="td_bg" align="center">
						<td>
							<input type="checkbox" name="ids" value="${test.id }"
								onclick="quXiaoSelect();" />
						</td>
						<td>
							${test.id }
						</td>
						<td>
							${test.qualificationType.typeName }
						</td>
						<td>
							${test.title }
						</td>
						<td>
							<a style="color: red"
								href="${pageContext.request.contextPath }/admin/queryTest.do?id=${test.id }">查看</a>
						</td>
						<td>
							<a style="color: red"
								href="${pageContext.request.contextPath }/admin/updateTest.do?id=${test.id }">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="0">
				<tr height="30" align="center">
					<td>
						<input type="submit" value="删除">
					</td>
					<td>
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
		<div align="center">
			<form action="">
				第
				<font color="red">${page.pageIndex }</font>页/共
				<font color="red">${page.totalPage }</font>页
				<select name="pageIndex">
					<c:forEach var="pageIndex" begin="1" end="${page.totalPage}"
						step="1">
						<option value="${pageIndex }"
							<c:if test="${pageIndex==page.pageIndex }">selected="selected"</c:if>>
							${pageIndex }
						</option>
					</c:forEach>
				</select>
				<input value="Go" type="submit" />
			</form>
			<input value="添加共享资料" type="button" onclick="adminAddTest();" />
		</div>
	</body>
</html>
