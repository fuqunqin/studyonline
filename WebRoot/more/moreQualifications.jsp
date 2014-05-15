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
					<a href="#div11">资格认证动态</a>
				</li>
				<li>
					<a href="#div22">资格考试信息</a>
				</li>
				<li>
					<a href="#div33">资格试题测试</a>
				</li>
			</ul>
			<div id="div11">
				<c:forEach var="accreditation" items="${accreditations }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 320px'>
								&nbsp;[${accreditation.qualificationType.typeName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryAccreditation.do?id=${accreditation.id }"><font
									color='#000000'> <c:if
											test="${fn:length(accreditation.title)>15}">
													${fn:substring(accreditation.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(accreditation.title)<=15}">
												${accreditation.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${accreditation.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${apage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${apage.totalPage}" step="1">
						<c:if test="${apage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${apage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryAccreditations.do?apageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div22">
				<c:forEach var="certificateExam" items="${certificateExams }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;[${certificateExam.qualificationType.typeName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryCertificateExam.do?id=${certificateExam.id }"><font
									color='#000000'> <c:if
											test="${fn:length(certificateExam.title)>15}">
													${fn:substring(certificateExam.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(certificateExam.title)<=15}">
												${certificateExam.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${certificateExam.publishDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${cepage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${cepage.totalPage}" step="1">
						<c:if test="${cepage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${cepage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryCertificateExams.do?cepageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
			<div id="div33">
				<c:forEach var="test" items="${tests }">
					<table border="0" width='94%' cellspacing='0' cellpadding='0'>
						<tr>
							<td
								style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
								&nbsp;[${test.qualificationType.typeName }]&nbsp;
								<a
									href="${pageContext.request.contextPath }/queryTest.do?id=${test.id }"><font
									color='#000000'> <c:if
											test="${fn:length(test.title)>15}">
													${fn:substring(test.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(test.title)<=15}">
												${test.title }
												</c:if> </font> </a>
							</td>
							<td width="60" style='border-top: 1px dotted #C2CCE3; height: 24'>
								<fmt:formatDate value="${test.uploadeDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</table>
				</c:forEach>
				<c:if test="${tpage.totalPage!=1}">
					<c:forEach var="i" begin="1" end="${tpage.totalPage}" step="1">
						<c:if test="${tpage.pageIndex==i}">
							${i }&nbsp;
						</c:if>
						<c:if test="${tpage.pageIndex!=i}">
							<a style="color: red"
								href="${pageContext.request.contextPath }/queryTests.do?tpageIndex=${i }">${i
								}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</body>
</html>
