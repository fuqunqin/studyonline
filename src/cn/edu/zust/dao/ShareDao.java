package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface ShareDao {
	public Share save(Share share);

	public Share update(Share share);

	public void delete(Share share);

	public Share findById(Integer id);

	public List<Share> findAll(Page page);

	public Share findByShareUrl(String shareUrl);
	
	public List<Share> findByUser(User user);

}
