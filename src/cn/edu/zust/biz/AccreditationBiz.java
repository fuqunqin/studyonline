package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.Accreditation;
import cn.edu.zust.util.Page;

public interface AccreditationBiz {
	// 添加资格认证
	public Accreditation add(Accreditation accreditation);

	// 修改资格认证
	public Accreditation modify(Accreditation accreditation);

	// 删除资格认证
	public void remove(List<Accreditation> accreditations);

	// 查询资格认证
	public List<Accreditation> query(Page page);

	// 查询单个资格认证
	public Accreditation query(Integer id);
}
