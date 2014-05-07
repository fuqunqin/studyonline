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

import cn.edu.zust.biz.WinBiz;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.Win;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class WinAction extends MappingDispatchAction {
	private WinBiz winBiz;

	public WinBiz getWinBiz() {
		return winBiz;
	}

	public void setWinBiz(WinBiz winBiz) {
		this.winBiz = winBiz;
	}

	public ActionForward adminQueryWins(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Win> wins = winBiz.query(page);
		request.setAttribute("wins", wins);
		request.setAttribute("page", page);
		return mapping.findForward("adminQueryWins");
	}

	public ActionForward adminAddWin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String winName = request.getParameter("winName");
		String winUserName = request.getParameter("winUserName");
		String winDescription = request.getParameter("winDescription");
		String winDateStr = request.getParameter("winDateStr");
		Date winDate = DateUtil.string2Date(winDateStr);
		Date publishDate = new Date();
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		Win win = new Win();
		win.setPublishDate(publishDate);
		win.setSubject(subject);
		win.setWinDate(winDate);
		win.setWinDescription(winDescription);
		win.setWinName(winName);
		win.setWinUserName(winUserName);
		win = winBiz.add(win);
		request.setAttribute("win", win);
		return mapping.findForward("adminAddWinOk");
	}

	public ActionForward adminQueryWin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		Win win = winBiz.query(id);
		request.setAttribute("win", win);
		return mapping.findForward("adminQueryWinOk");
	}

	public ActionForward adminModifyWin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("winId");
		Integer id = Integer.valueOf(idStr);
		String winName = request.getParameter("winName");
		String winUserName = request.getParameter("winUserName");
		String winDescription = request.getParameter("winDescription");
		String winDateStr = request.getParameter("winDateStr");
		Date winDate = DateUtil.string2Date(winDateStr);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		Win win = new Win();
		win.setId(id);
		win.setSubject(subject);
		win.setWinDate(winDate);
		win.setWinDescription(winDescription);
		win.setWinName(winName);
		win.setWinUserName(winUserName);
		win.setPublishDate(publishDate);
		win = winBiz.modify(win);
		request.setAttribute("win", win);
		return mapping.findForward("adminModifyWinOk");
	}

	public ActionForward adminDeleteWins(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idStrs = request.getParameterValues("ids");
		List<Win> wins = new ArrayList<Win>();
		if (idStrs != null && idStrs.length > 0) {
			for (String idStr : idStrs) {
				Integer id = Integer.valueOf(idStr);
				Win win = new Win();
				win.setId(id);
				wins.add(win);
			}
		}
		if (wins != null && wins.size() > 0) {
			winBiz.delete(wins);
		}
		return mapping.findForward("adminDeleteWinsOk");
	}
}
