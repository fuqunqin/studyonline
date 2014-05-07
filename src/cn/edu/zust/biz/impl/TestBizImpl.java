package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.TestBiz;
import cn.edu.zust.dao.QualificationTypeDao;
import cn.edu.zust.dao.TestDao;
import cn.edu.zust.entity.QualificationType;
import cn.edu.zust.entity.Test;
import cn.edu.zust.util.Page;

public class TestBizImpl implements TestBiz {
	private TestDao testDao;
	private QualificationTypeDao qualificationTypeDao;

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	public QualificationTypeDao getQualificationTypeDao() {
		return qualificationTypeDao;
	}

	public void setQualificationTypeDao(
			QualificationTypeDao qualificationTypeDao) {
		this.qualificationTypeDao = qualificationTypeDao;
	}

	public Test add(Test test) {
		QualificationType qt = qualificationTypeDao.findById(test
				.getQualificationType().getId());
		test.setQualificationType(qt);
		return testDao.save(test);
	}

	public Test modify(Test test) {
		QualificationType qt = qualificationTypeDao.findById(test
				.getQualificationType().getId());
		test.setQualificationType(qt);
		return testDao.update(test);
	}

	public List<Test> query(Page page) {
		return testDao.findAll(page);
	}

	public Test query(Integer id) {
		return testDao.findById(id);
	}

	public void remove(List<Test> tests) {
		for (Test test : tests) {
			testDao.delete(test);
		}
	}

	public Test query(String uploadeUrl) {
		return testDao.find(uploadeUrl);
	}

}
