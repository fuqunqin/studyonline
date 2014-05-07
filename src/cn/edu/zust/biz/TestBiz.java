package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Test;
import cn.edu.zust.util.Page;

public interface TestBiz {
	// 添加资格测试
	public Test add(Test test);

	// 修改资格测试
	public Test modify(Test test);

	// 删除资格测试
	public void remove(List<Test> test);

	// 查询资格测试
	public List<Test> query(Page page);

	// 查询单个资格测试
	public Test query(Integer id);

	// 通过路径查询测试
	public Test query(String uploadeUrl);

}
