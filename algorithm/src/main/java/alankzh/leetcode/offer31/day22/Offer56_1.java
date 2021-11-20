package alankzh.leetcode.offer31.day22;

import java.util.ArrayList;
import java.util.List;

public class Offer56_1 {

    public int[] singleNumbers(int[] nums) {
        int v = nums[0];
        for (int i = 1; i < nums.length; i++) {
            v ^= nums[i];
        }

        int flag = v & (-v);
        int res1 = 0;
        for (int i=0; i< nums.length; i++) {
            if ((nums[i] & flag) != 0) {
                res1 ^= nums[i] ;
            }
        }

        System.out.println(v + "," + flag + "," + res1);



        return new int[]{res1, (v ^ res1)};
    }

    public static void main(String[] args) {
        char c = 'b';
        int v = 'A' - 'a';

        List<String> result = new ArrayList<>();
        result.toArray();

        System.out.println((char)(c + v));
    }

}
