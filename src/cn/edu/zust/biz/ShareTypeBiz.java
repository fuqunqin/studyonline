package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.ShareType;

public interface ShareTypeBiz {
	public ShareType add(ShareType shareType);

	public ShareType modify(ShareType shareType);

	public List<ShareType> query();
}
