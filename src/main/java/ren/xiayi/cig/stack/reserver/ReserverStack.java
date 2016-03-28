package ren.xiayi.cig.stack.reserver;

import java.util.Stack;

public class ReserverStack<T> {

    public void reserve(Stack<T> stack) {
        if (stack == null) {
            throw new RuntimeException("the stack to reserve is null!");
        }
        if (stack.isEmpty()) {
            return;
        }
        T last = getLastAndRemove(stack);
        reserve(stack);
        stack.push(last);
    }

    public T getLastAndRemove(Stack<T> stack) {
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
        T last = getLastAndRemove(stack);
        stack.push(tmpLast);
        return last;
    }

}
