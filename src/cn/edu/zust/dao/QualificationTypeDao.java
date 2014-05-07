package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.QualificationType;

public interface QualificationTypeDao {
	public QualificationType save(QualificationType qualificationType);

	public QualificationType update(QualificationType qualificationType);

	public QualificationType findById(Integer id);

	public void delete(QualificationType qualificationType);

	public List<QualificationType> findAll();
}
