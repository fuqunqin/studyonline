package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.ShareType;

public interface ShareTypeDao {
	public ShareType save(ShareType shareType);

	public ShareType update(ShareType shareType);

	public void delete(ShareType shareType);

	public ShareType findById(Integer id);

	public List<ShareType> findAll();
}
