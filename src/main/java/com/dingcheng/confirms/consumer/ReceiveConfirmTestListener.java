package com.dingcheng.confirms.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

/**
 * @Description:消息消费监听类
 * @Author: Liukx on 2017/6/20 - 16:13
 */
@Service("receiveConfirmTestListener")
public class ReceiveConfirmTestListener implements ChannelAwareMessageListener {


    /**
     * 所有推送过来的消息均会被该方法消费掉
     *
     * @param message
     * @param channel
     * @throws Exception
     */
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            System.out.println("consumer--:" + message.getMessageProperties() + ":" + new String(message.getBody()));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();//TODO 业务处理
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

}  
