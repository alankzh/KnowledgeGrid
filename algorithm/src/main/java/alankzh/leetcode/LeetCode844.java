package alankzh.leetcode;

@Deprecated
/**
 * 尝试使用双指针
 */
public class LeetCode844 {

    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrm#p";

        System.out.println(getReverse(s));
        System.out.println(getReverse(t));
    }

    public static boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        String rvs = getReverse(s);
        String rvt = getReverse(t);

        return rvs.equals(rvt);
    }

    private static String getReverse(String s) {
        char[] scArr = s.toCharArray();

        StringBuilder strs = new StringBuilder();
        int delCount = 0;
        for (int i=scArr.length-1; i>=0; i--){
            char c = scArr[i];
            if (c == '#') {
                delCount ++;
            } else if (delCount > 0) {
                delCount --;
            } else {
                strs.append(c);
            }
        }
        return strs.toString();
    }

}
