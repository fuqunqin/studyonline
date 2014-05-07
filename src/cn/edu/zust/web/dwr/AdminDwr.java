package cn.edu.zust.web.dwr;

import cn.edu.zust.biz.AdminBiz;
import cn.edu.zust.entity.Admin;

public class AdminDwr {
	private AdminBiz adminBiz;

	public AdminBiz getAdminBiz() {
		return adminBiz;
	}

	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}

	public boolean query(String loginName) {
		Admin admin = adminBiz.query(loginName);
		if (admin == null)
			return false;
		else
			return true;
	}
}
