package cn.edu.zust.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.CertificateExamDao;
import cn.edu.zust.entity.CertificateExam;
import cn.edu.zust.util.Page;

public class CertificateExamDaoImpl implements CertificateExamDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(CertificateExam certificateExam) {
		ht.delete(certificateExam);
	}

	@SuppressWarnings("unchecked")
	public List<CertificateExam> findAll(final Page page) {
		// Integer count = (Integer) ht.find(
		// "select count(*) from CertificateExam").get(0);
		Integer count = (Integer) ht.find("select count(*) from CertificateExam")
		 .get(0);
		long totalCount = count.longValue();
		page.setTotalCount(totalCount);
		return (List<CertificateExam>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("from CertificateExam as ce order by ce.id desc");
				query.setFirstResult(page.getFirstResult());
				query.setMaxResults(page.getPageSize());
				return query.list();
			}

		});
	}

	public CertificateExam findById(Integer id) {
		return (CertificateExam) ht.get(CertificateExam.class, id);
	}

	public CertificateExam save(CertificateExam certificateExam) {
		ht.save(certificateExam);
		return certificateExam;
	}

	public CertificateExam update(CertificateExam certificateExam) {
		ht.update(certificateExam);
		return certificateExam;
	}

}
