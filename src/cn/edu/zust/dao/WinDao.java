package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;

public interface WinDao {
	public Win update(Win win);

	public void delete(Win win);

	public Win save(Win win);

	public Win findById(Integer id);

	public List<Win> findAll(Page page);
}
