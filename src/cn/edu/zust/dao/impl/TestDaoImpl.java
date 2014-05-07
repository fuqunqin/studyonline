package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.TestDao;
import cn.edu.zust.entity.Test;
import cn.edu.zust.util.Page;

public class TestDaoImpl implements TestDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Test test) {
		ht.delete(test);
	}

	@SuppressWarnings("unchecked")
	public List<Test> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from
		// Test").get(0);
		Integer count = (Integer) ht.find("select count(*) from Test").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<Test>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from Test as t order by t.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public Test findById(Integer id) {
		return (Test) ht.get(Test.class, id);
	}

	public Test save(Test test) {
		ht.save(test);
		return test;
	}

	public Test update(Test test) {
		ht.update(test);
		return test;
	}

	@SuppressWarnings("unchecked")
	public Test find(String uploadeUrl) {
		List<Test> tests = ht.find("from Test as t where t.uploadeUrl=?",
				uploadeUrl);
		if (tests != null && tests.size() > 0) {
			return tests.get(0);
		} else
			return null;
	}

}
