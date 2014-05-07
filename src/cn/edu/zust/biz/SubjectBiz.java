package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Subject;

public interface SubjectBiz {
	public List<Subject> query();

	public Subject add(Subject subject);
}
