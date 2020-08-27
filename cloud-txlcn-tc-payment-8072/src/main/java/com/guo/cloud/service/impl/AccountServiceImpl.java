package com.guo.cloud.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.guo.cloud.dao.AccountDao;
import com.guo.cloud.domain.Account;
import com.guo.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author guo
 * @date 2020/8/27
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
	@LcnTransaction	// 分布式事务
	@Transactional	// 本地事务
	public void decrease(Long userId, BigDecimal money) {
		log.info("***> Account Service 扣减账户余额开始。。。");
		// 模拟超时异常，全局事务回滚
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountDao.decrease(userId, money);
		// 模拟异常，全局事务回滚
//		int i = 10 / 0;
		log.info("***> Account Service 扣减账户余额结束");
	}

	@Override
	@LcnTransaction	// 分布式事务
	@Transactional	// 本地事务
	public void test() {
		log.info("****** @LcnTransaction 测试通过 ******");
	}

	@Override
	public List<Account> list() {
		return accountDao.list();
	}
}
