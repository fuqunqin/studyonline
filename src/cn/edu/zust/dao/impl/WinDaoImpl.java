package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.WinDao;
import cn.edu.zust.entity.Win;
import cn.edu.zust.util.Page;

public class WinDaoImpl implements WinDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Win win) {
		ht.delete(win);
	}

	@SuppressWarnings("unchecked")
	public List<Win> findAll(final Page page) {
		 Integer count=(Integer)ht.find("select count(*) from Win").get(0);
		//Long count = (Long) ht.find("select count(*) from Win").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<Win>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from Win as w order by w.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public Win findById(Integer id) {

		return (Win) ht.get(Win.class, id);
	}

	public Win save(Win win) {
		ht.save(win);
		return win;
	}

	public Win update(Win win) {
		ht.update(win);
		return win;
	}

}
