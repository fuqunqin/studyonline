package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface ShareBiz {
	// 添加共享资料
	public Share add(Share share);

	// 修改共享资料
	public Share modify(Share share, Admin admin);

	// 删除共享资料
	public void remove(List<Share> shares, Admin admin);

	// 查询共享资料
	public List<Share> query(Page page);

	// 查询单个共享资料
	public Share query(Integer id);

	// 通过资料路径查询共享资料
	public Share query(String shareUrl);

	// 通过用户查询共享资料
	public List<Share> queryByUser(User user);
}
