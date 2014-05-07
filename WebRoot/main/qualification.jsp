<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class=righttopleft></td>
				<td class=righttopcenter>
					&emsp;
					<img border=0
						src='${pageContext.request.contextPath }/mainimages/mor.gif'
						align=absmiddle>
					&nbsp;资格认证
					<span style="width: 400px"></span>
					<div class="submore">
					<img border=0
						src='${pageContext.request.contextPath }/mainimages/more.gif'
						align=absmiddle>
					<a
						href="${pageContext.request.contextPath }/queryQualifications.do"><font
						class=othernav>更多…</font> </a>
					</div>
				</td>
			</tr>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class=rightcenterleft></td>
				<td class=rightcentercenter valign='top' height=170>
					<table border=0 width='100%' height='100%'>
						<tr>
							<td width=150 align=center>
								<table>
									<tr>
										<td height=5></td>
									</tr>
								</table>
								<TABLE cellSpacing=0 cellPadding=0 width=120 border=0>
									<TR>
										<TD vAlign=bottom align=middle>
											<TABLE cellSpacing=1 cellPadding=0 bgColor=#e1e1e1 border=0>
												<TR>
													<TD bgColor=#ffffff>
														<TABLE cellSpacing=1 cellPadding=0 bgColor=#d7d7d7
															border=0>
															<TR>
																<TD bgColor=#ffffff>
																	<TABLE cellSpacing=1 cellPadding=0 bgColor=#000
																		border=0>
																		<TR>
																			<TD bgColor=#ffffff>
																				<TABLE cellSpacing=0 cellPadding=1 width='100%'
																					border=0>
																					<TR>
																						<TD align=middle style='padding: 4px'>
																							<img border="0"
																								style="width: 150px; height: 160px"
																								src='${pageContext.request.contextPath }/images/e2.jpg' />
																						</TD>
																					</TR>
																				</TABLE>
																			</TD>
																		</TR>
																	</TABLE>
																</TD>
															</TR>
														</TABLE>
													</TD>
												</TR>
											</TABLE>
										</TD>
									</TR>
								</TABLE>
								<table>
									<tr>
										<td height=5></td>
									</tr>
								</table>
								<table>
									<tr>
										<td height=5></td>
									</tr>
								</table>
							<td valign=top style='border-left: 1px dotted #C2CCE3;'
								class=djbg>
								<c:forEach var="mainAccreditation" items="${mainas }">
									<table border=0 width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px''>
												&nbsp; [${mainAccreditation.qualificationType.typeName }]
												<a
													href="${pageContext.request.contextPath }/queryAccreditation.do?id=${mainAccreditation.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainAccreditation.title)>15}">
													${fn:substring(mainAccreditation.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainAccreditation.title)<=15}">
												${mainAccreditation.title }
												</c:if> </font> </a>
											</td>
											<td width=60 style='border-top: 1px dotted #C2CCE3;'>
												<fmt:formatDate value="${mainAccreditation.publishDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
								<c:forEach var="mainCertificateExam" items="${mainces }">
									<table border=0 width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px''>
												&nbsp; [${mainCertificateExam.qualificationType.typeName }]
												<a
													href="${pageContext.request.contextPath }/queryCertificateExam.do?id=${mainCertificateExam.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainCertificateExam.title)>15}">
													${fn:substring(mainCertificateExam.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainCertificateExam.title)<=15}">
												${mainCertificateExam.title }
												</c:if> </font> </a>
											</td>
											<td width=60 style='border-top: 1px dotted #C2CCE3;'>
												<fmt:formatDate value="${mainCertificateExam.publishDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
								<c:forEach var="mainTest" items="${maints }">
									<table border=0 width='100%' cellspacing='0' cellpadding='0'>
										<tr>
											<td
												style='border-top: 1px dotted #C2CCE3; height: 24; width: 300px''>
												&nbsp; [${mainTest.qualificationType.typeName }]
												<a
													href="${pageContext.request.contextPath }/queryTest.do?id=${mainTest.id }"><font
													color='#000000'> <c:if
															test="${fn:length(mainTest.title)>15}">
													${fn:substring(mainTest.title, 0, 15)}...
												</c:if> <c:if test="${fn:length(mainTest.title)<=15}">
												${mainTest.title }
												</c:if> </font> </a>
											</td>
											<td width=60 style='border-top: 1px dotted #C2CCE3;'>
												<fmt:formatDate value="${mainTest.uploadeDate }"
													pattern="yyyy-MM-dd" />
											</td>
										</tr>
									</table>
								</c:forEach>
							</td>
						</tr>
					</table>
				</TD>
			</TR>
		</table>
		<table border='0' cellspacing='0' cellpadding='0'>
			<tr>
				<td class=rightfootleft></td>
				<td class=rightfootcenter></td>
			</tr>
		</table>
		<table>
			<tr>
				<td height=5></td>
			</tr>
		</table>
	</body>
</html>
