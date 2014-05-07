package cn.edu.zust.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.zust.biz.MenuBiz;
import cn.edu.zust.dao.MenuDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Menu;

public class MenuBizImpl implements MenuBiz {
	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public Map<Menu, List<Menu>> query(Admin admin) {
		List<Menu> menues = new ArrayList<Menu>();
		if (admin.getId() == -1) {
			menues = menuDao.findAll();
			return this.getMenues(menues);
		} else {
			Set<Menu> setMenues = admin.getMenues();
			Map<Menu, List<Menu>> menus = new HashMap<Menu, List<Menu>>();
			for (Menu menu : setMenues) {
				List<Menu> ms = menuDao.findSunMenues(menu.getId());
				menus.put(menu, ms);
			}
			return menus;
		}
	}

	public List<Menu> queryAllParentMenues() {
		List<Menu> menues = menuDao.findAll();
		List<Menu> ms = new ArrayList<Menu>();
		for (Menu menu : menues) {
			if (menu.getParentId() == null) {
				ms.add(menu);
			}
		}
		if (ms.size() == 0) {
			ms = null;
		}
		return ms;
	}

	public List<Menu> addMenu(Menu menu) {
		if (menu.getParentId() == -1) {
			menu.setParentId(null);
		}
		menuDao.save(menu);
		return null;
	}

	private Map<Menu, List<Menu>> getMenues(List<Menu> menues) {
		Map<Menu, List<Menu>> menus = new HashMap<Menu, List<Menu>>();
		Map<Integer, Menu> mes = new HashMap<Integer, Menu>();
		for (Menu menu : menues) {
			if (menu.getParentId() == null) {
				mes.put(menu.getId(), menu);
			}
		}
		for (Menu menu : menues) {
			// 如果父id不是null，则证明是子菜单
			if (menu.getParentId() != null) {
				// 通过子菜单的id查找到父菜单
				Menu m = mes.get(menu.getParentId());
				// 如果Map集合中有这个父菜单，则将这个对象放在父菜单中;否则创建一个集合放在这个Map中
				if (menus.containsKey(m)) {
					List<Menu> mm = menus.get(m);
					mm.add(menu);
					menus.put(m, mm);
				} else {
					List<Menu> mm = new ArrayList<Menu>();
					mm.add(menu);
					menus.put(m, mm);
				}
			}
		}
		return menus;
	}

}
