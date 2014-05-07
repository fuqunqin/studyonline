package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface UserBiz {
	// 添加用户
	public User add(User user);

	// 修改用户
	public User modify(User user, Admin admin);

	// 修改用户状态
	public void updateUserStatus(List<User> users, Integer statusId);

	// 查询用户
	public List<User> query(Page page);

	// 查询单个用户
	public User query(Integer id);

	// 模糊查询
	public List<User> query(User user);

	// 通过用户名查询用户
	public User query(String loginName);

	public User login(User user);

	// 查询最新的几个用户
	public List<User> queryNew(int n);
}
