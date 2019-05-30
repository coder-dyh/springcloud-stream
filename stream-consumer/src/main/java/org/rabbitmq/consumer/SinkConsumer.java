package org.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @EnableBinding 注解用来指定一个或者多个定义了 @Input 或 @Output 注解的接口，以此实现对消息通道 channel 的绑定
 * （此处的 channel 不同于 rabbitmq 的 channel，此 channel 为 springcloud 对消息中间件抽象的 channel）， Sink
 *  接口因为用了 @input 接口所以表示输入通道，通道名为 input， 详见源码
 *  {@link org.springframework.cloud.stream.messaging.Sink}
 */
@EnableBinding(Sink.class)
public class SinkConsumer {

    private static final Logger log = LoggerFactory.getLogger(SinkConsumer.class);

    /**
     *  @streamListener 注解标注的方法表示消息处理方法，value 为监听的通道名
     */
    @StreamListener(Sink.INPUT)
    public void receive(Object message) {
        log.info("Received: {}", message);
    }
}
