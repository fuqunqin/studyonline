package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.EnglishStudyDao;
import cn.edu.zust.entity.EnglishStudy;
import cn.edu.zust.util.Page;

public class EnglishStudyDaoImpl implements EnglishStudyDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(EnglishStudy englishStudy) {
		ht.delete(englishStudy);
	}

	@SuppressWarnings("unchecked")
	public List<EnglishStudy> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from
		// EnglishStudy")
		// .get(0);
		Integer count = (Integer) ht.find("select count(*) from EnglishStudy").get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<EnglishStudy>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from EnglishStudy as es order by es.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public EnglishStudy findById(Integer id) {
		return (EnglishStudy) ht.get(EnglishStudy.class, id);
	}

	public EnglishStudy save(EnglishStudy englishStudy) {
		ht.save(englishStudy);
		return englishStudy;
	}

	public EnglishStudy update(EnglishStudy englishStudy) {
		ht.update(englishStudy);
		return englishStudy;
	}

}
