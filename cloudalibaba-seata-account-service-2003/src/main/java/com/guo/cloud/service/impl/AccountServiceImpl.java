package com.guo.cloud.service.impl;

import com.guo.cloud.dao.AccountDao;
import com.guo.cloud.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author guo
 * @date 2020/8/23
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	/**
	 * 扣减账户余额
	 * @param userId
	 * @param money
	 */
	@Override
	public void decrease(Long userId, BigDecimal money) {
		log.info("***> Account Service 扣减账户余额开始。。。");
		// 模拟超时异常，全局事务回滚
//		try {
//			TimeUnit.SECONDS.sleep(20);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		accountDao.decrease(userId, money);
		// 模拟异常，全局事务回滚
//		int i = 10 / 0;
		log.info("***> Account Service 扣减账户余额结束");
	}

	@Override
	@GlobalTransactional
	public void test() {
		log.info("****** @GlobalTransactional 测试通过 ******");
	}
}
