package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.EnglishStudyBiz;
import cn.edu.zust.dao.EnglishStudyDao;
import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.util.Page;

public class EnglishStudyBizImpl implements EnglishStudyBiz {
	private EnglishStudyDao englishStudyDao;

	public EnglishStudyDao getEnglishStudyDao() {
		return englishStudyDao;
	}

	public void setEnglishStudyDao(EnglishStudyDao englishStudyDao) {
		this.englishStudyDao = englishStudyDao;
	}

	public EnglishStudy add(EnglishStudy englishStudy) {
		return englishStudyDao.save(englishStudy);
	}

	public EnglishStudy modify(EnglishStudy englishStudy) {
		return englishStudyDao.update(englishStudy);
	}

	public List<EnglishStudy> query(Page page) {
		return englishStudyDao.findAll(page);
	}

	public EnglishStudy query(Integer id) {
		return englishStudyDao.findById(id);
	}

	public void remove(List<EnglishStudy> englishStudies) {
		for (EnglishStudy englishStudy : englishStudies) {
			englishStudyDao.delete(englishStudy);
		}
	}

}
