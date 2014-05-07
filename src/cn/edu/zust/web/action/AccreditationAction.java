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

import cn.edu.zust.biz.AccreditationBiz;
import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class AccreditationAction extends MappingDispatchAction {
	private AccreditationBiz accreditationBiz;

	public AccreditationBiz getAccreditationBiz() {
		return accreditationBiz;
	}

	public void setAccreditationBiz(AccreditationBiz accreditationBiz) {
		this.accreditationBiz = accreditationBiz;
	}

	public ActionForward adminQueryAccreditations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Accreditation> accreditations = accreditationBiz.query(page);
		request.setAttribute("accreditations", accreditations);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryAccreditation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Accreditation accreditation = accreditationBiz.query(Integer
				.valueOf(idStr));
		request.setAttribute("accreditation", accreditation);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyAccreditation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Accreditation accreditation = new Accreditation();
		String idStr = request.getParameter("accreditationId");
		Integer id = Integer.valueOf(idStr);
		accreditation.setId(id);
		String title = request.getParameter("title");
		accreditation.setTitle(title);
		String content = request.getParameter("content");
		accreditation.setContent(content);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		accreditation.setPublishDate(publishDate);
		String qualificationTypeStr = request.getParameter("qualificationType");
		QualificationType qt = new QualificationType();
		qt.setId(Integer.valueOf(qualificationTypeStr));
		accreditation.setQualificationType(qt);
		accreditation = accreditationBiz.modify(accreditation);
		request.setAttribute("accreditation", accreditation);
		return mapping.findForward("success");
	}

	public ActionForward adminAddAccreditation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Accreditation accreditation = new Accreditation();
		String title = request.getParameter("title");
		accreditation.setTitle(title);
		String content = request.getParameter("content");
		accreditation.setContent(content);
		accreditation.setPublishDate(new Date());
		String qualificationTypeStr = request.getParameter("qualificationType");
		QualificationType qt = new QualificationType();
		qt.setId(Integer.valueOf(qualificationTypeStr));
		accreditation.setQualificationType(qt);
		accreditation = accreditationBiz.add(accreditation);
		request.setAttribute("accreditation", accreditation);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteAcciditations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<Accreditation> accreditations = new ArrayList<Accreditation>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				Accreditation accreditation = new Accreditation();
				accreditation.setId(id);
				accreditations.add(accreditation);
			}
			accreditationBiz.remove(accreditations);
		}
		return mapping.findForward("success");
	}
}
