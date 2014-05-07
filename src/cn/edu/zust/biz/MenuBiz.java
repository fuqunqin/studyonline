package cn.edu.zust.biz;

import java.util.List;
import java.util.Map;

import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Menu;

public interface MenuBiz {
	// ͨ�����Ա��ѯ���еĲ˵�
	public Map<Menu, List<Menu>> query(Admin admin);

	// ��ѯ���и��˵�
	public List<Menu> queryAllParentMenues();

	// ��Ӳ˵�
	public List<Menu> addMenu(Menu menu);
}
