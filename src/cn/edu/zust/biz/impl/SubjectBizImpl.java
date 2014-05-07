package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.SubjectBiz;
import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.entity.Subject;

public class SubjectBizImpl implements SubjectBiz {
	private SubjectDao subjectDao;

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public Subject add(Subject subject) {
		return subjectDao.save(subject);
	}

	public List<Subject> query() {
		return subjectDao.findAll();
	}

}
