package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.util.Page;

public interface PubmedTribeDao {
	public PubmedTribe save(PubmedTribe pubmedTribe);

	public PubmedTribe update(PubmedTribe pubmedTribe);

	public PubmedTribe findById(Integer id);

	public List<PubmedTribe> findAll(Page page);

	public void delete(PubmedTribe pubmedTribe);
}
