package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.Page;

public interface InterestGroupDao {
	public InterestGroup save(InterestGroup interestGroup);

	public InterestGroup update(InterestGroup interestGroup);

	public void delete(InterestGroup interestGroup);

	public InterestGroup findById(Integer id);

	public List<InterestGroup> findAll(Page page);

	public List<InterestGroup> findByUser(User user);
}
