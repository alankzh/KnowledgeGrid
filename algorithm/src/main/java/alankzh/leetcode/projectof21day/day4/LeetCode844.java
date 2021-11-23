package alankzh.leetcode.projectof21day.day4;


/**
 * 尝试使用双指针
 * done
 */
public class LeetCode844 {

    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrm#p";

        System.out.println(getReverse(s));
        System.out.println(getReverse(t));
    }

    public boolean backspaceCompare2(String s, String t) {
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;
        int count1 = 0;
        int count2 = 0;
        while (index1 >= 0 || index2 >= 0) {
            char sc = getFromIndex(s, index1);
            while (sc == '#' || count1 > 0) {
                if (sc == '#') {
                    count1 ++;
                } else {
                    count1 --;
                }
                index1 --;
                sc = getFromIndex(s, index1);
            }
            char tc = getFromIndex(t, index2);
            while (tc == '#' || count2 > 0) {
                if (tc == '#') {
                    count2 ++;
                } else {
                    count2 --;
                }
                index2 --;
                tc = getFromIndex(t, index2);
            }
            if (sc != tc) {
                return false;
            }
            index1 --;
            index2 --;
        }

        return true;
    }

    private char getFromIndex(String str, int index) {
        if (index < 0) {
            return '-';
        } else {
            return str.charAt(index);
        }
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
