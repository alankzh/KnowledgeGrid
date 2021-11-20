package alankzh.hot100;

@Deprecated
/**
 * Manacher 算法未实现
 * https://zhuanlan.zhihu.com/p/70532099
 * */
public class LeetCode5 {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 1) return s;

        int begin = 0;
        int end = 0;
        for (int i=0; i<s.length(); i++) {
            int iex = extend(s, i, i);
            int i1ex = extend(s, i, i+1);

            int ibegin = 0;
            int iend = 0;
            if (iex > i1ex) {
                ibegin = i - (iex/2);
                iend = i + (iex/2);
            } else {
                ibegin = i - ( (i1ex - 1) / 2);
                iend = i + (i1ex / 2);
            }
            if (iend - ibegin > end - begin) {
                begin = ibegin;
                end = iend;
            }
        }

        return s.substring(begin, end + 1);
    }

    private int extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;
    }

}
