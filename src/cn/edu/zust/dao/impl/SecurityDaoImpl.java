package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.SecurityDao;
import cn.edu.zust.entity.Security;

public class SecurityDaoImpl implements SecurityDao{
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Security Security) {
		ht.delete(Security);
		
	}

	@SuppressWarnings("unchecked")
	public List<Security> findAll() {
	
		return ht.find("from Security");
	}

	public Security findById(Integer id) {
		
		return(Security) ht.get(Security.class, id);
	}

	public Security save(Security Security) {
		ht.save(Security);
		return Security;
	}

	public Security update(Security Security) {
		ht.update(Security);
		return Security;
	}
	
	

}
