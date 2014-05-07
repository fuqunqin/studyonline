package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.CertificateBiz;
import cn.edu.zust.entity.Certificate;

public class CertificateAction extends MappingDispatchAction {
	private CertificateBiz certificateBiz;

	public CertificateBiz getCertificateBiz() {
		return certificateBiz;
	}

	public void setCertificateBiz(CertificateBiz certificateBiz) {
		this.certificateBiz = certificateBiz;
	}

	// 查询所有的证件类型
	public ActionForward adminQueryCertificates(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Certificate> certificates = certificateBiz.query();
		request.setAttribute("certificates", certificates);
		return mapping.findForward("adminQueryCertificatesOk");
	}

	// 添加证件类型
	public ActionForward adminAddCertificate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String description = request.getParameter("description");
		Certificate certificate = new Certificate();
		certificate.setDescription(description);
		certificate = certificateBiz.add(certificate);
		return mapping.findForward("adminAddCertificateOk");
	}
}
