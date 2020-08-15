package com.guo.cloud.service.impl;

import com.guo.cloud.dao.UserDao;
import com.guo.cloud.entities.User;
import com.guo.cloud.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guo
 * @date 2020/8/14
 */
@Service
public class UserServiceImpl implements UserService {

	// @Autowired 只按照byType 注入
//	@Autowired
	// @Resource 默认按byName自动注入，如果按照默认的名称找不到依赖对象时， @Resource 注解会回退到按类型装配
	@Resource
	private UserDao userDao;

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}
}
