package com.bittech.pc;

import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class ProducerConsumerManager {
    
    private final Integer maxGoods;
    private final Integer producers;
    private final long produceSpeed;
    private final long consumers;
    private final long consumerSpeed;
    private final Queue<Goods> queue;
    private final Producer producer;
    private final Consumer consumer;
    
    public ProducerConsumerManager(Properties properties) {
        this.maxGoods = Integer.parseInt(properties.getProperty("collect.max_capacity", "20"));
        this.producers = Integer.parseInt(properties.getProperty("producer.number"));
        this.produceSpeed = Long.parseLong(properties.getProperty("producer.speed"));
        this.consumers = Integer.parseInt(properties.getProperty("consumer.number"));
        this.consumerSpeed = Long.parseLong(properties.getProperty("consumer.speed"));
        this.queue = new LinkedList<>();
        this.producer = new Producer(queue,
                maxGoods, produceSpeed);
        this.consumer = new Consumer(queue, consumerSpeed);
    }
    
    public void startProducer() {
        for (int i = 0; i < this.producers; i++) {
            new Thread(this.producer, "Thread-Producer-" + i)
                    .start();
        }
        
    }
    
    public void startConsumer() {
        for (int i = 0; i < this.consumers; i++) {
            new Thread(this.consumer, "Thread-Consumer-" + i)
                    .start();
        }
    }
    
    public String getCurrentInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("-- 当前生产者消费者模型中的配置信息如下 --");
        sb.append("\n");
        sb.append("容量:");
        sb.append(this.maxGoods);
        sb.append("\n");
        sb.append("生产者数量:");
        sb.append(this.producers);
        sb.append("\n");
        sb.append("生产速率(ms):");
        sb.append(this.produceSpeed);
        sb.append("\n");
        sb.append("消费者数量:");
        sb.append(this.consumers);
        sb.append("\n");
        sb.append("消费速率(ms):");
        sb.append(this.consumerSpeed);
        sb.append("\n");
        return sb.toString();
    }
}
