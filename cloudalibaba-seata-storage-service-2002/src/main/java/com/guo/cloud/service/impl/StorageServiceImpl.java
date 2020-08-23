package com.guo.cloud.service.impl;

import com.guo.cloud.dao.StorageDao;
import com.guo.cloud.service.StorageService;
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

	@Override
	public void decrease(Long productId, Integer count) {
		log.info("===> Account Service 扣减库存开始。。。");
		storageDao.decrease(productId, count);
		log.info("===> Account Service 扣减库存结束");
	}
}
