package cn.edu.zust.web.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.FrontierBiz;
import cn.edu.zust.entity.Frontier;
import cn.edu.zust.entity.FrontierType;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class FrontierAction extends MappingDispatchAction {
	private FrontierBiz frontierBiz;

	public FrontierBiz getFrontierBiz() {
		return frontierBiz;
	}

	public void setFrontierBiz(FrontierBiz frontierBiz) {
		this.frontierBiz = frontierBiz;
	}

	public ActionForward adminAddFrontier(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String title = request.getParameter("title");
		Integer subjectId = Integer.valueOf(request.getParameter("subject"));
		Integer frontierTypeId = Integer.valueOf(request
				.getParameter("frontierType"));
		String content = request.getParameter("content");
		System.out.println("++++++++++++++++++");
		System.out.println(content);
		System.out.println("++++++++++++++++++");
		Subject subject = new Subject();
		subject.setId(subjectId);
		FrontierType frontierType = new FrontierType();
		frontierType.setId(frontierTypeId);
		Frontier frontier = new Frontier();
		frontier.setTitle(title);
		frontier.setSubject(subject);
		frontier.setFrontierType(frontierType);
		frontier.setContent(content);
		frontier.setPublishDate(new Date());
		frontier = frontierBiz.add(frontier);
		request.setAttribute("frontier", frontier);
		return mapping.findForward("adminAddFrontierOk");
	}

	public ActionForward adminQueryFrontieres(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Frontier> frontieres = frontierBiz.query(page);
		request.setAttribute("frontieres", frontieres);
		request.setAttribute("page", page);
		return mapping.findForward("adminQueryFrontieresOk");
	}

	public ActionForward adminQueryFrontier(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		Frontier frontier = frontierBiz.query(id);
		request.setAttribute("frontier", frontier);
		return mapping.findForward("adminQueryFrontierOk");
	}

	public ActionForward adminDeleteFrontier(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		Frontier frontier = new Frontier();
		frontier.setId(id);
		frontierBiz.delete(frontier);
		return mapping.findForward("deleteFrontierOk");
	}

	public ActionForward adminModifyFrontier(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idString = request.getParameter("id");
		Integer id = Integer.valueOf(idString);
		String title = request.getParameter("title");
		Integer subjectId = Integer.valueOf(request.getParameter("subject"));
		Integer frontierTypeId = Integer.valueOf(request
				.getParameter("frontierType"));
		String content = request.getParameter("content");
		String publishDateStr = request.getParameter("publishDate");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		FrontierType frontierType = new FrontierType();
		frontierType.setId(frontierTypeId);
		Frontier frontier = new Frontier();
		frontier.setId(id);
		frontier.setTitle(title);
		frontier.setSubject(subject);
		frontier.setFrontierType(frontierType);
		frontier.setContent(content);
		frontier.setPublishDate(publishDate);
		frontier = frontierBiz.modify(frontier);
		request.setAttribute("frontier", frontier);
		return mapping.findForward("adminModifyFrontier");
	}
}
