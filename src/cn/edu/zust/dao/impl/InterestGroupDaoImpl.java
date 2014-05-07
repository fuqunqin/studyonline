package cn.edu.zust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.InterestGroupDao;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public class InterestGroupDaoImpl implements InterestGroupDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(InterestGroup interestGroup) {
		ht.delete(interestGroup);
	}

	@SuppressWarnings("unchecked")
	public List<InterestGroup> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from InterestGroup
		// ig where ig.status.id=-1")
		// .get(0);
		Integer count = (Integer) ht.find("select count(*) from InterestGroup")
				.get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<InterestGroup>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from InterestGroup as ig where ig.status.id=-1 order by ig.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}
		});
	}

	public InterestGroup findById(Integer id) {
		return (InterestGroup) ht.get(InterestGroup.class, id);
	}

	public InterestGroup save(InterestGroup interestGroup) {
		ht.save(interestGroup);
		return interestGroup;
	}

	public InterestGroup update(InterestGroup interestGroup) {
		ht.update(interestGroup);
		return interestGroup;
	}

	@SuppressWarnings("unchecked")
	public List<InterestGroup> findByUser(final User user) {
		try {
			List<Integer> groupIds = (List<Integer>) ht
					.execute(new HibernateCallback() {

						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Connection conn = session.connection();
							String sql = "select group_id from s_group_users where user_id=?";
							PreparedStatement ps = conn.prepareStatement(sql);
							ps.setInt(1, user.getId());
							ResultSet rs = ps.executeQuery();
							List<Integer> lists = new ArrayList<Integer>();
							while (rs.next()) {
								lists.add(rs.getInt(1));
							}
							return lists;
						}
					});
			List<InterestGroup> igs = new ArrayList<InterestGroup>();
			for (Integer igId : groupIds) {
				InterestGroup ig = this.findById(igId);
				if ("-1".equals(ig.getStatus())) {
					igs.add(ig);
				}
			}
			if (igs != null && igs.size() > 0) {
				return igs;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
