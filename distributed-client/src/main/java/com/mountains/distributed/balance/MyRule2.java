package com.mountains.distributed.balance;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tinxi
 * @ClassName MyRule1
 * @Description 自己实现的负载均衡机制
 * @date 2019/7/10 22:58
 */
public class MyRule2 extends AbstractLoadBalancerRule {

	private AtomicInteger nextServerCyclicCounter;
	private static final boolean AVAILABLE_ONLY_SERVERS = true;
	private static final boolean ALL_SERVERS = false;

	private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

	public MyRule2() {
		nextServerCyclicCounter = new AtomicInteger(0);
	}

	public MyRule2(ILoadBalancer lb) {
		this();
		setLoadBalancer(lb);
	}

	// The most well known and basic load balancing strategy, i.e. Round Robin Rule. 轮询逻辑
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			log.warn("no load balancer");
			return null;
		}

		Server server = null;
		int count = 0;
		while (server == null && count++ < 10) {
			List<Server> reachableServers = lb.getReachableServers();
			List<Server> allServers = lb.getAllServers();
			int upCount = reachableServers.size();
			int serverCount = allServers.size();

			if ((upCount == 0) || (serverCount == 0)) {
				log.warn("No up servers available from load balancer: " + lb);
				return null;
			}

			// int nextServerIndex = incrementAndGetModulo(serverCount);
			int nextServerIndex = 0;    // modified by tinxi use first server forever
			server = allServers.get(nextServerIndex);

			if (server == null) {
				/* Transient. */
				Thread.yield();
				continue;
			}

			if (server.isAlive() && (server.isReadyToServe())) {
				return (server);
			}

			// Next.
			server = null;
		}

		if (count >= 10) {
			log.warn("No available alive servers after 10 tries from load balancer: "
			         + lb);
		}
		return server;
	}

	/**
	 * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.
	 *
	 * @param modulo The modulo to bound the value of the counter.
	 * @return The next value.
	 */
	private int incrementAndGetModulo(int modulo) {
		for (;;) {
			int current = nextServerCyclicCounter.get();
			int next = (current + 1) % modulo;
			if (nextServerCyclicCounter.compareAndSet(current, next))
				return next;
		}
	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig iClientConfig) {

	}
}
