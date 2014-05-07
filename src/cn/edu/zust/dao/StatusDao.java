package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.Status;

public interface StatusDao {
	public Status save(Status status);

	public Status update(Status status);

	public Status findById(Integer id);

	public void delete(Status status);

	public List<Status> findAll();
}
