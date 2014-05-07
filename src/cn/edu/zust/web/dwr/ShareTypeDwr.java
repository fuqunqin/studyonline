package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.ShareTypeBiz;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.ShareType;

public class ShareTypeDwr {
	private ShareTypeBiz shareTypeBiz;

	public ShareTypeBiz getShareTypeBiz() {
		return shareTypeBiz;
	}

	public void setShareTypeBiz(ShareTypeBiz shareTypeBiz) {
		this.shareTypeBiz = shareTypeBiz;
	}


	
	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<ShareType> list= shareTypeBiz.query();
		for(int i=0;i<list.size();i++){
			ShareType cert = list.get(i);
			map.put(cert.getId(), cert.getTypeName());
		}
		return map;
	}
	
}
