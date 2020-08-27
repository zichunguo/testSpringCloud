package com.guo.cloud.dao;

import com.guo.cloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author guo
 * @date 2020/8/27
 */
@Mapper
public interface StorageDao {
	int decrease(@Param("productId") Long productId, @Param("count") Integer count);

	/**
	 * 查询所有订单
	 * @return
	 */
	List<Storage> list();
}
