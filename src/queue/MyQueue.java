package queue;

import java.util.*;

/**
 * 队列应支持两种操作：入队和出队。入队会向队列追加一个新元素，而出队会删除第一个元素。
 */
public class MyQueue {
    private List<Integer> data;
    private int p_start;

    @Override
    public String toString() {
      return data.toString();
    }

    public MyQueue() {
      data = new ArrayList<Integer>();
      p_start = 0;
    }

    public boolean isEmpty() {
      return p_start >= data.size();
    }

    public int front() {
      return data.get(p_start);
    }

    public boolean enQueue(int val) {
      data.add(val);
      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }

      p_start++;
      return true;
    }
}