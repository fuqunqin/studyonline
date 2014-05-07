package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.FrontierBiz;
import cn.edu.zust.dao.FrontierDao;
import cn.edu.zust.dao.FrontierTypeDao;
import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.entity.Frontier;
import cn.edu.zust.entity.FrontierType;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.util.Page;

public class FrontierBizImpl implements FrontierBiz {
	private FrontierDao frontierDao;
	private SubjectDao subjectDao;
	private FrontierTypeDao frontierTypeDao;

	public FrontierDao getFrontierDao() {
		return frontierDao;
	}

	public void setFrontierDao(FrontierDao frontierDao) {
		this.frontierDao = frontierDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public FrontierTypeDao getFrontierTypeDao() {
		return frontierTypeDao;
	}

	public void setFrontierTypeDao(FrontierTypeDao frontierTypeDao) {
		this.frontierTypeDao = frontierTypeDao;
	}

	public Frontier add(Frontier frontier) {
		Subject subject = subjectDao.findById(frontier.getSubject().getId());
		FrontierType frontierType = frontierTypeDao.findById(frontier
				.getFrontierType().getId());
		frontier.setSubject(subject);
		frontier.setFrontierType(frontierType);
		return frontierDao.save(frontier);
	}

	public List<Frontier> query(Page page) {
		return frontierDao.findAll(page);
	}

	public Frontier query(Integer id) {
		return frontierDao.findById(id);
	}

	public void delete(Frontier frontier) {
		frontierDao.delete(frontier);
	}

	public Frontier modify(Frontier frontier) {
		Subject subject = subjectDao.findById(frontier.getSubject().getId());
		FrontierType frontierType = frontierTypeDao.findById(frontier
				.getFrontierType().getId());
		frontier.setSubject(subject);
		frontier.setFrontierType(frontierType);
		return frontierDao.update(frontier);
	}

}
