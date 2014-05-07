package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Security;

public interface SecurityBiz {
	public List<Security> query();

	public Security add(Security security);
}
