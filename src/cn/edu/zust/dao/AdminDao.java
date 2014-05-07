package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.util.Page;

public interface AdminDao {
	// 添加管理员
	public Admin save(Admin admin);

	// 修改管理员
	public Admin update(Admin admin);

	// 删除管理员
	public void delete(Admin admin);

	// 通过id查询管理员
	public Admin findById(Integer id);

	// 通过用户名查询管理员
	public Admin findByLoginName(String loginName);

	// 查询所有管理员
	public List<Admin> findAll(Page page);
}
