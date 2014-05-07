package cn.edu.zust.util;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class PreviousNext {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@SuppressWarnings("unchecked")
	public Integer queryPreviousData(String object, Integer id) {
		List<Object> list = ht.find("select max(id) from " + object
				+ " where id<" + id);
		Object obj = list.get(0);
		if (obj != null) {
			return Integer.valueOf(obj.toString());
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public Integer queryNextData(String object, Integer id) {
		List<Object> list = ht.find("select min(id) from " + object
				+ " where id>" + id);
		Object obj = list.get(0);
		if (obj != null) {
			return Integer.valueOf(obj.toString());
		} else
			return null;
	}
}
