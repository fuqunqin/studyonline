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

import cn.edu.zust.biz.ExamAppreciateBiz;
import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class ExamAppreciateAction extends MappingDispatchAction {
	private ExamAppreciateBiz examAppreciateBiz;

	public ExamAppreciateBiz getExamAppreciateBiz() {
		return examAppreciateBiz;
	}

	public void setExamAppreciateBiz(ExamAppreciateBiz examAppreciateBiz) {
		this.examAppreciateBiz = examAppreciateBiz;
	}

	public ActionForward adminQueryExamAppreciates(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<ExamAppreciate> examAppreciates = examAppreciateBiz.query(page);
		request.setAttribute("examAppreciates", examAppreciates);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryExamAppreciate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		ExamAppreciate examAppreciate = examAppreciateBiz.query(id);
		request.setAttribute("examAppreciate", examAppreciate);
		return mapping.findForward("success");
	}

	public ActionForward adminAddExamAppreciate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ExamAppreciate examAppreciate = new ExamAppreciate();
		String title = request.getParameter("title");
		examAppreciate.setTitle(title);
		String content = request.getParameter("content");
		examAppreciate.setContent(content);
		examAppreciate.setPublishDate(new Date());
		examAppreciate = examAppreciateBiz.add(examAppreciate);
		request.setAttribute("examAppreciate", examAppreciate);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyExamAppreciate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ExamAppreciate examAppreciate = new ExamAppreciate();
		String examAppreciateIdStr = request.getParameter("examAppreciateId");
		Integer id = Integer.valueOf(examAppreciateIdStr);
		examAppreciate.setId(id);
		String title = request.getParameter("title");
		examAppreciate.setTitle(title);
		String content = request.getParameter("content");
		examAppreciate.setContent(content);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		examAppreciate.setPublishDate(publishDate);
		examAppreciate = examAppreciateBiz.modify(examAppreciate);
		request.setAttribute("examAppreciate", examAppreciate);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteExamAppreciates(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<ExamAppreciate> examAppreciates = new ArrayList<ExamAppreciate>();
			for (String idStr : idsStr) {
				ExamAppreciate examAppreciate = new ExamAppreciate();
				examAppreciate.setId(Integer.valueOf(idStr));
				examAppreciates.add(examAppreciate);
			}
			examAppreciateBiz.remove(examAppreciates);
		}
		return mapping.findForward("success");
	}
}
