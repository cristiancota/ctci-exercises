package leetCode.challenge.december;

import linkedLists.ListNode;

import java.util.ArrayList;
import java.util.List;

class LinkedListRandomNode {
    List<Integer> list = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomNumber = getRandomNumber();
        return list.get(randomNumber);
    }

    private int getRandomNumber() {
        return (int) (Math.random() * (list.size()));
    }
}


