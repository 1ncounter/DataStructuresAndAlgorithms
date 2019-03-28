package queue;

public class MyCircularQueue {
  private int[] data;
  private int head;
  private int tail;
  private int count;

  MyCircularQueue(int k) {
    data = new int[k];
    head = 0;
    tail = 0;
    count = 0;
  }

  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    }

    data[tail++] = value;
    tail = tail % data.length;
    count++;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    head++;
    head = head % data.length;
    count--;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }

    return data[head];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }

    if (tail == 0) {
      return data[data.length - 1];
    }

    return data[tail - 1];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == data.length;
  }
}