package leetCode.design;

import java.util.Arrays;

public class MyCircularDeque {

    int[] deque;
    int capacity;
    int used;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        used = 0;
        capacity = k;
        deque = new int[capacity];
        Arrays.fill(deque, -1);
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        pushToBack();
        deque[0] = value;

        used++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        pushToFront();
        deque[capacity - 1] = value;

        used++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (used > 0) {
            int index = -1;
            if (deque[0] != -1) {
                for (int i = 0; i < capacity && index == -1; i++) {
                    if (deque[i] == -1) {
                        index = i;
                    }
                }
                index = index > -1 ? index : capacity - 1;
                pushFrontToHead();
            } else {
                for (int i = 0; i < capacity; i++) {
                    if (deque[i] != -1) {
                        index = i;
                        break;
                    }
                }
            }
            deque[index] = -1;
            used--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (used > 0) {
            int index = -1;
            if (deque[capacity - 1] != -1) {
                for (int i = capacity - 1; i >= 0 && index == -1; i--) {
                    if (deque[i] == -1) {
                        index = i;
                    }
                }
                index = index > -1 ? index + 1 : 0;
                pushRearToBack();
            } else {
                for (int i = capacity - 1; i >= 0; i--) {
                    if (deque[i] != -1) {
                        index = i;
                        break;
                    }
                }
            }
            deque[index] = -1;
            used--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (used > 0) {
            for (int i : deque) {
                if (i != -1) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (used > 0) {
            for (int i = capacity - 1; i >= 0; i--) {
                if (deque[i] != -1) {
                    return deque[i];
                }
            }
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return used == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return used >= capacity;
    }

    private void pushToBack() {
        if (used > 0) {
            int length = getLengthFromRear();
            System.arraycopy(deque, 0, deque, 1, length);
        }
    }

    private void pushToFront() {
        if (used > 0) {
            int length = getLengthFromFront();
            System.arraycopy(deque, capacity - length, deque, capacity - length - 1, length);
        }
    }

    private void pushFrontToHead() {
        int length = getLengthFromRear();
        System.arraycopy(deque, 1, deque, 0, length);
    }

    private void pushRearToBack() {
        int length = getLengthFromFront();
        System.arraycopy(deque, capacity - length - 1, deque, capacity - length, length);
    }

    private int getLengthFromRear() {
        int length = 0;
        if (isFull()) {
            length = capacity - 1;
        } else {
            for (int value : deque) {
                if (value == -1) {
                    break;
                } else {
                    length++;
                }
            }
        }
        return length;
    }

    private int getLengthFromFront() {
        int length = 0;
        if (isFull()) {
            length = capacity - 1;
        } else {
            for (int i = capacity - 1; i >= 0; i--) {
                if (deque[i] != -1) {
                    length++;
                } else {
                    break;
                }
            }
        }
        return length;
    }
}

/**
 * Your CircularDeque object will be instantiated and called as such:
 * CircularDeque obj = new CircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */