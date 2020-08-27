package com.guo.cloud.service;

import com.guo.cloud.domain.Order;

import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
public interface OrderService {
	void create(Order order);
	void test();

	/**
	 * 查询所有订单
	 * @return
	 */
	List<Order> list();
}

