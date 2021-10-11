package alankzh.leetcode.offer31.day13;

public class Offer58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder stb = new StringBuilder();

        int fast = s.length() - 1;
        int slow = s.length() - 1;
        while (fast >= 0) {
            while (fast >= 0 && s.charAt(fast) != ' ') {
                fast = fast - 1;
            }
            stb.append(s.substring(fast + 1, slow + 1));
            if (fast >= 0 && s.charAt(fast) == ' ') {
                stb.append(" ");
            }
            while (fast >= 0 && s.charAt(fast) == ' ') {
                fast = fast - 1;
            }
            slow = fast;
        }
        return stb.toString();
    }
}
