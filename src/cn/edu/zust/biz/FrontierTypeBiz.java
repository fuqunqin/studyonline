package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.FrontierType;

public interface FrontierTypeBiz {
	// 查询所有学科动态类型
	public List<FrontierType> query();

	// 添加所有学科动态类型
	public FrontierType addFrontierType(FrontierType frontierType);
}
