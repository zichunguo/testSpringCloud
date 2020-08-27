package com.guo.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author guo
 * @date 2020/8/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Long id;
	private Long userId;
	private Long productId;
	private Integer count;
	private BigDecimal money;
	/**
	 * 订单状态：0：创建中；1：已完结
	 */
	private Integer status;
}
