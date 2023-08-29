package com.sdu.irpc.framework.core.registration;

import com.sdu.irpc.framework.core.config.ServiceConfig;

import java.net.InetSocketAddress;
import java.util.List;

public interface Registry {

    /**
     * 注册服务
     * @param serviceConfig 服务的配置内容
     */
    void register(ServiceConfig<?> serviceConfig);

    /**
     * 从注册中心拉取服务列表
     * @param serviceName 服务的名称
     * @return 服务的地址
     */
    List<InetSocketAddress> discover(String serviceName);
}