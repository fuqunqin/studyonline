package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Frontier;
import cn.edu.zust.util.Page;

public interface FrontierDao {
	public Frontier save(Frontier frontier);

	public void delete(Frontier frontier);

	public Frontier update(Frontier frontier);

	public Frontier findById(Integer id);

	public List<Frontier> findAll(Page page);
}
