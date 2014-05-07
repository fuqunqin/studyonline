package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.FrontierType;

public interface FrontierTypeDao {
	public FrontierType save(FrontierType frontierType);

	public List<FrontierType> findAll();

	public FrontierType update(FrontierType frontierType);

	public FrontierType findById(Integer id);

	public void delete(FrontierType frontierType);
}
