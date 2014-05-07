package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.ExamAppreciateDao;
import cn.edu.zust.entity.ExamAppreciate;
import cn.edu.zust.util.Page;

public class ExamAppreciateDaoImpl implements ExamAppreciateDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(ExamAppreciate examAppreciate) {
		ht.delete(examAppreciate);
	}

	@SuppressWarnings("unchecked")
	public List<ExamAppreciate> findAll(final Page page) {
		// Integer count = (Integer) ht
		// .find("select count(*) from ExamAppreciate").get(0);
		Integer count = (Integer) ht.find("select count(*) from ExamAppreciate").get(
				0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<ExamAppreciate>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from ExamAppreciate as ea order by ea.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public ExamAppreciate findById(Integer id) {
		return (ExamAppreciate) ht.get(ExamAppreciate.class, id);
	}

	public ExamAppreciate save(ExamAppreciate examAppreciate) {
		ht.save(examAppreciate);
		return examAppreciate;
	}

	public ExamAppreciate update(ExamAppreciate examAppreciate) {
		ht.update(examAppreciate);
		return examAppreciate;
	}

}
