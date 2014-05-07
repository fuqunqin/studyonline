package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.SutraBookDao;
import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.util.Page;

public class SutraBookDaoImpl implements SutraBookDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(SutraBook sutraBook) {
		ht.delete(sutraBook);

	}

	@SuppressWarnings("unchecked")
	public List<SutraBook> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from SutraBook")
		//				.get(0);
		Integer count = (Integer) ht.find("select count(*) from SutraBook").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<SutraBook>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from SutraBook as sb order by sb.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public SutraBook findById(Integer id) {
		return (SutraBook) ht.get(SutraBook.class, id);
	}

	public SutraBook save(SutraBook sutraBook) {
		ht.save(sutraBook);
		return sutraBook;
	}

	public SutraBook update(SutraBook sutraBook) {
		ht.update(sutraBook);
		return sutraBook;
	}

}
