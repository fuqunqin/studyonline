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

import cn.edu.zust.biz.EnglishStudyBiz;
import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class EnglishStudyAction extends MappingDispatchAction {
	private EnglishStudyBiz englishStudyBiz;

	public EnglishStudyBiz getEnglishStudyBiz() {
		return englishStudyBiz;
	}

	public void setEnglishStudyBiz(EnglishStudyBiz englishStudyBiz) {
		this.englishStudyBiz = englishStudyBiz;
	}

	public ActionForward adminQueryEnglishStudies(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<EnglishStudy> englishStudies = englishStudyBiz.query(page);
		request.setAttribute("englishStudies", englishStudies);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryEnglishStudy(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		EnglishStudy englishStudy = englishStudyBiz.query(id);
		request.setAttribute("englishStudy", englishStudy);
		return mapping.findForward("success");
	}

	public ActionForward adminAddEnglishStudy(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EnglishStudy englishStudy = new EnglishStudy();
		String title = request.getParameter("title");
		englishStudy.setTitle(title);
		String content = request.getParameter("content");
		englishStudy.setContent(content);
		englishStudy.setPublishDate(new Date());
		englishStudy = englishStudyBiz.add(englishStudy);
		request.setAttribute("englishStudy", englishStudy);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyEnglishStudy(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EnglishStudy englishStudy = new EnglishStudy();
		String idStr = request.getParameter("englishStudyId");
		Integer id = Integer.valueOf(idStr);
		englishStudy.setId(id);
		String title = request.getParameter("title");
		englishStudy.setTitle(title);
		String content = request.getParameter("content");
		englishStudy.setContent(content);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		englishStudy.setPublishDate(publishDate);
		englishStudy = englishStudyBiz.modify(englishStudy);
		request.setAttribute("englishStudy", englishStudy);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteEnglishStudies(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<EnglishStudy> englishStudies = new ArrayList<EnglishStudy>();
			for (String idStr : idsStr) {
				EnglishStudy englishStudy = new EnglishStudy();
				englishStudy.setId(Integer.valueOf(idStr));
				englishStudies.add(englishStudy);
			}
			englishStudyBiz.remove(englishStudies);
		}
		return mapping.findForward("success");
	}
}
