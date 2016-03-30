package ren.xiayi.cig.stack.sort;

import java.util.Stack;

/**
 * 将源队列进行降序排列
 *
 */
public class IntegerDescStack {

    public Stack<Integer> desc(Stack<Integer> sourceStack) {
        if (sourceStack == null || sourceStack.isEmpty()) {
            return sourceStack;
        }
        Stack<Integer> tmpStack = new Stack<Integer>();
        while (!sourceStack.isEmpty()) {
            Integer tmp = sourceStack.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() >= tmp.intValue()) {
                sourceStack.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        while (!tmpStack.isEmpty()) {
            sourceStack.push(tmpStack.pop());
        }
        return sourceStack;
    }
}
