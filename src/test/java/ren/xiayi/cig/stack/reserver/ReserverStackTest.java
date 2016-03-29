package ren.xiayi.cig.stack.reserver;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ReserverStackTest {

    @Test
    public void testReserve() {
        Stack<Integer> data = new Stack<Integer>();
        data.push(1);
        data.push(2);
        data.push(3);

        ReserverStack<Integer> rs = new ReserverStack<Integer>(data);
        rs.reserve();
        String string = rs.toString();
        System.out.println(string);
        Assert.assertTrue("[3, 2, 1]".equals(string));
    }

}
