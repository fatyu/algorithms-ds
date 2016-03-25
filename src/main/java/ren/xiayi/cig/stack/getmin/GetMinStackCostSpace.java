package ren.xiayi.cig.stack.getmin;

import java.util.Stack;

/**
 * @author zhangyu
 * 常用栈的基础上添加获取最小数据的方法,这个stack在入栈时浪费空间,pop时节省时间.
 */
public class GetMinStackCostSpace {

	private Stack<Integer> data;
	private Stack<Integer> min;

	public GetMinStackCostSpace() {
		data = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (min.isEmpty()) {
			min.push(newNum);
		} else {
			if (newNum <= this.peekMin()) {
				min.push(newNum);
			}
		}
		data.push(newNum);
	}

	public int pop() {
		if (data.isEmpty()) {
			throw new RuntimeException("there is no data in stack");
		}
		if (!min.isEmpty()) {
			min.pop();
		}
		return data.pop();
	}

	public int popMin() {
		if (min.isEmpty()) {
			throw new RuntimeException("there is no min data in stack");
		}
		return min.pop();
	}

	public int peekMin() {
		if (min.isEmpty()) {
			throw new RuntimeException("there is no min data in stack");
		}
		return min.peek();
	}

}
