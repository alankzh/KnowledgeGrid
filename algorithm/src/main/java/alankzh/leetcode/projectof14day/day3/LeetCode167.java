package alankzh.leetcode.projectof14day.day3;

@Deprecated
/**
 * 二分查找和双指针都未应用上
 */
public class LeetCode167 {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        if (numbers == null) {
            return result;
        }

        for (int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }

        return result;
    }
}
