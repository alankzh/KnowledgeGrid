package alankzh.leetcode.offer31.day1;

import java.util.LinkedList;
import java.util.Queue;

public class CQueue {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> reverse = new LinkedList<>();

    public CQueue() {
    }

    public void appendTail(int value) {
        if (reverse.size() <= 0) {
            queue.add(value);
        }

        while(reverse.size() > 0) {
            queue.add(reverse.poll());
        }

        queue.add(value);
    }

    public int deleteHead() {
        if (reverse.size () > 0) {
            return reverse.poll();
        }

        if (queue.size() <= 0) {
            return -1;
        }

        while(queue.size() > 0) {
            reverse.add(queue.poll());
        }

        return reverse.poll();
    }
}
