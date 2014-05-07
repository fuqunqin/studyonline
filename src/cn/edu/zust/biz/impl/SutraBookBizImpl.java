package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.SutraBookBiz;
import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.dao.SutraBookDao;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.util.Page;

public class SutraBookBizImpl implements SutraBookBiz {
	private SutraBookDao sutraBookDao;
	private SubjectDao subjectDao;

	public SutraBookDao getSutraBookDao() {
		return sutraBookDao;
	}

	public void setSutraBookDao(SutraBookDao sutraBookDao) {
		this.sutraBookDao = sutraBookDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public SutraBook add(SutraBook sutraBook) {
		Subject subject = subjectDao.findById(sutraBook.getSubject().getId());
		sutraBook.setSubject(subject);
		return sutraBookDao.save(sutraBook);
	}

	public SutraBook modify(SutraBook sutraBook) {
		Subject subject = subjectDao.findById(sutraBook.getSubject().getId());
		sutraBook.setSubject(subject);
		return sutraBookDao.update(sutraBook);
	}

	public List<SutraBook> query(Page page) {
		return sutraBookDao.findAll(page);
	}

	public SutraBook query(Integer id) {
		return sutraBookDao.findById(id);
	}

	public void remove(List<SutraBook> subtraBooks) {
		for (SutraBook sutraBook : subtraBooks) {
			sutraBookDao.delete(sutraBook);
		}
	}

}
