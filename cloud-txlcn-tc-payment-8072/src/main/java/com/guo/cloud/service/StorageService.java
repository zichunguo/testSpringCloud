package com.guo.cloud.service;

import com.guo.cloud.domain.Account;
import com.guo.cloud.domain.Storage;

import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
public interface StorageService {
	void decrease(Long productId, Integer count);
	void test();
	List<Storage> list();
}
