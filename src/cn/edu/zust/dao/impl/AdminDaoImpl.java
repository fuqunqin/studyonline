package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.AdminDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.util.Page;

public class AdminDaoImpl implements AdminDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Admin admin) {
		ht.delete(admin);
	}

	@SuppressWarnings("unchecked")
	public List<Admin> findAll(final Page page) {
		// Integer count = (Integer) ht.find(
		// "select count(*) from Admin as a where a.id>-1").get(0);
		Integer count = (Integer) ht.find(
				"select count(*) from Admin as a where a.id>-1").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<Admin>) ht.execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session
						.createQuery("from Admin as a where a.id>-1 order by a.loginName,a.status");
				q.setFirstResult(page.getFirstResult());
				q.setMaxResults(page.getPageSize());
				return q.list();
			}

		});
	}

	public Admin findById(Integer id) {
		return (Admin) ht.get(Admin.class, id);
	}

	public Admin save(Admin admin) {
		ht.save(admin);
		return admin;
	}

	public Admin update(Admin admin) {
		ht.update(admin);
		return admin;
	}

	@SuppressWarnings("unchecked")
	public Admin findByLoginName(String loginName) {
		List<Admin> admins = ht.find("from Admin a where a.loginName=?",
				loginName);
		if (admins != null && admins.size() == 1) {
			return admins.get(0);
		} else
			return null;
	}
	// select * from s_admin where loginName='haha';

}
