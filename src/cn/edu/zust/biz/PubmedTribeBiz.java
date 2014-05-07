package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.PubmedTribe;
import cn.edu.zust.util.Page;

public interface PubmedTribeBiz {
	public List<PubmedTribe> query(Page page);

	public PubmedTribe modify(PubmedTribe pubmedTribe);

	public PubmedTribe add(PubmedTribe pubmedTribe);

	public void remove(List<PubmedTribe> pubmedTribes);

	public PubmedTribe query(Integer id);
}
