package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.OnlineListeningDao;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.util.Page;

public class OnlineListeningDaoImpl implements OnlineListeningDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(OnlineListening onlineListening) {
		ht.delete(onlineListening);
	}

	@SuppressWarnings("unchecked")
	public List<OnlineListening> findAll(final Page page) {
//		Integer count = (Integer) ht.find(
//				"select count(*) from OnlineListening").get(0);
		Integer count = (Integer) ht.find("select count(*) from OnlineListening")
				.get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<OnlineListening>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from OnlineListening as ol order by ol.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public OnlineListening findById(Integer id) {
		return (OnlineListening) ht.get(OnlineListening.class, id);
	}

	public OnlineListening save(OnlineListening onlineListening) {
		ht.save(onlineListening);
		return onlineListening;
	}

	public OnlineListening update(OnlineListening onlineListening) {
		ht.update(onlineListening);
		return onlineListening;
	}

	@SuppressWarnings("unchecked")
	public OnlineListening findByListenUrl(String listenUrl) {
		String hql = "from OnlineListening as ol where ol.listenUrl=?";
		List<OnlineListening> ols = ht.find(hql, listenUrl);
		if (ols != null && ols.size() > 0) {
			return ols.get(0);
		} else
			return null;
	}

}
