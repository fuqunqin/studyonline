package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Subject;

public interface SubjectDao {
	public Subject save(Subject subject);

	public Subject update(Subject subject);

	public void delete(Subject subject);

	public Subject findById(Integer id);

	public List<Subject> findAll();
}
