package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.WinBiz;
import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.dao.WinDao;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;

public class WinBizImpl implements WinBiz {
	private WinDao winDao;
	private SubjectDao subjectDao;

	public WinDao getWinDao() {
		return winDao;
	}

	public void setWinDao(WinDao winDao) {
		this.winDao = winDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public void delete(List<Win> wins) {
		for (Win win : wins) {
			winDao.delete(win);
		}
	}

	public Win modify(Win win) {
		Subject subject = subjectDao.findById(win.getSubject().getId());
		win.setSubject(subject);
		return winDao.update(win);
	}

	public Win query(Integer id) {
		return winDao.findById(id);
	}

	public List<Win> query(Page page) {
		return winDao.findAll(page);
	}

	public Win add(Win win) {
		Subject subject = subjectDao.findById(win.getSubject().getId());
		win.setSubject(subject);
		return winDao.save(win);
	}

}
