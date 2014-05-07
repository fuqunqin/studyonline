package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.CertificateBiz;
import cn.edu.zust.dao.CertificateDao;
import cn.edu.zust.entity.Certificate;

public class CertificateBizImpl implements CertificateBiz {
	private CertificateDao certificateDao;

	public CertificateDao getCertificateDao() {
		return certificateDao;
	}

	public void setCertificateDao(CertificateDao certificateDao) {
		this.certificateDao = certificateDao;
	}

	public List<Certificate> query() {
		return certificateDao.findAll();
	}

	public Certificate add(Certificate certificate) {
		return certificateDao.save(certificate);
	}

}
