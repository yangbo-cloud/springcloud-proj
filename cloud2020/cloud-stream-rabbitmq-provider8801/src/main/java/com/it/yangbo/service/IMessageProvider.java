package com.it.yangbo.service;
/**@Name: IMessageProvider
 * @Description: //发送消息接口  通过  spring Stream + rabbitmq 整合 消息发送
 * @Author: yangbo
 * @Date: 2020/4/13 1:16 下午
 */

public interface IMessageProvider {
    public String send();
}
