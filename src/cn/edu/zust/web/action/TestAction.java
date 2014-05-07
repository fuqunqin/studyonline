package cn.edu.zust.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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

import cn.edu.zust.biz.TestBiz;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.entity.Test;
import cn.edu.zust.util.DateUtil;
import cn.edu.zust.util.LoadFile;
import cn.edu.zust.util.Page;
import cn.edu.zust.web.form.UpLoadFileForm;

public class TestAction extends MappingDispatchAction {
	private TestBiz testBiz;

	public TestBiz getTestBiz() {
		return testBiz;
	}

	public void setTestBiz(TestBiz testBiz) {
		this.testBiz = testBiz;
	}

	public ActionForward adminQueryTests(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Test> tests = testBiz.query(page);
		request.setAttribute("tests", tests);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryTest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		Test test = testBiz.query(id);
		request.setAttribute("test", test);
		return mapping.findForward("success");
	}

	public ActionForward adminAddTest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Test test = new Test();
		UpLoadFileForm uploadFile = (UpLoadFileForm) form;
		FormFile formFile = uploadFile.getUploadFile();
		if (formFile == null || formFile.getFileSize() > 1024 * 1024 * 100) {
			request.setAttribute("adminUpLoadFileFalse", "*文件大小超过限制");
			return mapping.findForward("adminAddTestFalse");
		}
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "test");
		String path = LoadFile.upload(formFile, dir);
		
		test.setUploadeUrl(path);
		String title = request.getParameter("title");
		test.setTitle(title);
		String qualificateTypeIdStr = request.getParameter("qualificationType");
		Integer qualificateTypeId = Integer.valueOf(qualificateTypeIdStr);
		QualificationType qualificateType = new QualificationType();
		qualificateType.setId(qualificateTypeId);
		test.setQualificationType(qualificateType);
		test.setUploadeDate(new Date());
		test = testBiz.add(test);
		request.setAttribute("test", test);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyTest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Test test = new Test();
		String uploadeUrl = request.getParameter("uploadeUrl");
		test.setUploadeUrl(uploadeUrl);
		String testIdStr = request.getParameter("testId");
		test.setId(Integer.valueOf(testIdStr));
		String title = request.getParameter("title");
		test.setTitle(title);
		String qualificateTypeIdStr = request.getParameter("qualificationType");
		Integer qualificateTypeId = Integer.valueOf(qualificateTypeIdStr);
		QualificationType qualificateType = new QualificationType();
		qualificateType.setId(qualificateTypeId);
		test.setQualificationType(qualificateType);
		String uploadDateStr = request.getParameter("uploadeDateStr");
		Date uploadeDate = DateUtil.string2Date(uploadDateStr);
		test.setUploadeDate(uploadeDate);
		test = testBiz.modify(test);
		request.setAttribute("test", test);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteTests(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<Test> tests = new ArrayList<Test>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				Test test = new Test();
				test.setId(id);
				tests.add(test);
			}
			if (tests != null && tests.size() > 0) {
				testBiz.remove(tests);
			}
		}
		return mapping.findForward("success");
	}

	public ActionForward adminDownLoadTest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 如果是从服务器上取就用这个获得系统的绝对路径方法。
		String filepath = request.getParameter("uploadeUrl");
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "share");
		filepath = dir + File.separator + filepath;
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
}
