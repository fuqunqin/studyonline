package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Certificate;

public interface CertificateBiz {
	public List<Certificate> query();

	public Certificate add(Certificate certificate);
}
