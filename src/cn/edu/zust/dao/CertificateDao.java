package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Certificate;

public interface CertificateDao {

	public Certificate save(Certificate certificate);

	public Certificate update(Certificate certificate);

	public void delete(Certificate certificate);

	public Certificate findById(Integer id);

	public List<Certificate> findAll();
}
