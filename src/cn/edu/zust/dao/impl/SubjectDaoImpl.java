package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.entity.Subject;

public class SubjectDaoImpl implements SubjectDao {

	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Subject subject) {
		ht.delete(subject);

	}

	@SuppressWarnings("unchecked")
	public List<Subject> findAll() {

		return ht.find("from Subject");
	}

	public Subject findById(Integer id) {

		return (Subject) ht.get(Subject.class, id);
	}

	public Subject save(Subject subject) {
		ht.save(subject);
		return subject;
	}

	public Subject update(Subject subject) {
		ht.update(subject);
		return subject;
	}

}
