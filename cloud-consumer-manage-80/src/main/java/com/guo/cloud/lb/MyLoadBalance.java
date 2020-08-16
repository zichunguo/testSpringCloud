package com.guo.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡算法--接口
 */
public interface MyLoadBalance {
	/**
	 * 获取调用的服务实例
	 * @param serviceInstances 服务实例
	 * @return
	 */
	ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
