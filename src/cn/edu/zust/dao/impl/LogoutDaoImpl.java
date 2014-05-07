package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.LogoutDao;
import cn.edu.zust.entity.Logout;
import cn.edu.zust.util.Page;

public class LogoutDaoImpl implements LogoutDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Logout logout) {
		ht.delete(logout);
	}

	@SuppressWarnings("unchecked")
	public List<Logout> findAll(Page page) {
		return ht.find("from Logout");
	}

	public Logout findById(Integer id) {
		return (Logout) ht.get(Logout.class, id);
	}

	public Logout save(Logout logout) {
		ht.save(logout);
		return logout;
	}

	public Logout update(Logout logout) {
		ht.update(logout);
		return logout;
	}

}
