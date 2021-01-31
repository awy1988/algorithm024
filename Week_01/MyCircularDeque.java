package Week_01;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyCircularDeque {

    // 思路：
    // 1.使用数组实现

    private final int[] queue;
    /**
     * 队头索引，指向队头元素
     */
    private int firstIndex = -1;
    /**
     * 队末索引，指向队尾元素的下一个元素，
     * 这样会浪费一个元素的空间，但是我们可以简化队满与队空的判断
     * 队满条件：rearIndex + 1 = firstIndex 或 firstIndex = 0的情况下，rearIndex = queue.length - 1
     */
    private int rearIndex = -1;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        queue = new int[k + 1];
        firstIndex = queue.length / 2;
        rearIndex = firstIndex;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        firstIndex--;
        if (firstIndex == -1) firstIndex = queue.length - 1;
        queue[firstIndex] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        queue[rearIndex] = value;
        rearIndex++;
        if (rearIndex == queue.length) rearIndex = 0;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        firstIndex++;
        if (firstIndex == queue.length) firstIndex = 0;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rearIndex--;
        if (rearIndex == -1) rearIndex = queue.length - 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return queue[firstIndex];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        if (rearIndex == 0) return queue[queue.length - 1];
        return queue[rearIndex - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rearIndex == firstIndex;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return rearIndex - firstIndex == queue.length - 1 || rearIndex - firstIndex == -1;
    }
}
