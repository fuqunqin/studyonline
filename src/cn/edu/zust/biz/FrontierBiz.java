package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Frontier;
import cn.edu.zust.util.Page;

public interface FrontierBiz {
	// 添加学科动态
	public Frontier add(Frontier frontier);

	// 查询学科动态
	public List<Frontier> query(Page page);

	// 查看单个学科动态
	public Frontier query(Integer id);

	// 删除学科动态
	public void delete(Frontier frontier);

	// 修改学科动态
	public Frontier modify(Frontier frontier);
}
