package cn.edu.zust.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.CertificateBiz;
import cn.edu.zust.biz.SecurityBiz;
import cn.edu.zust.biz.UserBiz;
import cn.edu.zust.biz.UserMessageBiz;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.Security;
import cn.edu.zust.entity.Status;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;
import cn.edu.zust.util.MD5Secrity;
import cn.edu.zust.util.Page;

public class UserAction extends MappingDispatchAction {
	private UserBiz userBiz;
	private CertificateBiz certificateBiz;
	private SecurityBiz securityBiz;
	private UserMessageBiz userMessageBiz;

	public UserMessageBiz getUserMessageBiz() {
		return userMessageBiz;
	}

	public void setUserMessageBiz(UserMessageBiz userMessageBiz) {
		this.userMessageBiz = userMessageBiz;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public CertificateBiz getCertificateBiz() {
		return certificateBiz;
	}

	public SecurityBiz getSecurityBiz() {
		return securityBiz;
	}

	public void setSecurityBiz(SecurityBiz securityBiz) {
		this.securityBiz = securityBiz;
	}

	public void setCertificateBiz(CertificateBiz certificateBiz) {
		this.certificateBiz = certificateBiz;
	}

	public ActionForward adminQueryUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<User> users = userBiz.query(page);
		request.setAttribute("users", users);
		request.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		User user = userBiz.query(id);
		List<Certificate> certificates = certificateBiz.query();
		request.setAttribute("certificates", certificates);
		List<Security> securities = securityBiz.query();
		request.setAttribute("securities", securities);
		request.getSession().setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String email = request.getParameter("email");
		user.setEmail(email);
		String certificateId = request.getParameter("certificate");
		Certificate certificate = new Certificate();
		certificate.setId(Integer.valueOf(certificateId));
		user.setCertificate(certificate);
		String certificateNumber = request.getParameter("certificateNumber");
		user.setCertificateNumber(certificateNumber);
		Admin admin = (Admin) session.getAttribute("admin");
		String loginPassword = request.getParameter("loginPassword");
		if (!admin.getLoginPassword().equals(loginPassword)) {
			user.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		}
		user = userBiz.modify(user, admin);
		session.setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyUserBase(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String email = request.getParameter("email");
		user.setEmail(email);
		String certificateId = request.getParameter("certificate");
		Certificate certificate = new Certificate();
		certificate.setId(Integer.valueOf(certificateId));
		user.setCertificate(certificate);
		String certificateNumber = request.getParameter("certificateNumber");
		user.setCertificateNumber(certificateNumber);
		session.setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward adminActiveUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<User> users = new ArrayList<User>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				User user = new User();
				user.setId(id);
				users.add(user);
			}
			userBiz.updateUserStatus(users, -1);
		}
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String[] idsStr = request.getParameterValues("ids");
		if (idsStr != null && idsStr.length > 0) {
			List<User> users = new ArrayList<User>();
			for (String idStr : idsStr) {
				Integer id = Integer.valueOf(idStr);
				User user = new User();
				user.setId(id);
				users.add(user);
			}
			userBiz.updateUserStatus(users, 1);
		}
		return mapping.findForward("success");
	}

	public ActionForward adminHignQueryUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		User user = new User();
		String loginName = request.getParameter("loginName");
		user.setLoginName(loginName);
		String email = request.getParameter("email");
		user.setEmail(email);
		String statusId = request.getParameter("statusId");
		Status status = new Status();
		status.setId(Integer.valueOf(statusId));
		user.setStatus(status);
		Certificate certificate = new Certificate();
		certificate.setId(Integer.valueOf(request.getParameter("certificate")));
		user.setCertificate(certificate);
		user.setCertificateNumber(request.getParameter("certificateNumber"));
		List<User> users = userBiz.query(user);
		request.setAttribute("users", users);
		return mapping.findForward("success");
	}

	public ActionForward adminAddUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = new User();
		String loginName = request.getParameter("loginName");
		user.setLoginName(loginName);
		String loginPassword = request.getParameter("loginPassword");
		user.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		Certificate certificate = new Certificate();
		String certificateId = request.getParameter("certificate");
		certificate.setId(Integer.valueOf(certificateId));
		user.setCertificate(certificate);
		String certificateNumber = request.getParameter("certificateNumber");
		user.setCertificateNumber(certificateNumber);
		Security security = new Security();
		String securityId = request.getParameter("security");
		security.setId(Integer.valueOf(securityId));
		user.setSecurity(security);
		String securityAnswer = request.getParameter("securityAnswer");
		user.setSecurityAnswer(securityAnswer);
		String email = request.getParameter("email");
		user.setEmail(email);
		user.setRegisterDate(new Date());
		user = userBiz.add(user);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return mapping.findForward("success");
	}

	public ActionForward userLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String validateImg = request.getParameter("validateImg");
		HttpSession session = request.getSession();
		session.removeAttribute("loginWrong");
		String rand = (String) session.getAttribute("rand");
		Integer times = (Integer) session.getAttribute("times");
		if (times == null) {
			times = 0;
		}
		if (!rand.equals(validateImg)) {
			session.setAttribute("loginWrong", "*验证码错误");
			return mapping.findForward("success");
		}
		User user = new User();
		String loginName = request.getParameter("loginName");
		user.setLoginName(loginName);
		String loginPassword = request.getParameter("loginPassword");
		user.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		user = userBiz.login(user);
		if (user == null) {
			System.out.println(times + "+++++++++Test");
			times++;
			session.setAttribute("times", times);
			if (times == 3) {
				System.out.println(times + "+++++++++Test2");
				User u = userBiz.query(loginName);
				if (u != null) {
					UserMessage userMessage = new UserMessage();
					userMessage.setDeleteFlag("-1");
					userMessage.setPublishDate(new Date());
					userMessage.setReadFlag("-1");

					userMessage.setUser(u);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
					userMessage.setMessage("您在" + sdf.format(new Date())
							+ "点登陆失败次数过多，在线网络学习平台管理员提醒您，请注意保管好自己的用户名和密码!");
					userMessageBiz.addUserMessage(userMessage);
				}
				times = 0;
			}
			session.setAttribute("loginWrong", "*用户名或密码错误！");
			return mapping.findForward("success");
		}
		if (user.getStatus().getId() == 1) {
			session.setAttribute("loginWrong", "*您已注销！");
			return mapping.findForward("success");
		}
		session.removeAttribute("times");

		List<UserMessage> userMessages = userMessageBiz.query(user);
		session.setAttribute("userMessages", userMessages);
		session.setAttribute("user", user);
		List<Certificate> certificates = certificateBiz.query();
		List<Security> securities = securityBiz.query();
		session.setAttribute("certificates", certificates);
		session.setAttribute("securities", securities);
		return mapping.findForward("success");
	}

	public ActionForward exit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return mapping.findForward("success");
	}

	public ActionForward userLogout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Status status = new Status();
		status.setId(1);
		user.setStatus(status);
		userBiz.modify(user, null);
		return mapping.findForward("success");
	}

	public ActionForward userExitGroup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String igId = request.getParameter("interestGroupId");
		InterestGroup ig = new InterestGroup();
		ig.setId(Integer.valueOf(igId));
		user.removeInterestGroup(ig);
		user = userBiz.modify(user, null);
		return mapping.findForward("success");
	}

	@SuppressWarnings("unchecked")
	public ActionForward markUserMessage(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Integer id = Integer.valueOf(idStr);
		List<UserMessage> userMessages = (List<UserMessage>) session
				.getAttribute("userMessages");
		UserMessage userMessage = null;
		for (UserMessage um : userMessages) {
			if (um.getId().equals(id)) {
				userMessage = um;
				userMessages.remove(um);
				break;
			}
		}
		if (userMessage != null) {
			userMessage.setReadFlag("1");
			userMessageBiz.modify(userMessage);
		}

		session.setAttribute("userMessages", userMessages);
		return mapping.findForward("success");
	}

	public ActionForward modifySelf(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modifyFlag = request.getParameter("modifyFlag");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (modifyFlag.equals("email")) {
			String email = request.getParameter("email");
			user.setEmail(email);
		}
		if (modifyFlag.equals("certificate")) {
			String certificateId = request.getParameter("certificate");
			Certificate certificate = new Certificate();
			certificate.setId(Integer.valueOf(certificateId));
			user.setCertificate(certificate);
			String certificateNumber = request
					.getParameter("certificateNumber");
			user.setCertificateNumber(certificateNumber);
		}
		if (modifyFlag.equals("security")) {
			String security = request.getParameter("security");
			Security s = new Security();
			s.setId(Integer.valueOf(security));
			user.setSecurity(s);
			String securityAnswer = request.getParameter("securityAnswer");
			user.setSecurityAnswer(securityAnswer);
		}
		if (modifyFlag.equals("loginPassword")) {
			String loginPassword = request.getParameter("loginPassword");
			user.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		}
		user = userBiz.modify(user, null);
		session.setAttribute("user", user);
		session.setAttribute("returnUrl", "/user/selfMessage.jsp");
		return mapping.findForward("success");
	}

	/**
	 * 下载
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward userDownLoad(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String filepath = request.getParameter("downUrl");
		String dir = request.getSession().getServletContext().getRealPath(
				File.separator + "share");
		filepath = dir + File.separator + filepath;
		File f = new File(filepath);
		FileInputStream in = new FileInputStream(filepath);
		OutputStream fos = response.getOutputStream();
		response.setHeader("Content-disposition", "attachment;filename="
				+ f.getName());
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

	public ActionForward jiaRuGroup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Set<InterestGroup> igs = user.getInterestGroups();
		PrintWriter pw = response.getWriter();
		boolean b = false;
		for (InterestGroup interestGroup : igs) {
			if (interestGroup.getId().equals(Integer.valueOf(id))) {
				b = true;
				break;
			}
		}
		if (b == true) {
			pw.println("您已经加入了该小组，请直接进入小组讨论");
		} else {
			InterestGroup ig = new InterestGroup();
			ig.setId(Integer.valueOf(id));
			user.addInterestGroup(ig);
			userBiz.modify(user, null);
			pw.println("恭喜您，加入小组成功！");
		}
		pw.close();
		return null;
	}
}