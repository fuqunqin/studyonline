package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.QualificationTypeDao;
import cn.edu.zust.entity.QualificationType;

public class QualificationTypeDaoImpl implements QualificationTypeDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(QualificationType qualificationType) {
		ht.delete(qualificationType);

	}

	@SuppressWarnings("unchecked")
	public List<QualificationType> findAll() {
		return ht.find("from QualificationType");
	}

	public QualificationType findById(Integer id) {

		return (QualificationType) ht.get(QualificationType.class, id);
	}

	public QualificationType save(QualificationType qualificationType) {
		ht.save(qualificationType);
		return qualificationType;
	}

	public QualificationType update(QualificationType qualificationType) {
		ht.update(qualificationType);
		return qualificationType;
	}

}
