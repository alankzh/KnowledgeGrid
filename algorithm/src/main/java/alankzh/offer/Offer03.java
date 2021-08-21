package alankzh.offer;

import java.util.Arrays;

/**
 * 1. 排序后再查找
 * 2. 用hashmap缓存
 * 3. 数字在 0~n-1的范围内，可以用位图。
 * 4. 若要求不使用额外空间，且不改变原来的数组，那么可以使用二分查找，以m为分段，每次遍历统计数量，数量超过0~m，则为存在重复数字。
 */
public class Offer03 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};

        Offer03 solution = new Offer03();
        int n = solution.findRepeatNumber3(arr);
        System.out.println(n);
    }

    // 排序后再查找
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int j = i+1;
            if (j < nums.length && nums[i] == nums[j]) {
                return nums[i];
            }
        }

        return -1;
    }

    /**
     * 将每个数字交换到它所属的下标，若该下标的数值已经存在跟下标匹配的数字，则为重复数字，返回。
     */
    public int findRepeatNumber3(int[] nums){
        for (int i=0; i<nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            int iIndex = nums[i];
            if (nums[i] == nums[iIndex]) {
                return iIndex;
            } else {
                int temp = nums[i];
                nums[i] = nums[iIndex];
                nums[iIndex] = temp;
            }
        }

        return -1;
    }

}
