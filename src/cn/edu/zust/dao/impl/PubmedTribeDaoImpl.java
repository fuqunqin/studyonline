package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.PubmedTribeDao;
import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.util.Page;

public class PubmedTribeDaoImpl implements PubmedTribeDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(PubmedTribe pubmedTribe) {
		ht.delete(pubmedTribe);

	}

	@SuppressWarnings("unchecked")
	public List<PubmedTribe> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from PubmedTribe")
		// .get(0);
		Integer count = (Integer) ht.find("select count(*) from PubmedTribe").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<PubmedTribe>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from PubmedTribe as pt order by pt.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public PubmedTribe findById(Integer id) {

		return (PubmedTribe) ht.get(PubmedTribe.class, id);
	}

	public PubmedTribe save(PubmedTribe pubmedTribe) {
		ht.save(pubmedTribe);
		return pubmedTribe;
	}

	public PubmedTribe update(PubmedTribe pubmedTribe) {
		ht.update(pubmedTribe);
		return pubmedTribe;
	}

}