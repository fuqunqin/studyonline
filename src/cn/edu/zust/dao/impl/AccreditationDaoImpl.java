package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.AccreditationDao;
import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.util.Page;

public class AccreditationDaoImpl implements AccreditationDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Accreditation accreditation) {
		ht.delete(accreditation);
	}

	@SuppressWarnings("unchecked")
	public List<Accreditation> findAll(final Page page) {
		// Integer count = (Integer) ht.find("select count(*) from
		// Accreditation")
		// .get(0);
		Integer count = (Integer) ht.find("select count(*) from Accreditation")
		 .get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<Accreditation>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session
						.createQuery("from Accreditation as a order by a.id desc");
				q.setFirstResult(page.getFirstResult());
				q.setMaxResults(page.getPageSize());
				return q.list();
			}

		});

	}

	public Accreditation findById(Integer id) {
		return (Accreditation) ht.get(Accreditation.class, id);
	}

	public Accreditation save(Accreditation accreditation) {
		ht.save(accreditation);
		return accreditation;
	}

	public Accreditation update(Accreditation accreditation) {
		ht.update(accreditation);
		return accreditation;
	}

}
