package com.guo.cloud.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.guo.cloud.dao.StorageDao;
import com.guo.cloud.domain.Storage;
import com.guo.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

	@Resource
	private StorageDao storageDao;

	/**
	 * 扣减库存
	 * @param productId
	 * @param count
	 */
	@Override
	public void decrease(Long productId, Integer count) {
		log.info("===> Account Service 扣减库存开始。。。");
		storageDao.decrease(productId, count);
		log.info("===> Account Service 扣减库存结束");
	}

	@Override
	@LcnTransaction	// 分布式事务
	@Transactional	// 本地事务
	public void test() {
		log.info("****** @LcnTransaction 测试通过 ******");
	}

	@Override
	public List<Storage> list() {
		return storageDao.list();
	}
}
