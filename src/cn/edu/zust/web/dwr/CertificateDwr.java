package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.CertificateBiz;
import cn.edu.zust.entity.Certificate;

public class CertificateDwr {
	private CertificateBiz certificateBiz;

	public CertificateBiz getCertificateBiz() {
		return certificateBiz;
	}

	public void setCertificateBiz(CertificateBiz certificateBiz) {
		this.certificateBiz = certificateBiz;
	}

	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<Certificate> list= certificateBiz.query();
		for(int i=0;i<list.size();i++){
			Certificate cert = list.get(i);
			map.put(cert.getId(), cert.getDescription());
		}
		return map;
	}
	
	public Map getMap() {
	    Map map = new HashMap();
	    map.put("name", "周星星");
	    map.put("hobby", "逃课");
	    return map;
	}
	
}
