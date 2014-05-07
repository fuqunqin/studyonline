package cn.edu.zust.web.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.InterestGroupBiz;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.Status;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public class InterestGroupAction extends MappingDispatchAction {
	private InterestGroupBiz interestGroupBiz;

	public InterestGroupBiz getInterestGroupBiz() {
		return interestGroupBiz;
	}

	public void setInterestGroupBiz(InterestGroupBiz interestGroupBiz) {
		this.interestGroupBiz = interestGroupBiz;
	}

	public ActionForward adminQueryInterestGroups(ActionMapping mapping,
			ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Page page = new Page();
		page.setPageSize(20);
		String pageIndex = request.getParameter("pageIndex");
		if (pageIndex == null || pageIndex == "") {
			page.setPageIndex(1);
		} else {
			page.setPageIndex(Integer.parseInt(pageIndex));
		}
		List<InterestGroup> interestGroups = interestGroupBiz.query(page);
		HttpSession session = request.getSession();
		session.setAttribute("interestGroups", interestGroups);
		session.setAttribute("page", page);
		return mapping.findForward("success");
	}

	public ActionForward adminQueryInterestGroup(ActionMapping mapping,
			ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		InterestGroup ig = interestGroupBiz.query(Integer.valueOf(idStr));
		request.getSession().setAttribute("interestGroup", ig);
		return mapping.findForward("success");
	}

	public ActionForward adminModifyInterestGroup(ActionMapping mapping,
			ActionForm from, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		InterestGroup ig = (InterestGroup) session
				.getAttribute("interestGroup");
		String groupName = request.getParameter("groupName");
		ig.setGroupName(groupName);
		String groupNotice = request.getParameter("groupNotice");
		ig.setGroupNotice(groupNotice);
		Status status = new Status();
		String statusId = request.getParameter("status");
		status.setId(Integer.valueOf(statusId));
		ig.setStatus(status);
		ig = interestGroupBiz.modify(ig);
		session.setAttribute("interestGroup", ig);
		return mapping.findForward("success");
	}

	public ActionForward adminDeleteInterestGroup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] interestGroupsId = request
				.getParameterValues("interestGroupId");
		if (interestGroupsId != null && interestGroupsId.length > 0) {
			List<InterestGroup> igs = new ArrayList<InterestGroup>();
			for (String igId : interestGroupsId) {
				Integer id = Integer.valueOf(igId);
				InterestGroup ig = new InterestGroup();
				ig.setId(id);
				igs.add(ig);
			}
			interestGroupBiz.remove(igs);
		}
		return mapping.findForward("success");
	}

	public ActionForward adminRemoveGroupUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		InterestGroup ig = (InterestGroup) session
				.getAttribute("userInterestGroup");
		String userId = request.getParameter("userId");
		User user = new User();
		user.setId(Integer.valueOf(userId));
		ig.getUsers().remove(user);
		for (User u : ig.getUsers()) {
			System.out.println(u.getId() + u.getLoginName());
		}
		interestGroupBiz.removeUser(ig, user, admin);
		PrintWriter pw = response.getWriter();
		pw.println("true");
		return null;
	}

	public ActionForward saveInterestGroup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		InterestGroup interestGroup = new InterestGroup();
		interestGroup.setGroupDate(new Date());
		interestGroup.setGroupName(request.getParameter("groupName"));
		interestGroup.setGroupNotice(request.getParameter("groupNotice"));
		Status status = new Status();
		status.setId(-1);
		interestGroup.setStatus(status);
		interestGroup.setUser(user);
		Set<User> users = new HashSet<User>();
		users.add(user);
		interestGroup.setUsers(users);
		interestGroupBiz.add(interestGroup);
		return mapping.findForward("success");
	}

	public ActionForward querySelfGroups(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<InterestGroup> igs = interestGroupBiz.query(user);
		session.setAttribute("userInterestGroups", igs);
		return mapping.findForward("success");
	}

	public ActionForward queryGroupUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String idStr = request.getParameter("id");
		InterestGroup ig = interestGroupBiz.query(Integer.valueOf(idStr));
		HttpSession session = request.getSession();
		session.setAttribute("userInterestGroup", ig);
		return mapping.findForward("success");
	}

	public ActionForward modifyGroupUsers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		InterestGroup interestGroup = (InterestGroup) session
				.getAttribute("userInterestGroup");
		interestGroup.setGroupName(request.getParameter("groupName"));
		interestGroup.setGroupNotice(request.getParameter("groupNotice"));
		interestGroupBiz.modify(interestGroup);
		return mapping.findForward("success");
	}

	public ActionForward jieSanGroup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idStr = request.getParameter("id");
		InterestGroup ig = interestGroupBiz.query(Integer.valueOf(idStr));
		Status status = new Status();
		status.setId(1);
		ig.setStatus(status);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		interestGroupBiz.removeGroup(ig, admin);
		return mapping.findForward("success");
	}
}
