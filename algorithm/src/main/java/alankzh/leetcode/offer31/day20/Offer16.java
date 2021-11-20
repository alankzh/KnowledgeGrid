package alankzh.leetcode.offer31.day20;

public class Offer16 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1.0) {
            return x;
        }

        long b = n;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }

        double res = 1;
        while(b > 0) {
            if ( (b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }

        return res;
    }

}
