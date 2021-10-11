package alankzh.leetcode.offer31.day5;

public class Offer11 {
    public int minArray(int[] number) {
        if (number == null || number.length <= 0) {
            throw new RuntimeException("illegal input");
        }

        int l = 0;
        int r = number.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (number[m] < number[r]) {
                r = m;
            } else if (number[m] > number[r]) {
                l = m + 1;
            } else if (number[m] == number[r]) {
                r = r - 1;
            }
        }

        return number[l];
    }
}
