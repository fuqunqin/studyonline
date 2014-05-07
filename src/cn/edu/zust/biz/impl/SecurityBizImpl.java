package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.SecurityBiz;
import cn.edu.zust.dao.SecurityDao;
import cn.edu.zust.entity.Security;

public class SecurityBizImpl implements SecurityBiz {
	private SecurityDao securityDao;

	public SecurityDao getSecurityDao() {
		return securityDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

	public List<Security> query() {
		return securityDao.findAll();
	}

	public Security add(Security security) {
		securityDao.save(security);
		return security;
	}

}
