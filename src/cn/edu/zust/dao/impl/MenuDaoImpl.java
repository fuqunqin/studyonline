package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.MenuDao;
import cn.edu.zust.entity.Menu;

public class MenuDaoImpl implements MenuDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public void delete(Menu menu) {
		ht.delete(menu);
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findAll() {
		return ht.find("from Menu m order by m.id asc");
	}

	public Menu findById(Integer id) {
		return (Menu) ht.get(Menu.class, id);
	}

	public Menu save(Menu menu) {
		ht.save(menu);
		return menu;
	}

	public Menu update(Menu menu) {
		ht.update(menu);
		return menu;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findSunMenues(Integer parentId) {
		String hql = "from Menu as m where m.parentId=" + parentId;
		return ht.find(hql);
	}

}
