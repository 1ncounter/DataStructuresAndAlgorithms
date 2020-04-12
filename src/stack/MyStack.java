package stack;

import java.util.ArrayList;
import java.util.List;

// 栈是一个 LIFO 数据结构。通常，插入操作在栈中被称作入栈 push 。
// 与队列类似，总是在堆栈的末尾添加一个新元素。但是，删除操作，退栈 pop ，将始终删除队列中相对于它的最后一个元素。

class MyStack {
    private List<Integer> data;

    MyStack() {
      data = new ArrayList<>();
    }

    public void push(int value) {
      data.add(value);
    }

    public int top() {
      return data.get(data.size() - 1);
    }

    public int pop() {
      if (isEmpty()) {
        return -1;
      }

      int x = data.get(data.size() - 1);

      data.remove(data.size() - 1);
      return x;
    }

    public boolean isEmpty() {
      return data.size() == 0;
    }


}