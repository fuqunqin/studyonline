<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.custom.min.js"></script>
		<link id="c3" type="text/css" rel="stylesheet"
			href="css/redmond/jquery-ui-1.7.1.custom.css"></link>
		<style type="text/css">
</style>
		<script type="text/javascript">
			$(document).ready(function(){
				$("#div1").tabs();	
			});
		</script>
	</head>

	<body>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<div id="div1" style="border-color: #0054AA; height: 1000px;">
			<ul>
				<li>
					<a href="#div11">学科动态</a>
				</li>
				<li>
					<a href="#div22">科研成果</a>
				</li>
				<li>
					<a href="#div33">经典图书</a>
				</li>
			</ul>
			<div id="div11">
				<c:forEach var="frontier" items="${frontieres }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 320px'>
								&nbsp;[${frontier.subject.subjectName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryFrontier.do?id=${frontier.id }"><font
									color='#000000'> <c:if
											test="${fn:length(frontier.title)>15}">
													${fn:substring(frontier.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(frontier.title)<=15}">
												${frontier.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${frontier.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${fpage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${fpage.totalPage}" step="1">
						<c:if test="${fpage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${fpage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryFrontiers.do?fpageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div22">
				<c:forEach var="win" items="${wins }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;[${win.subject.subjectName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryWin.do?id=${win.id }"><font
									color='#000000'> <c:if
											test="${fn:length(win.winName)>15}">
													${fn:substring(win.winName, 0, 15)}...
												</c:if> <c:if test="${fn:length(win.winName)<=15}">
												${win.winName }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${win.publishDate }" pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${wpage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${wpage.totalPage}" step="1">
						<c:if test="${wpage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${fpage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryWins.do?wpageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div33">
				<c:forEach var="sutraBook" items="${sutraBooks }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;[${sutraBook.subject.subjectName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/querySutraBook.do?id=${sutraBook.id }"><font
									color='#000000'> <c:if
											test="${fn:length(sutraBook.bookName)>15}">
													${fn:substring(sutraBook.bookName, 0, 15)}...
												</c:if> <c:if test="${fn:length(sutraBook.bookName)<=15}">
												${sutraBook.bookName }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${sutraBook.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${sbpage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${sbpage.totalPage}" step="1">
						<c:if test="${sbpage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${sbpage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/querySutraBooks.do?sbpageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</body>
</html>
