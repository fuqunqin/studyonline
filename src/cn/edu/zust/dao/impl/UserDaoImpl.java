package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.UserDao;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(User user) {
		ht.delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from
		// User").get(0);
		Integer count = (Integer) ht.find("select count(*) from User").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<User>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from User as u order by u.loginName,u.status");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public User findById(Integer id) {

		return (User) ht.get(User.class, id);
	}

	public User save(User user) {
		ht.save(user);
		return user;
	}

	public User update(User user) {
		ht.update(user);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> find(String hql) {
		return ht.find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<User> findNew(final int n) {
		return (List<User>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from User as u order by u.registerDate desc");
				query.setFirstResult(0);
				query.setMaxResults(n);
				return query.list();
			}

		});
	}
}
