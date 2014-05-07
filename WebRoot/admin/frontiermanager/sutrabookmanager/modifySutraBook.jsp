<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="${pageContext.request.contextPath }/css/css.css"
			rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/interface/SubjectDwr.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/engine.js'></script>
		<script type='text/javascript'
			src='${pageContext.request.contextPath }/dwr/util.js'></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/jquery_last.js"></script>
		<script defer="defer" type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/WdatePicker.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/datepicker/DateTimeMask.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#publicDateStr").focus(
					function(){
						WdatePicker({
							skin:'whyGreen',
							oncleared:function(){
								$(this).blur();
						}
					})
				});
				SubjectDwr.query(function(subjects){
					dwr.util.removeAllOptions("subjects");
					dwr.util.addOptions("subjects",subjects);
				});
				document.getElementById("tiJiao").onclick=function(){
					var bookName=document.getElementById("bookName").value;
					if(bookName==null||bookName==""){
						alert("请输入经典图书名称");
						document.getElementById("bookName").focus();
						return false;
					}
					var publicCompany=document.getElementById("publicCompany").value;
					if(publicCompany==null||publicCompany==""){
						alert("请输入出版社名称");
						document.getElementById("publicCompany").focus();
						return false;
					}
					var bookUserName=document.getElementById("bookUserName").value;
					if(bookUserName==null||bookUserName==""){
						alert("请输入出版人姓名");
						document.getElementById("bookUserName").focus();
						return false;
					}
					var publicDateStr=document.getElementById("publicDateStr").value;
					if(publicDateStr==null||publicDateStr==""){
						alert("请选择出版时间");
						document.getElementById("publicDateStr").focus();
						return false;
					}
				};
			});
		</script>
	</head>
	<body>
		<form method="post"
			action="${pageContext.request.contextPath }/admin/modifySutraBook.do">
			<table class="table" cellspacing="1" cellpadding="2" width="99%"
				align="center" border="0">
				<tr class="td_bg">
					<td>
						经典图书名称：
					</td>
					<td colspan="3">
						<input type="text" name="bookName" id="bookName"
							value="${sutraBook.bookName }" size="80" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td width="25%">
						所属学科：
					</td>
					<td>
						<select name="subject" id="subjects"></select>
					</td>
					<td>
						出版社：
					</td>
					<td>
						<input type="text" name="publicCompany" id="publicCompany"
							value="${sutraBook.publicCompany }" />
					</td>
				</tr>
				<tr class="td_bg">
					<td width="25%">
						作者：
					</td>
					<td width="25%">
						<input type="text" name="bookUserName" id="bookUserName"
							value="${sutraBook.bookUserName }" />
					</td>
					<td width="25%">
						出版时间：
					</td>
					<td width="25%">
						<input type="text" readonly="readonly" name="publicDateStr"
							id="publicDateStr"
							value="<fmt:formatDate value='${sutraBook.publicDate }' pattern='yyyy-MM-dd' />" />
					</td>
				</tr>
				<tr height="30" class="td_bg">
					<td colspan="4">
						图书简介：
					</td>
				</tr>
				<tr class="td_bg">
					<td colspan="4">
						<textarea name="bookSynopsis" cols="110" rows="20">${sutraBook.bookSynopsis }</textarea>
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
			<input type="hidden" value="${sutraBook.id }" name="sutraBookId" />
			<input type="hidden" name="publishDateStr"
				value="<fmt:formatDate value='${sutraBook.publishDate }'
						pattern='yyyy-MM-dd' />" />
		</form>
	</body>
</html>
