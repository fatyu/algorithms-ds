package ren.xiayi.cig.stack.getmin;

import java.util.Stack;

/**
 * @author zhangyu
 * 常用栈的基础上添加获取最小数据的方法,这个stack在入栈时省空间,pop时要进行一次判断会消耗一定时间.
 */
public class GetMinStackCostTime {

	private Stack<Integer> data;
	private Stack<Integer> min;

	public GetMinStackCostTime() {
		data = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (min.isEmpty()) {
			min.push(newNum);
		} else {
			if (newNum < this.peekMin()) {
				min.push(newNum);
			}
		}
		data.push(newNum);
	}

	public int pop() {
		if (data.isEmpty()) {
			throw new RuntimeException("there is no data in stack");
		}
		int popData = data.pop();
		if (this.peekMin() == popData) {
			min.pop();
		}
		return popData;
	}

	public int popMin() {
		if (min.isEmpty()) {
			throw new RuntimeException("there is no  min data in stack");
		}
		return min.pop();
	}

	public int peekMin() {
		if (min.isEmpty()) {
			throw new RuntimeException("there is no  min data in stack");
		}
		return min.peek();
	}

}
