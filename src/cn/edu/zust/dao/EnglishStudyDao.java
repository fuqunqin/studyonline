package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.util.Page;

public interface EnglishStudyDao {
	public EnglishStudy save(EnglishStudy englishStudy);

	public EnglishStudy update(EnglishStudy englishStudy);

	public void delete(EnglishStudy englishStudy);

	public EnglishStudy findById(Integer id);

	public List<EnglishStudy> findAll(Page page);
}
