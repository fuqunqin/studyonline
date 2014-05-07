package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.ExamAppreciateBiz;
import cn.edu.zust.dao.ExamAppreciateDao;
import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.util.Page;

public class ExamAppreciateBizImpl implements ExamAppreciateBiz {
	private ExamAppreciateDao examAppreciateDao;

	public ExamAppreciateDao getExamAppreciateDao() {
		return examAppreciateDao;
	}

	public void setExamAppreciateDao(ExamAppreciateDao examAppreciateDao) {
		this.examAppreciateDao = examAppreciateDao;
	}

	public ExamAppreciate add(ExamAppreciate ea) {
		return examAppreciateDao.save(ea);
	}

	public ExamAppreciate modify(ExamAppreciate ea) {
		return examAppreciateDao.update(ea);
	}

	public List<ExamAppreciate> query(Page page) {
		return examAppreciateDao.findAll(page);
	}

	public ExamAppreciate query(Integer id) {
		return examAppreciateDao.findById(id);
	}

	public void remove(List<ExamAppreciate> eas) {
		for (ExamAppreciate ea : eas) {
			examAppreciateDao.delete(ea);
		}
	}

}
