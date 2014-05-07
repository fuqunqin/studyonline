package cn.edu.zust.biz;

import java.util.List;
import java.util.Set;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Menu;
import cn.edu.zust.exception.ApplicationException;
import cn.edu.zust.util.Page;

public interface AdminBiz {
	// 用户登录
	public Admin login(Admin admin) throws ApplicationException;

	// 添加管理员
	public Admin add(Admin admin);

	// 修改管理员
	public Admin modify(Admin admin);

	public Admin modify(Admin admin, Set<Menu> ms);

	// 删除管理员
	public void remove(List<Admin> admins);

	// 查询管理员
	public List<Admin> query(Page page);

	// 查询单个管理员
	public Admin query(Integer id);

	// 通过用户名查询管理员
	public Admin query(String loginName);
}
