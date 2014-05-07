package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;

public interface WinBiz {
	// 查询单个科研成果
	public Win query(Integer id);

	// 修改单个科研成果
	public Win modify(Win win);

	// 删除科研成果
	public void delete(List<Win> wins);

	// 查询科研成果
	public List<Win> query(Page page);

	// 添加科研成果
	public Win add(Win win);
}
