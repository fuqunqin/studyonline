package cn.edu.zust.web.dwr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import cn.edu.zust.biz.SubjectBiz;
import cn.edu.zust.entity.ShareType;
import cn.edu.zust.entity.Subject;

public class SubjectDwr {
	private SubjectBiz subjectBiz;

	public SubjectBiz getSubjectBiz() {
		return subjectBiz;
	}

	public void setSubjectBiz(SubjectBiz subjectBiz) {
		this.subjectBiz = subjectBiz;
	}


	
	public Map<Integer, String> query() {
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<Subject> list= subjectBiz.query();
		for(int i=0;i<list.size();i++){
			Subject cert = list.get(i);
			map.put(cert.getId(), cert.getSubjectName());
		}
		return map;
	}
}
