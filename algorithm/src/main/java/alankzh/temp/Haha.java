package alankzh.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Haha {

    private static Map<Character, Integer> keyLine = new HashMap<>();

    static {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";

        int v = 'A' - 'a';

        for (char c : line1.toCharArray()) {
            keyLine.put(c, 1);
            keyLine.put((char)(c + v), 1);
        }
        for (char c : line2.toCharArray()) {
            keyLine.put(c, 2);
            keyLine.put((char)(c + v), 2);
        }
        for (char c : line3.toCharArray()) {
            keyLine.put(c, 3);
            keyLine.put((char)(c + v), 3);
        }
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"abdfs","cccd","a","qwwewm"};
        String[] result = new Haha().findWords(strArr);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();

        for (String str : words) {
            int line = 0;
            boolean add = true;

            for (char c : str.toCharArray()) {
                int l = keyLine.get(c);
                if (line == 0) {
                    line = l;
                }
                if (line != l) {
                    add = false;
                    break;
                }
            }

            if (add) {
                result.add(str);
            }
        }

        String[] re = new String[result.size()];
        if (result.size() <= 0) {
            return re;
        }
        return result.toArray(re);
    }

}
