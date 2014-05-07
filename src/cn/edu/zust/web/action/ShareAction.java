package cn.edu.zust.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.upload.FormFile;

import cn.edu.zust.biz.ShareBiz;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.ShareType;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.LoadFile;
import cn.edu.zust.util.Page;
import cn.edu.zust.web.form.UpLoadFileForm;

public class ShareAction extends MappingDispatchAction {
	private ShareBiz shareBiz;

	public ShareBiz getShareBiz() {
		return shareBiz;
	}

	public void setShareBiz(ShareBiz shareBiz) {
		this.shareBiz = shareBiz;
	}

	public ActionForward adminQueryShares(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Share> shares = shareBiz.query(page);
		request.setAttribute("page", page);
		request.setAttribute("shares", shares);
		return mapping.findForward("adminQuerySharesOk");
	}

	public ActionForward adminQueryShare(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		Share share = shareBiz.query(id);
		session.setAttribute("share", share);
		return mapping.findForward("amdinQueryShareOk");
	}

	public ActionForward adminAddShare(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		Share share = new Share();
		// 连接地址
		UpLoadFileForm uploadFile = (UpLoadFileForm) form;
		FormFile formFile = uploadFile.getUploadFile();
		if (formFile == null || formFile.getFileSize() > 1024 * 1024 * 100) {
			session.setAttribute("adminUpLoadFileFalse", "*文件大小超过限制");
			return mapping.findForward("adminAddShareFalse");
		}
		// String shareUrl = UpLoadUtil.upLoadFile(formFile, request);
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "share");
		String path = LoadFile.upload(formFile, dir);

		share.setShareUrl(path);
		// 资料名称
		String shareName = request.getParameter("shareName");
		share.setShareName(shareName);
		// 所属学科
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		share.setSubject(subject);
		// 所属类别
		String shareTypeIdStr = request.getParameter("shareType");
		Integer shareTypeId = Integer.valueOf(shareTypeIdStr);
		ShareType shareType = new ShareType();
		shareType.setId(shareTypeId);
		share.setShareType(shareType);
		// 所属用户

		User user = (User) session.getAttribute("user");
		if (user != null) {
			share.setUser(user);
		}
		// 发布时间
		share.setShareDate(new Date());
		// 存储
		share = shareBiz.add(share);
		request.setAttribute("share", share);
		request.setAttribute("returnUrl", "/user/queryUserShares.do");
		return mapping.findForward("adminAddShareOk");
	}

	public ActionForward adminModifyShare(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Share share = new Share();
		// 资料名称
		String shareName = request.getParameter("shareName");
		share.setShareName(shareName);
		// 所属学科
		String subjectIdStr = request.getParameter("subject");
		Integer subjectId = Integer.valueOf(subjectIdStr);
		Subject subject = new Subject();
		subject.setId(subjectId);
		share.setSubject(subject);
		// 所属类别
		String shareTypeIdStr = request.getParameter("shareType");
		Integer shareTypeId = Integer.valueOf(shareTypeIdStr);
		ShareType shareType = new ShareType();
		shareType.setId(shareTypeId);
		share.setShareType(shareType);
		// 所属用户
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			share.setUser(user);
		}
		// 连接地址
		String shareUrl = request.getParameter("shareUrl");
		share.setShareUrl(shareUrl);
		// 发布时间
		String shareDateStr = request.getParameter("shareDateStr");
		share.setShareDate(DateUtil.string2Date(shareDateStr));
		// id主键
		Integer shareId = Integer.valueOf(request.getParameter("shareId"));
		share.setId(shareId);
		// 修改
		Admin admin = (Admin) session.getAttribute("admin");
		share = shareBiz.modify(share, admin);
		request.setAttribute("share", share);
		return mapping.findForward("adminModifyShareOk");
	}

	public ActionForward adminDeleteShares(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<Share> shares = new ArrayList<Share>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				Share share = new Share();
				share.setId(id);
				shares.add(share);
			}
			if (shares != null && shares.size() > 0) {
				HttpSession session = request.getSession();
				Admin admin = (Admin) session.getAttribute("admin");
				shareBiz.remove(shares, admin);
			}
		}
		return mapping.findForward("adminDeleteSharesOk");
	}

	public ActionForward adminDownLoadShare(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 如果是从服务器上取就用这个获得系统的绝对路径方法。
		String filepath = request.getParameter("shareUrl");
		System.out.println(filepath);
		// 查到相应路径
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "share");
		filepath = dir + File.separator + filepath;
		// 加上本地路径
		File f = new File(filepath);

		FileInputStream in = new FileInputStream(filepath);
		OutputStream fos = response.getOutputStream();
		// 这个就就是弹出下载对话框的关键代码
		response.setHeader("Content-disposition", "attachment;filename="
				+ f.getName());
		// 用输入流进行先读，然后用输出流去写,用的是缓冲输入输出流
		byte[] buffer = new byte[8192];
		while (true) {
			int i = in.read(buffer);
			if (i == -1)
				break;
			fos.write(buffer, 0, i);
		}
		fos.close();
		in.close();
		return null;
	}

	public ActionForward queryUserShares(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Share> shares = shareBiz.queryByUser(user);
		session.setAttribute("shares", shares);
		return mapping.findForward("success");
	}
}
