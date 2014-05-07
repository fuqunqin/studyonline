package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.StatusBiz;
import cn.edu.zust.dao.StatusDao;
import cn.edu.zust.entity.Status;

public class StatusBizImpl implements StatusBiz {
	private StatusDao statusDao;

	public StatusDao getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}

	public List<Status> query() {
		return statusDao.findAll();
	}

}
