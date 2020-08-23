package com.guo.cloud.service.impl;

import com.guo.cloud.dao.OrderDao;
import com.guo.cloud.domain.Order;
import com.guo.cloud.service.AccountService;
import com.guo.cloud.service.OrderService;
import com.guo.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/8/23
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;
	@Resource
	private StorageService storageService;
	@Resource
	private AccountService accountService;

	/**
	 * 创建订单 -> 调用库存微服务扣减库存 -> 调用账户微服务扣减账户余额 -> 修改订单状态
	 * 简单：下订单 -> 减库存 -> 扣余额 -> 改（订单）状态
	 * @param order
	 */
	@Override
	@GlobalTransactional(name = "my-create-order",rollbackFor = Exception.class)
	public void create(Order order) {
		// 1、新建订单
		log.info("---> 开始新建订单.");
		orderDao.create(order);

		// 2、扣减库存
		log.info("---> 订单微服务开始调用库存微服务，做库存扣减");
		storageService.decrease(order.getProductId(), order.getCount());
		log.info("---> 订单微服务开始调用库存微服务，做库存扣减 end.");

		// 3、扣减账户
		log.info("---> 订单微服务开始调用账户微服务，做账户扣减");
		accountService.decrease(order.getUserId(), order.getMoney());
		log.info("---> 订单微服务开始调用账户微服务，做账户扣减 end.");

		// 4、修改订单状态
		log.info("---> 修改订单状态");
		orderDao.update(order.getUserId(), 0);
		log.info("---> 修改订单状态 end.");

		log.info("---> 下订单完成. O(∩_∩)O");
	}
}
