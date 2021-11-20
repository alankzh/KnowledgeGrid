package alankzh.temp;

import java.util.LinkedList;
import java.util.List;

public class LeetCode2059 {

    public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) {
            return 0;
        }
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int[] repeat = new int[1001];
        List<Pair> list = new LinkedList<>();
        list.add(new Pair(start, 0));
        while (list.size() > 0) {
            Pair p = list.remove(0);

            for (int i=0; i<nums.length; i++) {
                int r1 = addOrReturn(p.val + nums[i], list, goal, p.step, repeat);
                if (r1 != -1) return r1;
                int r2 = addOrReturn(p.val - nums[i], list, goal, p.step, repeat);
                if (r2 != -1) return r2;
                int r3 = addOrReturn(p.val ^ nums[i], list, goal, p.step, repeat);
                if (r3 != -1) return r3;
            }
        }

        return -1;
    }

    private int addOrReturn(int cur, List<Pair> list, int goal, int step, int[] repeat) {
        if (cur == goal) {
            return step + 1;
        }
        if (cur < 0 || cur > 1000) {
            return -1;
        }
        if (repeat[cur] == 0) {
            repeat[cur] = 1;
            list.add(new Pair(cur, step + 1));
        }
        return -1;
    }

    private static class Pair {
        private int val;
        private int step;
        public Pair(int v, int step) {
            this.val = v;
            this.step = step;
        }
    }

}
