package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Security;

public interface SecurityDao {
	public Security save(Security Secrutiy);

	public Security update(Security Security);

	public void delete(Security Security);

	public Security findById(Integer id);

	public List<Security> findAll();
}
