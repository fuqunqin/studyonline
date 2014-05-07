package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.util.Page;

public interface SutraBookDao {
	public SutraBook save(SutraBook sutraBook);

	public SutraBook update(SutraBook sutraBook);

	public SutraBook findById(Integer id);

	public void delete(SutraBook sutraBook);

	public List<SutraBook> findAll(Page page);
}
