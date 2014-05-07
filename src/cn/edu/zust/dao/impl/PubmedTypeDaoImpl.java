package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.PubmedTypeDao;
import cn.edu.zust.entity.PubmedType;

public class PubmedTypeDaoImpl implements PubmedTypeDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(PubmedType pubmedType) {
		ht.delete(pubmedType);
	}

	@SuppressWarnings("unchecked")
	public List<PubmedType> findAll() {
		return ht.find("from PubmedType");
	}

	public PubmedType findById(Integer id) {
		return (PubmedType) ht.get(PubmedType.class, id);
	}

	public PubmedType save(PubmedType pubmedType) {
		ht.save(pubmedType);
		return pubmedType;
	}

	public PubmedType update(PubmedType pubmedType) {
		ht.update(pubmedType);
		return pubmedType;
	}

}
