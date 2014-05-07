package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.OnlineListeningBiz;
import cn.edu.zust.dao.OnlineListeningDao;
import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.util.Page;

public class OnlineListeningBizImpl implements OnlineListeningBiz {
	private OnlineListeningDao onlineListeningDao;

	public OnlineListeningDao getOnlineListeningDao() {
		return onlineListeningDao;
	}

	public void setOnlineListeningDao(OnlineListeningDao onlineListeningDao) {
		this.onlineListeningDao = onlineListeningDao;
	}

	public OnlineListening add(OnlineListening onlineListening) {
		return onlineListeningDao.save(onlineListening);
	}

	public OnlineListening modify(OnlineListening onlineListening) {
		return onlineListeningDao.update(onlineListening);
	}

	public List<OnlineListening> query(Page page) {
		return onlineListeningDao.findAll(page);
	}

	public OnlineListening query(Integer id) {
		return onlineListeningDao.findById(id);
	}

	public void remove(List<OnlineListening> onlineListenings) {
		for (OnlineListening onlineListening : onlineListenings) {
			onlineListeningDao.delete(onlineListening);
		}
	}

	public OnlineListening query(String listenUrl) {
		return onlineListeningDao.findByListenUrl(listenUrl);
	}

}
