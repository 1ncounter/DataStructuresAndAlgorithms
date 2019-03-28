package queue;

import java.util.LinkedList;
import java.util.Queue;

// FIFO 先进先出的数据结构

class Main {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<Integer>();

    System.out.println("The first element is: " + queue.peek());
    // 3. Push new element.
    queue.offer(5);
    queue.offer(13);
    queue.offer(8);
    queue.offer(6);
    // 4. Pop an element.
    queue.poll();
    // 5. Get the first element.
    System.out.println("The first element is: " + queue.peek());
    // 7. Get the size of the queue.
    System.out.println("The size is: " + queue.size());
  }
}