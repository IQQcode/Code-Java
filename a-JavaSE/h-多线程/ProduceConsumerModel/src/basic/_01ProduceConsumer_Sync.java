package basic;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: iqqcode
 * @Date: 2020-10-17 17:23
 * @Description:
 */


/**
 * 消息类--商品
 * 无Setter()线程安全
 */
final class Message {
    private int id;
    private Object message;

    public Message(int id, Object message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Object getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{ " +
                "id=" + id +
                ", message=" + message +
                '}';
    }
}

//线程间通信的消息队列
class MessageQueue {
    //存放消息的队列
    private LinkedList<Message> list = new LinkedList<Message> ();
    //容量
    private int capacity;

    //初始化容器
    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    //存入消息
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                try {
                    System.err.println("对队列为满，<生产者>线程等待...");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //尾部添加消息
            list.addLast(message);
            System.out.println("生产消息！" + message);
            //唤醒等待的消费者
            list.notifyAll();
        }
    }

    //获取消息
    public Message take() {
        //检查队列是否为空
        synchronized (list) {
            while(list.isEmpty()) {
                try {
                    System.err.println("对队列为空，<消费者>线程等待...");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从对头取出消息并返回
            Message msg = list.removeFirst();
            System.out.println("消费消息" + msg);
            //通着生产者生产
            list.notifyAll();
            return msg;
        }
    }
}

//测试类
public class _01ProduceConsumer_Sync {
    public static void main(String[] args) {
        MessageQueue msque = new MessageQueue(2);

        //生产者
        for (int i = 0; i < 3; i++) {
            //Lambda中引用的外部局部变量必须为final,再定义一个局部变量
            int id = i;
            new Thread(() -> {
                msque.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    msque.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "消费者").start();
    }
}
