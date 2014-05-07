package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.QualificationTypeBiz;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.QualificationType;

public class QualificationTypeDwr {
	private QualificationTypeBiz qtb;

	public QualificationTypeBiz getQtb() {
		return qtb;
	}

	public void setQtb(QualificationTypeBiz qtb) {
		this.qtb = qtb;
	}

	
	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<QualificationType> list= qtb.query();
		for(int i=0;i<list.size();i++){
			QualificationType qua = list.get(i);
			map.put(qua.getId(), qua.getTypeName());
		}
		return map;
	}
}
