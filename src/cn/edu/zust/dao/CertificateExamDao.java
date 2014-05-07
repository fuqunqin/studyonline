package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.util.Page;

public interface CertificateExamDao {

	public CertificateExam save(CertificateExam certificateExam);

	public CertificateExam update(CertificateExam certificateExam);

	public void delete(CertificateExam certificateExam);

	public CertificateExam findById(Integer id);

	public List<CertificateExam> findAll(Page page);
}
