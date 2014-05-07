package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.CertificateDao;
import cn.edu.zust.entity.Certificate;

public class CertificateDaoImpl implements CertificateDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Certificate certificate) {
		ht.delete(certificate);
	}

	@SuppressWarnings("unchecked")
	public List<Certificate> findAll() {
		return ht.find("from Certificate");
	}

	public Certificate findById(Integer id) {
		return (Certificate) ht.get(Certificate.class, id);
	}

	public Certificate save(Certificate certificate) {
		ht.save(certificate);
		return certificate;
	}

	public Certificate update(Certificate certificate) {
		ht.update(certificate);
		return certificate;
	}

}
