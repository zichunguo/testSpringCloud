package com.guo.cloud.service.impl;

import com.guo.cloud.dao.StorageDao;
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
	@GlobalTransactional
	public void test() {
		log.info("****** @GlobalTransactional 测试通过 ******");
	}
}
