package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.QualificationTypeBiz;
import cn.edu.zust.entity.QualificationType;

public class QualificationTypeAction extends MappingDispatchAction {
	private QualificationTypeBiz qualificationTypeBiz;

	public QualificationTypeBiz getQualificationTypeBiz() {
		return qualificationTypeBiz;
	}

	public void setQualificationTypeBiz(
			QualificationTypeBiz qualificationTypeBiz) {
		this.qualificationTypeBiz = qualificationTypeBiz;
	}

	public ActionForward adminQueryQualificationTypes(
			org.apache.struts.action.ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<QualificationType> qualificationTypes = qualificationTypeBiz
				.query();
		request.setAttribute("qualificationTypes", qualificationTypes);
		return mapping.findForward("adminQueryQualificationTypesOk");
	}

	public ActionForward adminAddQualificationType(
			org.apache.struts.action.ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String typeName = request.getParameter("typeName");
		QualificationType qt = new QualificationType();
		qt.setTypeName(typeName);
		qt = qualificationTypeBiz.add(qt);
		return mapping.findForward("adminAddQualificationTypeOk");
	}
}
