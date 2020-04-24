package DS.StackAndQueue.OJ;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //保证所有元素都在一个队列中
        if(queueA.isEmpty()) {
            queueB.add(x);
        }else {
            queueA.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queueA.isEmpty()) {
            int len = queueB.size();
            for(int i =0; i < len - 1; i++){
                //所有元素依次放入队列A中
                queueA.add(queueB.poll()); //poll()移出对头元素

                //队列 B的最后一个元素一定是最后进入的，刚好是栈顶元素
            }
            int result = queueB.poll();
            return result;
        }else {
            int len = queueA.size();
            for(int i =0; i < len - 1; i++){
                queueB.add(queueA.poll());
            }
            int result = queueA.poll();
            return result;
        }
    }

    /** Get the top element. */
    public int top() {
        if(queueA.isEmpty()) {
            int len = queueB.size();
            for(int i = 0; i < len - 1; i++){
                //所有元素依次放入队列A中
                queueA.add(queueB.poll());
            }
            int result = queueB.poll();
            queueA.add(result);
            return result;
        }else {
            int len = queueA.size();
            for(int i = 0; i < len - 1; i++){
                queueB.add(queueA.poll());
            }
            int result = queueA.poll();
            queueB.add(result);
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}

public class MyStackByDoubleQueue {
}
