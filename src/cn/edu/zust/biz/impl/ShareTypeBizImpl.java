package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.ShareTypeBiz;
import cn.edu.zust.dao.ShareTypeDao;
import cn.edu.zust.entity.ShareType;

public class ShareTypeBizImpl implements ShareTypeBiz {
	private ShareTypeDao shareTypeDao;

	public ShareTypeDao getShareTypeDao() {
		return shareTypeDao;
	}

	public void setShareTypeDao(ShareTypeDao shareTypeDao) {
		this.shareTypeDao = shareTypeDao;
	}

	public ShareType add(ShareType shareType) {
		return shareTypeDao.save(shareType);
	}

	public ShareType modify(ShareType shareType) {
		return shareTypeDao.update(shareType);
	}

	public List<ShareType> query() {
		return shareTypeDao.findAll();
	}

}
