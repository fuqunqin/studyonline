package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.PubmedTypeBiz;
import cn.edu.zust.dao.PubmedTypeDao;
import cn.edu.zust.entity.PubmedType;

public class PubmedTypeBizImpl implements PubmedTypeBiz {
	private PubmedTypeDao pubmedTypeDao;

	public PubmedTypeDao getPubmedTypeDao() {
		return pubmedTypeDao;
	}

	public void setPubmedTypeDao(PubmedTypeDao pubmedTypeDao) {
		this.pubmedTypeDao = pubmedTypeDao;
	}

	public PubmedType add(PubmedType pubmedType) {
		return pubmedTypeDao.save(pubmedType);
	}

	public List<PubmedType> query() {
		return pubmedTypeDao.findAll();
	}

}
