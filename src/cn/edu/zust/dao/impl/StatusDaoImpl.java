package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.StatusDao;
import cn.edu.zust.entity.Status;

public class StatusDaoImpl implements StatusDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Status status) {
		ht.delete(status);

	}

	@SuppressWarnings("unchecked")
	public List<Status> findAll() {
		return ht.find("from Status");
	}

	public Status findById(Integer id) {

		return (Status) ht.get(Status.class, id);
	}

	public Status save(Status status) {
		ht.save(status);
		return status;
	}

	public Status update(Status status) {
		ht.update(status);
		return status;
	}

}
