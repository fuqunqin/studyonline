package cn.edu.zust.web.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.upload.FormFile;

import cn.edu.zust.biz.OnlineListeningBiz;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.LoadFile;
import cn.edu.zust.util.Page;
import cn.edu.zust.web.form.UpLoadFileForm;

public class OnlineListeningAction extends MappingDispatchAction {
	private OnlineListeningBiz onlineListeningBiz;

	public OnlineListeningBiz getOnlineListengBiz() {
		return onlineListeningBiz;
	}

	public void setOnlineListengBiz(OnlineListeningBiz onlineListengBiz) {
		this.onlineListeningBiz = onlineListengBiz;
	}

	public ActionForward adminQueryOnlineListenings(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<OnlineListening> onlineListenings = onlineListeningBiz.query(page);
		request.setAttribute("onlineListenings", onlineListenings);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryOnlineListening(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		OnlineListening onlineListening = onlineListeningBiz.query(id);
		request.setAttribute("onlineListening", onlineListening);
		return mapping.findForward("success");
	}

	public ActionForward adminAddOnlineListening(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OnlineListening onlineListening = new OnlineListening();
		UpLoadFileForm uploadFile = (UpLoadFileForm) form;
		FormFile formFile = uploadFile.getUploadFile();
		if (formFile == null || formFile.getFileSize() > 1024 * 1024 * 100) {
			request.setAttribute("adminUpLoadFileFalse", "*文件大小超过限制");
			return mapping.findForward("adminAddOnlineListeningFalse");
		}
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "onlinelistening");
		String path = LoadFile.upload(formFile, dir);
		onlineListening.setListenUrl("/studyonline/onlinelistening/" + path);
		String title = request.getParameter("title");
		onlineListening.setTitle(title);
		onlineListening.setPublishDate(new Date());
		onlineListening = onlineListeningBiz.add(onlineListening);
		request.setAttribute("onlineListening", onlineListening);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyOnlineListening(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		OnlineListening onlineListening = new OnlineListening();
		String idStr = request.getParameter("onlineListeningId");
		onlineListening.setId(Integer.valueOf(idStr));
		String title = request.getParameter("title");
		onlineListening.setTitle(title);
		String publishDateStr = request.getParameter("publishDateStr");
		Date publishDate = DateUtil.string2Date(publishDateStr);
		onlineListening.setPublishDate(publishDate);
		String listenUrl = request.getParameter("listenUrl");
		onlineListening.setListenUrl(listenUrl);
		onlineListening = onlineListeningBiz.modify(onlineListening);
		request.setAttribute("onlineListening", onlineListening);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteOnlineListenings(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<OnlineListening> onlineListenings = new ArrayList<OnlineListening>();
			for (String idStr : idsStr) {
				OnlineListening onlineListening = new OnlineListening();
				onlineListening.setId(Integer.valueOf(idStr));
				onlineListenings.add(onlineListening);
			}
			onlineListeningBiz.remove(onlineListenings);
		}
		return mapping.findForward("success");
	}
}
