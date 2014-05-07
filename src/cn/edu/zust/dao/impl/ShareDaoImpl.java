package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.ShareDao;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public class ShareDaoImpl implements ShareDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Share share) {
		ht.delete(share);

	}

	@SuppressWarnings("unchecked")
	public List<Share> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from
		// Share").get(0);
		Integer count = (Integer) ht.find("select count(*) from Share").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<Share>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from Share as s order by s.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public Share findById(Integer id) {

		return (Share) ht.get(Share.class, id);
	}

	public Share save(Share share) {
		ht.save(share);
		return share;
	}

	public Share update(Share share) {
		ht.update(share);
		return share;
	}

	@SuppressWarnings("unchecked")
	public Share findByShareUrl(String shareUrl) {
		String hql = "from Share as s where s.shareUrl=?";
		List<Share> shares = ht.find(hql, shareUrl);
		if (shares != null && shares.size() > 0) {
			return shares.get(0);
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Share> findByUser(User user) {
		String hql = "from Share as s where s.user=?";
		List<Share> shares = ht.find(hql, user);
		return shares;
	}

}
