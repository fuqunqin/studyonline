package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.ShareTypeDao;
import cn.edu.zust.entity.ShareType;

public class ShareTypeDaoImpl implements ShareTypeDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(ShareType shareType) {
		ht.delete(shareType);

	}

	@SuppressWarnings("unchecked")
	public List<ShareType> findAll() {

		return ht.find("from ShareType");
	}

	public ShareType findById(Integer id) {

		return (ShareType) ht.get(ShareType.class, id);
	}

	public ShareType save(ShareType shareType) {
		ht.save(shareType);
		return shareType;
	}

	public ShareType update(ShareType shareType) {
		ht.update(shareType);
		return shareType;
	}

}
