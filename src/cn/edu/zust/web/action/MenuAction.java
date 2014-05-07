package cn.edu.zust.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.MenuBiz;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Menu;

public class MenuAction extends MappingDispatchAction {
	private MenuBiz menuBiz;

	public MenuBiz getMenuBiz() {
		return menuBiz;
	}

	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}

	@SuppressWarnings("unchecked")
	public ActionForward addMenue(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String menuName = request.getParameter("menuName");
		String url = request.getParameter("url");
		String parentId = request.getParameter("parentId");
		Menu menu = new Menu();
		menu.setMenuName(menuName);
		menu.setUrl(url);
		menu.setParentId(Integer.valueOf(parentId));
		menuBiz.addMenu(menu);
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		Map<Menu, List<Menu>> menues = menuBiz.query(admin);
		session.setAttribute("menues", menues);
		return null;
	}
}
