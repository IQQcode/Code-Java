package DataStruct.Queue;

import DataStruct.Queue.impl.ArrayLoopQueue;

public class TestLoopQueue {
    public static void main(String args[]) {
        //Queue<Integer> queue = new LinkedQueue<>();

        Queue<Integer> queue = new ArrayLoopQueue<>(5);

        queue.inQueue(1);
        queue.inQueue(2);
        queue.inQueue(3);
        queue.inQueue(4);
        queue.inQueue(5);
        queue.outQueue();
        queue.inQueue(6);
        System.out.println(queue.peek());
        System.out.println(queue.outQueue());
        System.out.println(queue.getSize());
        System.out.println(queue.peek());
    }
}
