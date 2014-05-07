package cn.edu.zust.web.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.AdminBiz;
import cn.edu.zust.biz.CertificateBiz;
import cn.edu.zust.biz.MenuBiz;
import cn.edu.zust.biz.SecurityBiz;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.Menu;
import cn.edu.zust.entity.Security;
import cn.edu.zust.entity.Status;
import cn.edu.zust.util.MD5Secrity;
import cn.edu.zust.util.Page;

public class AdminAction extends MappingDispatchAction {
	private AdminBiz adminBiz;
	private MenuBiz menuBiz;
	private CertificateBiz ceritificateBiz;
	private SecurityBiz securityBiz;

	public AdminBiz getAdminBiz() {
		return adminBiz;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public MenuBiz getMenuBiz() {
		return menuBiz;
	}

	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	public CertificateBiz getCeritificateBiz() {
		return ceritificateBiz;
	}

	public void setCeritificateBiz(CertificateBiz ceritificateBiz) {
		this.ceritificateBiz = ceritificateBiz;
	}

	public SecurityBiz getSecurityBiz() {
		return securityBiz;
	}

	public void setSecurityBiz(SecurityBiz securityBiz) {
		this.securityBiz = securityBiz;
	}

	public ActionForward adminLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String validateImg = request.getParameter("validateImg");
		HttpSession session = request.getSession();
		session.removeAttribute("loginWrong");
		String rand = (String) session.getAttribute("rand");
		if (!rand.equals(validateImg)) {
			session.setAttribute("loginWrong", "*您输入的验证码有误！");
			return mapping.findForward("validateWrong");
		}
		String loginName = request.getParameter("loginName");
		String loginPassword = request.getParameter("loginPassword");
		Admin admin = new Admin();
		admin.setLoginName(loginName);
		admin.setLoginPassword(loginPassword);
		admin = adminBiz.login(admin);
		session.setAttribute("admin", admin);
		Map<Menu, List<Menu>> menues = menuBiz.query(admin);
		// List<Menu> ms = new ArrayList<Menu>();
		// for (Menu menu : menues.keySet()) {
		// ms.add(menu);
		// }
		session.setAttribute("menues", menues);
		// session.setAttribute("ms", ms);
		session.setAttribute("certificates", ceritificateBiz.query());
		session.setAttribute("securities", securityBiz.query());
		return mapping.findForward("adminLoginOk");
	}

