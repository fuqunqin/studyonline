package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.PubmedTribeBiz;
import cn.edu.zust.dao.PubmedTribeDao;
import cn.edu.zust.dao.PubmedTypeDao;
import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.entity.PubmedType;
import cn.edu.zust.util.Page;

public class PubmedTribeBizImpl implements PubmedTribeBiz {
	private PubmedTribeDao pubmedTribeDao;
	private PubmedTypeDao pubmedTypeDao;

	public PubmedTribeDao getPubmedTribeDao() {
		return pubmedTribeDao;
	}

	public void setPubmedTribeDao(PubmedTribeDao pubmedTribeDao) {
		this.pubmedTribeDao = pubmedTribeDao;
	}

	public PubmedTypeDao getPubmedTypeDao() {
		return pubmedTypeDao;
	}

	public void setPubmedTypeDao(PubmedTypeDao pubmedTypeDao) {
		this.pubmedTypeDao = pubmedTypeDao;
	}

	public PubmedTribe add(PubmedTribe pubmedTribe) {
		PubmedType pubmedType = pubmedTypeDao.findById(pubmedTribe
				.getPubmedType().getId());
		pubmedTribe.setPubmedType(pubmedType);
		return pubmedTribeDao.save(pubmedTribe);
	}

	public PubmedTribe modify(PubmedTribe pubmedTribe) {
		PubmedType pubmedType = pubmedTypeDao.findById(pubmedTribe
				.getPubmedType().getId());
		pubmedTribe.setPubmedType(pubmedType);
		return pubmedTribeDao.update(pubmedTribe);
	}

	public List<PubmedTribe> query(Page page) {
		return pubmedTribeDao.findAll(page);
	}

	public PubmedTribe query(Integer id) {
		return pubmedTribeDao.findById(id);
	}

	public void remove(List<PubmedTribe> pubmedTribes) {
		for (PubmedTribe pubmedTribe : pubmedTribes) {
			pubmedTribeDao.delete(pubmedTribe);
		}
	}

}
