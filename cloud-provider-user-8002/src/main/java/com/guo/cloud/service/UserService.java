package com.guo.cloud.service;

import com.guo.cloud.entities.User;

import java.util.List;

/**
 * @author guo
 * @date 2020/8/14
 */
public interface UserService {
	/**
	 * 添加用户
	 * @param user 添加的用户
	 * @return
	 */
	public int add(User user);

	/**
	 * 根据 ID 查找 user
	 * @param id 查找 user 的 ID
	 * @return
	 */
	public User getById(int id);

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> list();
}
