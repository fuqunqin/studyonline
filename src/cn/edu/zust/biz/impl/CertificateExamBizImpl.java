package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.CertificateExamBiz;
import cn.edu.zust.dao.CertificateExamDao;
import cn.edu.zust.dao.QualificationTypeDao;
import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.util.Page;

public class CertificateExamBizImpl implements CertificateExamBiz {
	private CertificateExamDao ced;
	private QualificationTypeDao qtd;

	public CertificateExamDao getCed() {
		return ced;
	}

	public void setCed(CertificateExamDao ced) {
		this.ced = ced;
	}

	public QualificationTypeDao getQtd() {
		return qtd;
	}

	public void setQtd(QualificationTypeDao qtd) {
		this.qtd = qtd;
	}

	public CertificateExam add(CertificateExam ce) {
		QualificationType qt = qtd.findById(ce.getQualificationType().getId());
		ce.setQualificationType(qt);
		ce = ced.save(ce);
		return ce;
	}

	public CertificateExam modify(CertificateExam ce) {
		QualificationType qt = qtd.findById(ce.getQualificationType().getId());
		ce.setQualificationType(qt);
		ce = ced.update(ce);
		return ce;
	}

	public List<CertificateExam> query(Page page) {
		return ced.findAll(page);
	}

	public CertificateExam query(Integer id) {
		return ced.findById(id);
	}

	public void remove(List<CertificateExam> ces) {
		for (CertificateExam ce : ces) {
			ced.delete(ce);
		}
	}

}
