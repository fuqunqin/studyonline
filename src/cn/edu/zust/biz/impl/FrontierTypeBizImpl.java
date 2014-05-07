package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.FrontierTypeBiz;
import cn.edu.zust.dao.FrontierTypeDao;
import cn.edu.zust.entity.FrontierType;

public class FrontierTypeBizImpl implements FrontierTypeBiz {
	private FrontierTypeDao frontierTypeDao;

	public FrontierTypeDao getFrontierTypeDao() {
		return frontierTypeDao;
	}

	public void setFrontierTypeDao(FrontierTypeDao frontierTypeDao) {
		this.frontierTypeDao = frontierTypeDao;
	}

	public FrontierType addFrontierType(FrontierType frontierType) {
		return frontierTypeDao.save(frontierType);
	}

	public List<FrontierType> query() {
		return frontierTypeDao.findAll();
	}

}
