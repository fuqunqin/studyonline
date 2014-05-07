package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.SecurityBiz;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.Security;

public class SecurityDwr {
	private SecurityBiz securityBiz;

	public SecurityBiz getSecurityBiz() {
		return securityBiz;
	}

	public void setSecurityBiz(SecurityBiz securityBiz) {
		this.securityBiz = securityBiz;
	}

	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<Security> list= securityBiz.query();
		for(int i=0;i<list.size();i++){
			Security security = list.get(i);
			map.put(security.getId(), security.getDescription());
		}
		return map;
	}
}
