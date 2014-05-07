package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.FrontierDao;
import cn.edu.zust.entity.Frontier;
import cn.edu.zust.util.Page;

public class FrontierDaoImpl implements FrontierDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Frontier frontier) {
		ht.delete(frontier);
	}

	@SuppressWarnings("unchecked")
	public List<Frontier> findAll(final Page page) {
		// Integer count=(Integer)ht.find("select count(*) from
		// Frontier").get(0);
		Integer count = (Integer) ht.find("select count(*) from Frontier").get(0);

		long totalCount = count.longValue();
		page.setTotalCount(totalCount);

		return (List<Frontier>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from Frontier as f order by f.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public Frontier findById(Integer id) {
		return (Frontier) ht.get(Frontier.class, id);
	}

	public Frontier save(Frontier frontier) {
		ht.save(frontier);
		return frontier;
	}

	public Frontier update(Frontier frontier) {
		ht.update(frontier);
		return frontier;
	}

}
