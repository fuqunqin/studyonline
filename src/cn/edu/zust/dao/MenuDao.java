package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Menu;

public interface MenuDao {
	public Menu save(Menu menu);

	public Menu update(Menu menu);

	public void delete(Menu menu);

	public List<Menu> findAll();

	public Menu findById(Integer id);

	public List<Menu> findSunMenues(Integer parentId);
}
