package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.PubmedTypeBiz;
import cn.edu.zust.entity.PubmedType;
import cn.edu.zust.entity.QualificationType;

public class PubmedTypeDwr {
	private PubmedTypeBiz pubmedTypeBiz;

	public PubmedTypeBiz getPubmedTypeBiz() {
		return pubmedTypeBiz;
	}

	public void setPubmedTypeBiz(PubmedTypeBiz pubmedTypeBiz) {
		this.pubmedTypeBiz = pubmedTypeBiz;
	}


	
	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<PubmedType> list= pubmedTypeBiz.query();
		for(int i=0;i<list.size();i++){
			PubmedType qua = list.get(i);
			map.put(qua.getId(), qua.getTypeName());
		}
		return map;
	}
}
