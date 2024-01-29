package com.sdu.zrpc.framework.core.loadbalance.impl;

import com.sdu.zrpc.framework.core.config.RpcBootstrap;
import com.sdu.zrpc.framework.core.loadbalance.AbstractLoadBalance;
import com.sdu.zrpc.framework.core.loadbalance.Selector;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * 最短响应时间的负载均衡策略
 */
@Slf4j
public class ResponseTimeLoadBalance extends AbstractLoadBalance {

    @Override
    protected Selector initSelector(List<InetSocketAddress> serviceList) {
        return new ResponseTimeSelector();
    }

    private static class ResponseTimeSelector implements Selector {

        @Override
        public InetSocketAddress select() {
            Map.Entry<Long, Channel> entry = RpcBootstrap.RESPONSE_TIME_CACHE.firstEntry();
            if (null != entry) {
                log.info("选取了响应时间为【{}ms】的服务节点.", entry.getKey());
                return (InetSocketAddress) entry.getValue().remoteAddress();
            }
            Channel channel = (Channel) RpcBootstrap.CHANNEL_CACHE.values().toArray()[0];
            return (InetSocketAddress) channel.remoteAddress();
        }
    }
}
