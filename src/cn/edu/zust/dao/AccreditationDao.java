package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.util.Page;

public interface AccreditationDao {
	public Accreditation save(Accreditation accreditation);

	public void delete(Accreditation accreditation);

	public Accreditation update(Accreditation accreditation);

	public Accreditation findById(Integer id);

	public List<Accreditation> findAll(Page page);
}
