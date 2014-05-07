package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.QualificationType;

public interface QualificationTypeBiz {
	public QualificationType add(QualificationType qualificationType);

	public List<QualificationType> query();
}
