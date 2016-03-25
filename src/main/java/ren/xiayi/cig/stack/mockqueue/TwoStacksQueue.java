package ren.xiayi.cig.stack.mockqueue;

import java.util.Stack;

/**
 * 使用两个栈模拟队列数据结构
 * @author zhangyu
 *
 */
public class TwoStacksQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public void addElement(Integer data) {
        pushStack.push(data);
    }

    public Integer pop() {
        buildPopStack();
        return popStack.pop();

    }

    public Integer peek() {
        buildPopStack();
        return popStack.peek();
    }

    private void buildPopStack() {
        if (popStack.isEmpty() && pushStack.isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    };
}
