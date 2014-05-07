package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.FrontierTypeBiz;
import cn.edu.zust.entity.FrontierType;
import cn.edu.zust.entity.Security;

public class FrontierTypeDwr {
	private FrontierTypeBiz frontierTypeBiz;

	public FrontierTypeBiz getFrontierTypeBiz() {
		return frontierTypeBiz;
	}

	public void setFrontierTypeBiz(FrontierTypeBiz frontierTypeBiz) {
		this.frontierTypeBiz = frontierTypeBiz;
	}


	
	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<FrontierType> list= frontierTypeBiz.query();
		for(int i=0;i<list.size();i++){
			FrontierType security = list.get(i);
			map.put(security.getId(), security.getFrontierType());
		}
		return map;
	}
}
