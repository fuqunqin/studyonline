<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
	</head>

	<body>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class="righttopleft"></td>
				<td class="righttopcenter">
					&emsp;
					<img border="0"
						src='${pageContext.request.contextPath }/mainimages/mor.gif'
						align="absmiddle" />
					&nbsp;学科前沿
					<span style="width: 400px"></span>
					<div class="submore">
					<img border="0"
						src='${pageContext.request.contextPath }/mainimages/more.gif'
						align="absmiddle" />
					<a href="${pageContext.request.contextPath }/querySubjects.do"><font
						class="othernav">更多…</font> </a>
					</div>
				</td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class="rightcenterleft"></td>
				<td class="rightcentercenter" valign='top' height="170">
					<table border='0' width='100%' height='100%'>
						<tr>
							<td width='150' align='center'>
								<table>
									<tr>
										<td height="5"></td>
									</tr>
								</table>
								<table cellspacing="0" cellpadding="0" width="120" border="0">
									<tr>
										<td valign="bottom" align="middle">
											<table cellspacing="1" cellpadding="0" bgcolor="#e1e1e1"
												border="0">
												<tr>
													<td bgcolor="#ffffff">
														<table cellspacing="1" cellpadding="0" bgcolor="#d7d7d7"
															border="0">
															<tr>
																<td bgcolor="#ffffff">
																	<table cellspacing="1" cellpadding="0"
																		bgcolor="#808080" border="0">
																		<tr>
																			<td bgcolor="#ffffff">
																				<table cellspacing="0" cellpadding="1" width='100%'
																					border="0">
																					<tr>
																						<td align="middle" style='padding: 4px;'>
																							<img border="0"
																								style="width: 150px; height: 160px"
																								src='${pageContext.request.contextPath }/images/e4.jpg' />
																						</td>
																					</tr>
																				</table>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td height="5"></td>
									</tr>
								</table>
							</td>
							<td valign="top" style='border-left: 1px dotted #C2CCE3;'
								class="newsbg">
								<table>
									<tr>
										<td height="5"></td>
									</tr>
								</table>
								<c:forEach var="mainFrontier" items="${mainfs }">
									<table border="0" width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
												&nbsp;[${mainFrontier.subject.subjectName }]&nbsp;
												<a
													href="${pageContext.request.contextPath }/queryFrontier.do?id=${mainFrontier.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainFrontier.title)>15}">
													${fn:substring(mainFrontier.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainFrontier.title)<=15}">
												${mainFrontier.title }
												</c:if> </font> </a>
											</td>
											<td width="60"
												style='border-top: 1px dotted #C2CCE3; height: 24'>
												<fmt:formatDate value="${mainFrontier.publishDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
								<c:forEach var="mainWin" items="${mainws }">
									<table border="0" width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
												&nbsp;[${mainWin.subject.subjectName }]&nbsp;
												<a
													href="${pageContext.request.contextPath }/queryWin.do?id=${mainWin.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainWin.winName)>15}">
													${fn:substring(mainWin.winName, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainWin.winName)<=15}">
												${mainWin.winName }
												</c:if> </font> </a>
											</td>
											<td width="60"
												style='border-top: 1px dotted #C2CCE3; height: 24'>
												<fmt:formatDate value="${mainWin.publishDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
								<c:forEach var="mainSutraBook" items="${mainsbs }">
									<table border="0" width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px'>
												&nbsp;[${mainSutraBook.subject.subjectName }]&nbsp;
												<a
													href="${pageContext.request.contextPath }/querySutraBook.do?id=${mainSutraBook.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainSutraBook.bookName)>15}">
													${fn:substring(mainSutraBook.bookName, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainSutraBook.bookName)<=15}">
												${mainSutraBook.bookName }
												</c:if> </font> </a>
											</td>
											<td width="60"
												style='border-top: 1px dotted #C2CCE3; height: 24'>
												<fmt:formatDate value="${mainSutraBook.publishDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class="rightfootleft"></td>
				<td class="rightfootcenter"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td height="5"></td>
			</tr>
		</table>
	</body>
</html>
