package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.SutraBook;
import cn.edu.zust.util.Page;

public interface SutraBookBiz {
	public SutraBook add(SutraBook sutraBook);

	public SutraBook modify(SutraBook sutraBook);

	public void remove(List<SutraBook> sutraBooks);

	public List<SutraBook> query(Page page);

	public SutraBook query(Integer id);
}
