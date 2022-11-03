package offer;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型

本题的基本意图是：用两个后入先出的栈来实现先入先出的队列。对于这个问题，我们可以通过一个实例来进行具体分析。不难得出相应的规律：有两个栈stack1和stack2，每次向队列中插入元素可以都压入到stack1中，当需要从队列中删除元素时，我们应该是删除最早插入的那个（FIFO），这时可以将stack1中的元素逐个弹出并压入stack2，直到stack1为空，这时最早插入的元素就位于stack2的栈顶，可以直接弹出。

  因此，我们总结如下：压入元素时，都压入栈1，当需要弹出时，从栈2弹出，当栈2不为空时直接弹出栈顶元素，为空时将栈1的元素“倒进去”。
 */
public class num_5 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println("peek:"+myQueue.peek());
        System.out.println("size:"+myQueue.size());
        System.out.println("pop1:"+myQueue.pop());
        System.out.println("pop2:"+myQueue.pop());
        System.out.println("empty:"+myQueue.empty());
        System.out.println("pop3:"+myQueue.pop());
        System.out.println("pop4:"+myQueue.pop());
        System.out.println("empty:"+myQueue.empty());


    }


}

class MyQueue{
    Stack<Integer> q1,q2;
    int topValue;

    /** Initialize your data structure here. */
    public MyQueue() {
        q1=new Stack<>();
        q2=new Stack<>();
        topValue=0;
    }

    /** Push element x onto stack. */
    public void push(int x) {  //压入到不为空的那个队列中
        if(size() ==0 || !q1.empty()){
            q1.push(x);
        }else {
            q2.push(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!q1.empty()){
            while (!q1.empty()){
                q2.push(q1.pop());
            }
            int val = q2.pop();
            while (!q2.empty()){
                q1.push(q2.pop());
            }
            return val;
        }
        return 0;
    }
    public int peek(){
        if(!q1.empty()){
            while (!q1.empty()){
                q2.push(q1.pop());
            }
            int val = q2.peek();
            while (!q2.empty()){
                q1.push(q2.pop());
            }
            return val;
        }
        return 0;
    }

    /** Get the top element. */
//    public int top() {
//    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.empty();
    }

    public int size(){
        return Math.max(q1.size(), q2.size());
    }


}
