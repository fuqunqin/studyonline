package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.PubmedType;

public interface PubmedTypeDao {
	public PubmedType save(PubmedType pubmedType);

	public PubmedType update(PubmedType pubmedType);

	public PubmedType findById(Integer id);

	public void delete(PubmedType pubmedType);

	public List<PubmedType> findAll();
}
