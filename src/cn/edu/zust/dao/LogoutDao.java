package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Logout;
import cn.edu.zust.util.Page;

public interface LogoutDao {
	public Logout save(Logout logout);

	public Logout update(Logout logout);

	public void delete(Logout logout);

	public Logout findById(Integer id);

	public List<Logout> findAll(Page page);
}
