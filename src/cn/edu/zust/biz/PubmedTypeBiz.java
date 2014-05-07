package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.PubmedType;

public interface PubmedTypeBiz {
	public PubmedType add(PubmedType pubmedType);

	public List<PubmedType> query();
}
