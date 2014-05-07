package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.AccreditationBiz;
import cn.edu.zust.dao.AccreditationDao;
import cn.edu.zust.dao.QualificationTypeDao;
import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.util.Page;

public class AccreditationBizImpl implements AccreditationBiz {
	private AccreditationDao accreditationDao;
	private QualificationTypeDao qualificationTypeDao;

	public AccreditationDao getAccreditationDao() {
		return accreditationDao;
	}

	public void setAccreditationDao(AccreditationDao accreditationDao) {
		this.accreditationDao = accreditationDao;
	}

	public QualificationTypeDao getQualificationTypeDao() {
		return qualificationTypeDao;
	}

	public void setQualificationTypeDao(
			QualificationTypeDao qualificationTypeDao) {
		this.qualificationTypeDao = qualificationTypeDao;
	}

	public Accreditation add(Accreditation accreditation) {
		QualificationType q = qualificationTypeDao.findById(accreditation
				.getQualificationType().getId());
		accreditation.setQualificationType(q);
		accreditation = accreditationDao.save(accreditation);
		return accreditation;
	}

	public Accreditation modify(Accreditation accreditation) {
		QualificationType q = qualificationTypeDao.findById(accreditation
				.getQualificationType().getId());
		accreditation.setQualificationType(q);
		accreditation = accreditationDao.update(accreditation);
		return accreditation;
	}

	public List<Accreditation> query(Page page) {
		return accreditationDao.findAll(page);
	}

	public Accreditation query(Integer id) {
		return accreditationDao.findById(id);
	}

	public void remove(List<Accreditation> accreditations) {
		for (Accreditation a : accreditations) {
			accreditationDao.delete(a);
		}
	}

}
