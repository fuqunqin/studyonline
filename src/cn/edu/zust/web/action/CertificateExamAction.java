package cn.edu.zust.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.CertificateExamBiz;
import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class CertificateExamAction extends MappingDispatchAction {
	private CertificateExamBiz certificateExamBiz;

	public CertificateExamBiz getCertificateExamBiz() {
		return certificateExamBiz;
	}

	public void setCertificateExamBiz(CertificateExamBiz certificateExamBiz) {
		this.certificateExamBiz = certificateExamBiz;
	}

	public ActionForward adminQueryCertificateExams(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<CertificateExam> certificateExams = certificateExamBiz.query(page);
		request.setAttribute("certificateExams", certificateExams);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryCertificateExam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		CertificateExam certificateExam = certificateExamBiz.query(id);
		request.setAttribute("certificateExam", certificateExam);
		return mapping.findForward("success");
	}

	public ActionForward adminAddCertificateExam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CertificateExam certificateExam = new CertificateExam();
		String title = request.getParameter("title");
		certificateExam.setTitle(title);
		String examDateStr = request.getParameter("examDateStr");
		Date examDate = DateUtil.string2Date(examDateStr);
		certificateExam.setExamDate(examDate);
		String userBook = request.getParameter("userBook");
		certificateExam.setUserBook(userBook);
		String qualificateTypeIdStr = request.getParameter("qualificationType");
		Integer qualificateTypeId = Integer.valueOf(qualificateTypeIdStr);
		QualificationType qt = new QualificationType();
		qt.setId(qualificateTypeId);
		certificateExam.setQualificationType(qt);
		certificateExam.setPublishDate(new Date());
		certificateExam = certificateExamBiz.add(certificateExam);
		request.setAttribute("certificateExam", certificateExam);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyCertificateExam(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CertificateExam certificateExam = new CertificateExam();
		String idStr = request.getParameter("certificateExamId");
		certificateExam.setId(Integer.valueOf(idStr));
		String title = request.getParameter("title");
		certificateExam.setTitle(title);
		String examDateStr = request.getParameter("examDateStr");
		Date examDate = DateUtil.string2Date(examDateStr);
		certificateExam.setExamDate(examDate);
		String userBook = request.getParameter("userBook");
		certificateExam.setUserBook(userBook);
		String qualificateTypeIdStr = request.getParameter("qualificationType");
		Integer qualificateTypeId = Integer.valueOf(qualificateTypeIdStr);
		QualificationType qt = new QualificationType();
		qt.setId(qualificateTypeId);
		certificateExam.setQualificationType(qt);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		certificateExam.setPublishDate(publishDate);
		certificateExam = certificateExamBiz.modify(certificateExam);
		request.setAttribute("certificateExam", certificateExam);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteCertificateExams(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<CertificateExam> certificateExams = new ArrayList<CertificateExam>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				CertificateExam certificateExam = new CertificateExam();
				certificateExam.setId(id);
				certificateExams.add(certificateExam);
			}
			certificateExamBiz.remove(certificateExams);
		}
		return mapping.findForward("success");
	}
}
