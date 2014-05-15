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
					<a href="#div11">技巧及方法</a>
				</li>
				<li>
					<a href="#div22">在线听力</a>
				</li>
				<li>
					<a href="#div33">真题欣赏</a>
				</li>
			</ul>
			<div id="div11">
				<c:forEach var="englishStudy" items="${englishStudies }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 320px'>
								&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryEnglishStudy.do?id=${englishStudy.id }"><font
									color='#000000'> <c:if
											test="${fn:length(englishStudy.title)>20}">
													${fn:substring(englishStudy.title, 0, 20)}...
												</c:if> <c:if test="${fn:length(englishStudy.title)<=20}">
												${englishStudy.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${englishStudy.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${espage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${espage.totalPage}" step="1">
						<c:if test="${espage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${espage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryEnglishStudies.do?espageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div22">
				<c:forEach var="onlineListening" items="${onlineListenings }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryOnlineListening.do?id=${onlineListening.id }"><font
									color='#000000'> <c:if
											test="${fn:length(onlineListening.title)>20}">
													${fn:substring(onlineListening.title, 0, 20)}...
												</c:if> <c:if test="${fn:length(onlineListening.title)<=20}">
												${onlineListening.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${onlineListening.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${olpage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${olpage.totalPage}" step="1">
						<c:if test="${olpage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${olpage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryOnlineListenings.do?olpageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div33">
				<c:forEach var="examAppreciate" items="${examAppreciates }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryExamAppreciate.do?id=${examAppreciate.id }"><font
									color='#000000'> <c:if
											test="${fn:length(examAppreciate.title)>15}">
													${fn:substring(examAppreciate.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(examAppreciate.title)<=15}">
												${examAppreciate.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${examAppreciate.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${eapage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${eapage.totalPage}" step="1">
						<c:if test="${eapage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${eapage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryExamAppreciates.do?eapageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</body>
</html>
