package ren.xiayi.cig.stack.reserver;

import java.util.Stack;

public class ReserverStack<T> {
    private Stack<T> stack;

    public ReserverStack(Stack<T> stack) {
        super();
        this.stack = stack;
    }

    public void reserve() {
        if (this.stack == null) {
            throw new RuntimeException("the stack to reserve is null!");
        }
        if (stack.isEmpty()) {
            return;
        }
        T last = getLastAndRemove();
        reserve();
        stack.push(last);
    }

    public T getLastAndRemove() {
        if (stack == null) {
            throw new RuntimeException("the stack to reserve is null!");
        }
        if (stack.isEmpty()) {
            return null;
        }
        T tmpLast = stack.pop();//出栈第一个元素
        if (stack.isEmpty()) {
            return tmpLast;//返回最后一个元素
        }
        T last = getLastAndRemove();
        stack.push(tmpLast);
        return last;
    }

    @Override
    public String toString() {
        return stack.toString();
    }

}
