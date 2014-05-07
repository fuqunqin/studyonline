package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.util.Page;

public interface ExamAppreciateBiz {
	// 添加真题欣赏
	public ExamAppreciate add(ExamAppreciate ea);

	// 修改真题欣赏
	public ExamAppreciate modify(ExamAppreciate ea);

	// 删除真题欣赏
	public void remove(List<ExamAppreciate> eas);

	// 查询真题欣赏
	public List<ExamAppreciate> query(Page page);

	// 查询单个真题欣赏
	public ExamAppreciate query(Integer id);
}
