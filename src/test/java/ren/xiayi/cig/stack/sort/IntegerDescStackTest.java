package ren.xiayi.cig.stack.sort;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * 将源队列进行降序排列
 *
 */
public class IntegerDescStackTest {

    @Test
    public void descSort() {
        Stack<Integer> toSortStack = new Stack<Integer>();
        toSortStack.push(1);
        toSortStack.push(5);
        toSortStack.push(2);
        toSortStack.push(3);
        toSortStack.push(4);

        IntegerDescStack desc = new IntegerDescStack();
        Stack<Integer> result = desc.desc(toSortStack);

        Assert.assertTrue("[5, 4, 3, 2, 1]".equals(result.toString()));

    }
}
