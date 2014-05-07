package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface InterestGroupBiz {
	// 修改兴趣小组
	public InterestGroup modify(InterestGroup interestGroup);

	// 删除兴趣小组
	public void remove(List<InterestGroup> interestGroups);

	// 添加兴趣小组
	public InterestGroup add(InterestGroup interestGroups);

	// 查询兴趣小组
	public List<InterestGroup> query(Page page);

	// 查询单个兴趣小组
	public InterestGroup query(Integer id);

	// 通过用户查询自己的兴趣小组
	public List<InterestGroup> query(User user);

	// 通过用户修改自己的兴趣小组
	public InterestGroup modifyByUser(InterestGroup interestGroup);

	// 用户移除其中的成员
	public InterestGroup removeUser(InterestGroup ig, User user, Admin admin);

	// 移除小组
	public void removeGroup(InterestGroup ig, Admin admin);
}
