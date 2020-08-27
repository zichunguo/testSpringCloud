package com.guo.cloud.dao;

import com.guo.cloud.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
@Mapper
public interface AccountDao {
	int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
	/**
	 * 查询所有订单
	 * @return
	 */
	List<Account> list();
}
