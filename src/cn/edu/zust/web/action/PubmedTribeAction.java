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

import cn.edu.zust.biz.PubmedTribeBiz;
import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.entity.PubmedType;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class PubmedTribeAction extends MappingDispatchAction {
	private PubmedTribeBiz pubmedTribeBiz;

	public PubmedTribeBiz getPubmedTribeBiz() {
		return pubmedTribeBiz;
	}

	public void setPubmedTribeBiz(PubmedTribeBiz pubmedTribeBiz) {
		this.pubmedTribeBiz = pubmedTribeBiz;
	}

	public ActionForward adminQueryPubmedTribes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<PubmedTribe> pubmedTribes = pubmedTribeBiz.query(page);
		request.setAttribute("pubmedTribes", pubmedTribes);
		request.setAttribute("page", page);
		return mapping.findForward("adminQueryPubmedTribesOk");
	}

	public ActionForward adminQueryPubmedTribe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		PubmedTribe pubmedTribe = pubmedTribeBiz.query(id);
		request.setAttribute("pubmedTribe", pubmedTribe);
		return mapping.findForward("adminQueryPubmedTribeOk");
	}

	public ActionForward adminDeletePubmedTribes(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		List<PubmedTribe> pubmedTribes = new ArrayList<PubmedTribe>();
		if (idsStr != null && idsStr.length > 0) {
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				PubmedTribe pubmedTribe = new PubmedTribe();
				pubmedTribe.setId(id);
				pubmedTribes.add(pubmedTribe);
			}
		}
		if (pubmedTribes.size() > 0) {
			pubmedTribeBiz.remove(pubmedTribes);
		}
		return mapping.findForward("adminDeletePubmedTribesOk");
	}

	public ActionForward adminAddPubmedTribe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pubmedTypeId = request.getParameter("pubmedType");
		PubmedType pubmedType = new PubmedType();
		pubmedType.setId(Integer.valueOf(pubmedTypeId));
		PubmedTribe pubmedTribe = new PubmedTribe();
		pubmedTribe.setContent(content);
		pubmedTribe.setPublishDate(new Date());
		pubmedTribe.setPubmedType(pubmedType);
		pubmedTribe.setTitle(title);
		pubmedTribe = pubmedTribeBiz.add(pubmedTribe);
		request.setAttribute("pubmedTribe", pubmedTribe);
		return mapping.findForward("adminAddPubmedTribeOk");
	}

	public ActionForward adminModifyPubmedTribe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String pubmedTribeId = request.getParameter("pubmedTribeId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pubmedTypeId = request.getParameter("pubmedType");
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		PubmedType pubmedType = new PubmedType();
		pubmedType.setId(Integer.valueOf(pubmedTypeId));
		PubmedTribe pubmedTribe = new PubmedTribe();
		pubmedTribe.setContent(content);
		pubmedTribe.setPublishDate(publishDate);
		pubmedTribe.setPubmedType(pubmedType);
		pubmedTribe.setTitle(title);
		pubmedTribe.setId(Integer.valueOf(pubmedTribeId));
		pubmedTribe = pubmedTribeBiz.modify(pubmedTribe);
		request.setAttribute("pubmedTribe", pubmedTribe);
		return mapping.findForward("adminModifyPubmedTribeOk");
	}
}
