package com.dingcheng.confirms.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

/**
 * @Description:消息确认类.表示消息已经到达服务端
 * @Author: Liukx on 2017/6/20 - 16:11
 */
@Service("confirmCallBackListener")
public class ConfirmCallBackListener implements ConfirmCallback {

    /**
     * 消息确认方法,当exchange为已经找到时ack为true,如果没有找到则为false
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("confirm--:correlationData:" + correlationData + ",ack:" + ack + ",cause:" + cause);
    }

}
