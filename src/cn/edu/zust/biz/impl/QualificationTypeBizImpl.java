package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.QualificationTypeBiz;
import cn.edu.zust.dao.QualificationTypeDao;
import cn.edu.zust.entity.QualificationType;

public class QualificationTypeBizImpl implements QualificationTypeBiz {
	private QualificationTypeDao qualificationTypeDao;

	public QualificationTypeDao getQualificationTypeDao() {
		return qualificationTypeDao;
	}

	public void setQualificationTypeDao(
			QualificationTypeDao qualificationTypeDao) {
		this.qualificationTypeDao = qualificationTypeDao;
	}

	public QualificationType add(QualificationType qualificationType) {
		return qualificationTypeDao.save(qualificationType);
	}

	public List<QualificationType> query() {
		return qualificationTypeDao.findAll();
	}

}
