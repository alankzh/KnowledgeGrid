package alankzh.leetcode.hot100;

/**
 * 经典之战
 * 核心要点:
 * 1. 中位数把两个数组分为左右两部分
 * 2. 边界问题，有数组取数数目可能为0，故搜索可以搜索到数组的length下标，index不取
 * 3. 左右移动判断问题，向左移动必定破坏了某些性质，向右移动也是一样
 * 4. 结果返回边界问题，由于数组最左和数组最右规定了为最小和最大，故不影响返回值的判断
 */
public class LeetCode4 {


    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double a = new LeetCode4().findMedianSortedArrays(nums1, nums2);
        System.out.println(a);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 == 0) {
            return findMedian(nums2);
        }
        if (l2 == 0) {
            return findMedian(nums1);
        }
        int l = l1 + l2;
        boolean isOdd = ((l % 2) != 0);
        int leftSize = (l + 1) / 2;

        int begin = 0;
        int end = l1;
        int index1 = 0;
        int index2 = 0;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2 ;
            index1 = mid;
            index2 = leftSize - index1;

            int match = compare(nums1, nums2, index1, index2);
            if (match == 0) {
                break;
            } else if (match == -1){
                end = mid - 1;
            } else if (match == 1) {
                begin = mid + 1;
            }
        }

        if (isOdd) {
            return Math.max(getFromArr(nums1, index1 - 1), getFromArr(nums2, index2 - 1));
        } else {
            int right = Math.min(getFromArr(nums1, index1), getFromArr(nums2, index2));
            int left = Math.max(getFromArr(nums1, index1 - 1), getFromArr(nums2, index2 - 1));
            return (double)(left + right) / 2;
        }
    }

    private double findMedian(int[] nums) {
        if ( (nums.length % 2) != 0)  {
            return nums[nums.length / 2];
        } else {
            return (double)(nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2;
        }
    }

    private int getFromArr(int[] arr, int i) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= arr.length) return Integer.MAX_VALUE;
        return arr[i];
    }

    // -1 表示需要左移，1表示需要右移，0表示匹配
    private int compare(int[] nums1, int[] nums2, int index1, int index2) {
        if (index2 < 0) {
            return  -1;
        }

        if (getFromArr(nums1, index1 - 1) <=  getFromArr(nums2, index2)
                && getFromArr(nums2, index2 - 1) <= getFromArr(nums1, index1)) {
            return 0;
        }
        if (getFromArr(nums1, index1 - 1) >=  getFromArr(nums2, index2)) {
            return -1;
        }

        return 1;
    }

}
