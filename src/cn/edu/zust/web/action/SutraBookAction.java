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

import cn.edu.zust.biz.SutraBookBiz;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.Page;

public class SutraBookAction extends MappingDispatchAction {
	private SutraBookBiz sutraBookBiz;

	public SutraBookBiz getSutraBookBiz() {
		return sutraBookBiz;
	}

	public void setSutraBookBiz(SutraBookBiz sutraBookBiz) {
		this.sutraBookBiz = sutraBookBiz;
	}

	public ActionForward adminQuerySutraBooks(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<SutraBook> sutraBooks = sutraBookBiz.query(page);
		request.setAttribute("sutraBooks", sutraBooks);
		request.setAttribute("page", page);
		return mapping.findForward("adminQuerySutraBooks");
	}

	public ActionForward adminQuerySutraBook(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		SutraBook sutraBook = sutraBookBiz.query(id);
		request.setAttribute("sutraBook", sutraBook);
		return mapping.findForward("adminQuerySutraBook");
	}

	public ActionForward adminAddSutraBook(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String bookName = request.getParameter("bookName");
		String publicCompany = request.getParameter("publicCompany");
		String bookUserName = request.getParameter("bookUserName");
		String bookSynopsis = request.getParameter("bookSynopsis");
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		String publicDateStr = request.getParameter("publicDateStr");
		Date publicDate = DateUtil.string2Date(publicDateStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		SutraBook sutraBook = new SutraBook();
		sutraBook.setBookName(bookName);
		sutraBook.setBookSynopsis(bookSynopsis);
		sutraBook.setBookUserName(bookUserName);
		sutraBook.setPublicCompany(publicCompany);
		sutraBook.setSubject(subject);
		sutraBook.setPublicDate(publicDate);
		sutraBook.setPublishDate(new Date());
		sutraBook = sutraBookBiz.add(sutraBook);
		request.setAttribute("sutraBook", sutraBook);
		return mapping.findForward("adminAddSutraBook");
	}

	public ActionForward adminModifySutraBook(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("sutraBookId");
		Integer id = Integer.valueOf(idStr);
		String bookName = request.getParameter("bookName");
		String publicCompany = request.getParameter("publicCompany");
		String bookUserName = request.getParameter("bookUserName");
		String bookSynopsis = request.getParameter("bookSynopsis");
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		String publicDateStr = request.getParameter("publicDateStr");
		Date publicDate = DateUtil.string2Date(publicDateStr);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		SutraBook sutraBook = new SutraBook();
		sutraBook.setId(id);
		sutraBook.setBookName(bookName);
		sutraBook.setBookSynopsis(bookSynopsis);
		sutraBook.setBookUserName(bookUserName);
		sutraBook.setPublicCompany(publicCompany);
		sutraBook.setSubject(subject);
		sutraBook.setPublicDate(publicDate);
		sutraBook.setPublishDate(publishDate);
		sutraBook = sutraBookBiz.modify(sutraBook);
		request.setAttribute("sutraBook", sutraBook);
		return mapping.findForward("adminModifySutraBook");
	}

	public ActionForward adminDeleteSutraBooks(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] ids = request.getParameterValues("ids");
		List<SutraBook> sutraBooks = new ArrayList<SutraBook>();
		if (ids != null && ids.length > 0) {
			for (String idStr : ids) {
				Integer id = Integer.valueOf(idStr);
				SutraBook sutraBook = new SutraBook();
				sutraBook.setId(id);
				sutraBooks.add(sutraBook);
			}
		}
		if (sutraBooks != null && sutraBooks.size() > 0) {
			sutraBookBiz.remove(sutraBooks);
		}
		return mapping.findForward("adminDeleteSutraBooks");
	}
}
