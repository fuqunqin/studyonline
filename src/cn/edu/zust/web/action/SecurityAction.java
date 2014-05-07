package cn.edu.zust.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.SecurityBiz;
import cn.edu.zust.entity.Security;

public class SecurityAction extends MappingDispatchAction {
	private SecurityBiz securityBiz;

	public SecurityBiz getSecurityBiz() {
		return securityBiz;
	}

	public void setSecurityBiz(SecurityBiz securityBiz) {
		this.securityBiz = securityBiz;
	}

	public ActionForward adminQuerySecurities(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Security> securities = securityBiz.query();
		request.setAttribute("securities", securities);
		return mapping.findForward("adminQuerySecuritiesOk");
	}

	public ActionForward adminAddSecurity(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String description = request.getParameter("description");
		Security security = new Security();
		security.setDescription(description);
		security = securityBiz.add(security);
		return mapping.findForward("adminAddSecurityOk");
	}
}
