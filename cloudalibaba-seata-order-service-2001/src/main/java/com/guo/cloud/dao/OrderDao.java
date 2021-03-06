package com.guo.cloud.dao;

import com.guo.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author guo
 * @date 2020/8/23
 */
@Mapper
public interface OrderDao {
	/**
	 * 新建订单
	 * @param order
	 */
	void create(Order order);

	/**
	 * 修改订单状态，从 0 改为 1
	 * @param userId
	 * @param status
	 */
	void update(@Param("userId") Long userId, @Param("status") Integer status);
}
