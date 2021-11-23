package alankzh.temp;

import java.util.*;

/**
 * Description:
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class YonghuiMeet1 {

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new YonghuiMeet1().solution(arr);
        System.out.println(result);
    }

    public List<List<String>> solution(String[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            String str = arr[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String newStr = new String(charArr);
            if (map.containsKey(newStr)) {
                List<String> list = map.get(newStr);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            result.add(list);
        }

        return result;
    }

}
