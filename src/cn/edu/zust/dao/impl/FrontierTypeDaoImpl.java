package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.FrontierTypeDao;
import cn.edu.zust.entity.FrontierType;

public class FrontierTypeDaoImpl implements FrontierTypeDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(FrontierType frontierType) {
		ht.delete(frontierType);
	}

	@SuppressWarnings("unchecked")
	public List<FrontierType> findAll() {
		return ht.find("from FrontierType");
	}

	public FrontierType findById(Integer id) {
		return (FrontierType) ht.get(FrontierType.class, id);
	}

	public FrontierType save(FrontierType frontierType) {
		ht.save(frontierType);
		return frontierType;
	}

	public FrontierType update(FrontierType frontierType) {
		ht.update(frontierType);
		return frontierType;
	}

}
