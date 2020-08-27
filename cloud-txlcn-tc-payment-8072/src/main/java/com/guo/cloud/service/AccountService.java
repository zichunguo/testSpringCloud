package com.guo.cloud.service;

import com.guo.cloud.domain.Account;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
public interface AccountService {
	void decrease(Long userId, BigDecimal money);
	void test();
	List<Account> list();
}
