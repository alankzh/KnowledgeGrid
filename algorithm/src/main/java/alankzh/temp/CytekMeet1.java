package alankzh.temp;

public class CytekMeet1 {

    public static void main(String[] args) {
        String str = "abcdefg";

        String result = new CytekMeet1().reverse2(str);
        System.out.println(result);
    }


    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        char[] charArr = str.toCharArray();
        StringBuilder stb = new StringBuilder();
        for (int i=charArr.length - 1; i>=0; i--) {
            stb.append(charArr[i]);
        }

        return stb.toString();
    }

    public String reverse2(String str) {
        if (str == null) {
            return null;
        }
        char[] charArr = str.toCharArray();

        int swapIndex = charArr.length - 1;
        for (int i=0; i<charArr.length/2; i++, swapIndex--) {
            char temp = charArr[i];
            charArr[i] = charArr[swapIndex];
            charArr[swapIndex] = temp;
        }

        return new String(charArr);
    }

}
