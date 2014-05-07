package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.util.Page;

public interface CertificateExamBiz {
	// 添加资格认证考试信息
	public CertificateExam add(CertificateExam ce);

	// 修改资格认证考试信息
	public CertificateExam modify(CertificateExam ce);

	// 查询资格认证
	public List<CertificateExam> query(Page page);

	// 查询单个资格认证
	public CertificateExam query(Integer id);

	// 删除资格认证
	public void remove(List<CertificateExam> ces);
}
