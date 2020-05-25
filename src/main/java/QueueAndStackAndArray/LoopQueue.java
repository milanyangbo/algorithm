package QueueAndStackAndArray;

public class LoopQueue {
  private Long[] data;
  private int size = 0, head = 0, tail = 0;

  public LoopQueue(int size) {
    this.data = new Long[size];
    this.size = size;
  }

  public boolean add(Long element) {
    if ((tail + 1) % size == head) return false;
    data[tail] = element;
    tail = (tail + 1) % size;
    return true;
  }

  public Long poll() {
    if (head == tail) return null;
    long ret = data[head];
    head = (head + 1) % size;
    return ret;
  }

  public static void main(String[] args) {
    LoopQueue loopQueue = new LoopQueue(10);
    loopQueue.add(1L);
    loopQueue.poll();
    loopQueue.add(12L);
    loopQueue.add(13L);
    loopQueue.add(15L);
    loopQueue.poll();
  }
}
