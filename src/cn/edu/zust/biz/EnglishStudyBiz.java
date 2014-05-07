package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.util.Page;

public interface EnglishStudyBiz {
	// 添加英语学习
	public EnglishStudy add(EnglishStudy englishStudy);

	// 修改英语学习
	public EnglishStudy modify(EnglishStudy englishStudy);

	// 删除英语学习
	public void remove(List<EnglishStudy> englishStudies);

	// 查询英语学习
	public List<EnglishStudy> query(Page page);

	// 查询单个英语学习
	public EnglishStudy query(Integer id);
}
