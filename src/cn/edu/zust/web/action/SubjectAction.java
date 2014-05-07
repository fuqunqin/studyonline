package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.SubjectBiz;
import cn.edu.zust.entity.Subject;

public class SubjectAction extends MappingDispatchAction {
	private SubjectBiz subjectBiz;

	public SubjectBiz getSubjectBiz() {
		return subjectBiz;
	}

	public void setSubjectBiz(SubjectBiz subjectBiz) {
		this.subjectBiz = subjectBiz;
	}

	// 查询所有学科
	public ActionForward adminQuerySubjects(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Subject> subjects = subjectBiz.query();
		request.setAttribute("subjects", subjects);
		return mapping.findForward("adminQuerySubjectsOk");
	}

	// 添加学科
	public ActionForward adminAddSubject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String subjectName = request.getParameter("subjectName");
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject = subjectBiz.add(subject);
		return mapping.findForward("adminAddSubjectOk");
	}
}
