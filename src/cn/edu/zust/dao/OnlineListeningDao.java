package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.OnlineListening;
import cn.edu.zust.util.Page;

public interface OnlineListeningDao {
	public OnlineListening save(OnlineListening onlineListening);

	public OnlineListening update(OnlineListening onlineListening);

	public OnlineListening findById(Integer id);

	public List<OnlineListening> findAll(Page page);

	public void delete(OnlineListening onlineListening);

	public OnlineListening findByListenUrl(String listenUrl);
}
