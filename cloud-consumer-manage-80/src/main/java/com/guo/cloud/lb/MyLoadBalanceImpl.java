package com.guo.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义负载均衡算法--实现类
 * @author guo
 * @date 2020/8/16
 */
@Component
public class MyLoadBalanceImpl implements MyLoadBalance {

	private AtomicInteger atomicInteger;

	public MyLoadBalanceImpl() {
		atomicInteger = new AtomicInteger(0);
	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
		int index =getAndIncrement() % serviceInstances.size();
		return serviceInstances.get(index);
	}

	/**
	 * 获取当前调用次数，使用自旋锁
	 * @return
	 */
	public final int getAndIncrement() {
		int current;
		int next;
		do {
			current = this.atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : (current + 1);
		} while (!this.atomicInteger.compareAndSet(current, next));
		System.out.println("****** 访问次数：" + next);
		return next;
	}
}
