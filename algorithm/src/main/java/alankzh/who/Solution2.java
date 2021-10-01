package alankzh.who;

public class Solution2 {

    public static void main(String[] args) {
        String str = "022";
        int result = new Solution2().solution(str);
        System.out.println(result);
    }

    public int solution(String S){
        // write your code in Java SE 8
        int result = 0;
        if (S == null || S.length() <= 0) {
            return result;
        }

        char[] arr = S.toCharArray();
        int sum = 0;
        for (char c : arr) {
            int v = Integer.parseInt(c + "");
            sum += v;
        }
        if (sum % 3 == 0) {
            result ++;
        }

        for (char c : arr) {
            int v = Integer.parseInt(c + "");
            for (int i=0; i<10; i++) {
                if (i == v) {
                    continue;
                }
                if ((sum - v + i ) % 3 == 0) {
                    result ++;
                }
            }
        }

        return result;
    }

}
