package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.util.Page;

public interface ExamAppreciateDao {
	public ExamAppreciate save(ExamAppreciate examAppreciate);

	public ExamAppreciate update(ExamAppreciate examAppreciate);

	public void delete(ExamAppreciate examAppreciate);

	public ExamAppreciate findById(Integer id);

	public List<ExamAppreciate> findAll(Page page);
}
