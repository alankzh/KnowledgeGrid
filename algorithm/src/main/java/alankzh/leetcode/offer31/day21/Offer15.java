package alankzh.leetcode.offer31.day21;

public class Offer15 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count ++;
        }
        return count;
    }

    // Integer.bitCount(i) 源码
    public int hammingWeight2(int n) {
        n=((n>>1)&0x55555555)+(n&0x55555555);
        n=((n>>2)&0x33333333)+(n&0x33333333);
        n=((n>>4)&0x0f0f0f0f)+(n&0x0f0f0f0f);
        n=((n>>8)&0x00ff00ff)+(n&0x00ff00ff);
        n=((n>>16)&0x0000ffff)+(n&0x0000ffff);
        return n;
    }

}
