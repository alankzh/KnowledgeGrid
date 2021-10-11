package alankzh.leetcode.offer31.day3;

public class Offer58 {

    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        String result = new Offer58().reverseLeftWords(str, n);
        System.out.println(result);
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        int length = s.length();
        int rn = n % length;

        int count = 0;
        char[] arr = s.toCharArray();
        for (int i=0; i<length; i++) {
            int cur = i;

            char temp = arr[i];
            while (true) {
                if (count == length) {
                    break;
                }
                count ++;

                int next = (cur + rn) % length;
                if (next == i) {
                    arr[cur] = temp;
                    break;
                }

                arr[cur] = arr[next];
                cur = next;
            }
        }

        return new String(arr);
    }

}
