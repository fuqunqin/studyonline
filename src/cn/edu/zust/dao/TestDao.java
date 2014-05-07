package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Test;
import cn.edu.zust.util.Page;

public interface TestDao {
	// 添加资格测试
	public Test save(Test test);

	// 修改资格测试
	public Test update(Test test);

	// 删除资格测试
	public void delete(Test test);

	// 查询资格测试
	public List<Test> findAll(Page page);

	// 查询单个资格测试
	public Test findById(Integer id);

	public Test find(String uploadeUrl);
}