	public ActionForward adminExit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		String path = request.getContextPath();
		PrintWriter pw = response.getWriter();
		pw.println("<script type='text/javascript'>");
		pw.println("window.onload=function(){");
		// pw.println("window.open('" + path + "/admin/login.jsp','')");
		// pw.println("window.opener=null;");
		// pw.println("this.parent.close();");
		pw
				.println("window.parent.location.href='" + path
						+ "/adminLogin.jsp';");
		pw.println("}");
		pw.println("</script>");
		return null;
	}

	public ActionForward adminQueryAdmins(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<Admin> admins = adminBiz.query(page);
		request.setAttribute("admins", admins);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward adminQueryAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = adminBiz.query(Integer
				.valueOf(request.getParameter("id")));
		session.setAttribute("a", admin);

		Map<Menu, List<Menu>> menues = (Map<Menu, List<Menu>>) session
				.getAttribute("menues");
		Set<Menu> setMs = menues.keySet();
		Set<Menu> aMs = admin.getMenues();
		for (Menu m : aMs) {
			setMs.remove(m);
		}
		session.setAttribute("ms", setMs);
		return mapping.findForward("success");
	}

	public ActionForward adminAddAdmin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Admin admin = new Admin();
		String loginName = request.getParameter("loginName");
		admin.setLoginName(loginName);
		String loginPassword = request.getParameter("loginPassword");
		admin.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		String certificateNumber = request.getParameter("certificateNumber");
		admin.setCertificateNumber(certificateNumber);
		String securityAnswer = request.getParameter("securityAnswer");
		admin.setSecurityAnswer(securityAnswer);
		String email = request.getParameter("email");
		admin.setEmail(email);
		String telephone = request.getParameter("telephone");
		admin.setTelephone(telephone);
		String address = request.getParameter("address");
		admin.setAddress(address);
		Certificate certificate = new Certificate();
		String certificateId = request.getParameter("certificate");
		certificate.setId(Integer.valueOf(certificateId));
		admin.setCertificate(certificate);
		Security security = new Security();
		String securityId = request.getParameter("security");
		security.setId(Integer.valueOf(securityId));
		admin.setSecurity(security);

		String[] menuesId = request.getParameterValues("menuId");
		for (String menuId : menuesId) {
			Menu menu = new Menu();
			menu.setId(Integer.valueOf(menuId));
			admin.addMenu(menu);
		}
		admin = adminBiz.add(admin);
		request.setAttribute("a", admin);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("a");

		String loginPassword = request.getParameter("loginPassword");
		admin.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		String certificateNumber = request.getParameter("certificateNumber");
		admin.setCertificateNumber(certificateNumber);

		String email = request.getParameter("email");
		admin.setEmail(email);
		String telephone = request.getParameter("telephone");
		admin.setTelephone(telephone);
		String address = request.getParameter("address");
		admin.setAddress(address);
		Certificate certificate = new Certificate();
		String certificateId = request.getParameter("certificate");
		certificate.setId(Integer.valueOf(certificateId));
		admin.setCertificate(certificate);
		admin.removeAll();
		String[] menuesId = request.getParameterValues("menuId");
		for (String menuId : menuesId) {
			Menu menu = new Menu();
			menu.setId(Integer.valueOf(menuId));
			admin.addMenu(menu);
		}
		admin = adminBiz.modify(admin);
		request.setAttribute("a", admin);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("a");
		Status status = new Status();
		status.setId(1);
		admin.setStatus(status);
		admin = adminBiz.modify(admin);
		session.setAttribute("a", admin);
		return mapping.findForward("success");
	}

	public ActionForward adminActiveAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("a");
		Status status = new Status();
		status.setId(-1);
		admin.setStatus(status);
		admin = adminBiz.modify(admin);
		session.setAttribute("a", admin);
		return mapping.findForward("success");
	}

	public ActionForward adminModifySelfBase(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		String certificateNumber = request.getParameter("certificateNumber");
		admin.setCertificateNumber(certificateNumber);
		String email = request.getParameter("email");
		admin.setEmail(email);
		String telephone = request.getParameter("telephone");
		admin.setTelephone(telephone);
		String address = request.getParameter("address");
		admin.setAddress(address);
		Certificate certificate = new Certificate();
		String certificateId = request.getParameter("certificate");
		certificate.setId(Integer.valueOf(certificateId));
		admin.setCertificate(certificate);
		admin = adminBiz.modify(admin);
		session.setAttribute("admin", admin);
		return mapping.findForward("success");
	}

	public ActionForward adminModifySelfSelf(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		String firstLoginPassword = request.getParameter("firstLoginPassword");
		firstLoginPassword = MD5Secrity.data2secret(firstLoginPassword);
		if (!admin.getLoginPassword().equals(firstLoginPassword)) {
			return mapping.findForward("error");
		}
		String flag = request.getParameter("flag");
		String div = null;
		if (flag.equals("1")) {
			String loginPassword = request.getParameter("loginPassword");
			loginPassword = MD5Secrity.data2secret(loginPassword);
			admin.setLoginPassword(loginPassword);
			div = "div11";
		}
		if (flag.equals("2")) {
			Security security = new Security();
			String securityId = request.getParameter("security");
			security.setId(Integer.valueOf(securityId));
			admin.setSecurity(security);
			String securityAnswer = request.getParameter("securityAnswer");
			admin.setSecurityAnswer(securityAnswer);
			div = "div22";
		}
		admin = adminBiz.modify(admin);
		session.setAttribute("admin", admin);
		request.setAttribute("returnUrl", "/admin/selfmanager/modifySafe.jsp#"
				+ div);
		return mapping.findForward("success");
	}

	public ActionForward findPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String loginName = request.getParameter("loginName");
		String securityId = request.getParameter("security");
		String securityAnswer = request.getParameter("securityAnswer");
		Admin admin = adminBiz.query(loginName);
		if (admin != null
				&& admin.getSecurityAnswer().equals(securityAnswer)
				&& admin.getSecurity().getId().equals(
						Integer.valueOf(securityId))) {
			request.getSession().setAttribute("admin", admin);
			request.setAttribute("findFlag", "ok");
		} else {
			request.setAttribute("findError",
					"*您输入的信息有误，请查证后重新输入，如密保忘记请联系高级管理员！");
		}
		return mapping.findForward("success");
	}

	public ActionForward findPassword2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String loginPassword = request.getParameter("loginPassword");
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		admin.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		adminBiz.modify(admin);
		session.removeAttribute("admin");
		request.setAttribute("returnUrl", "/adminLogin.jsp");
		return mapping.findForward("success");
	}
}
