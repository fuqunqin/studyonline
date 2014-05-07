package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface UserDao {
	public User save(User user);

	public List<User> findAll(Page page);

	public User update(User user);

	public void delete(User user);

	public User findById(Integer id);

	public List<User> find(String hql);

	public List<User> findNew(final int n);
}
