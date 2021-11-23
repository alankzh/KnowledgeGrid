package alankzh.leetcode.projectof21day.day4;

import alankzh.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class LeetCode986 {
    public static void main(String[] args) {
        int[][] first = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] second = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        int[][] result = new LeetCode986().intervalIntersection2(first, second);
        PrintUtil.printTwoDimensionalArray(result);
    }

    public int[][] intervalIntersection2(int[][] firstList, int[][] secondList) {
        int index1 = 0;
        int index2 = 0;
        List<int[]> result = new ArrayList<>();
        while (index1 < firstList.length && index2 < secondList.length) {
            int[] first = firstList[index1];
            int[] second = secondList[index2];
            int c = Integer.compare(first[first.length - 1], second[second.length - 1]);
            int[] s = mixed2(first, second);
            if (s != null) {
                result.add(s);
            }
            if (c == 0) {
                index1 ++;
                index2 ++;
            } else if (c == -1) {
                index1 ++;
            } else {
                index2 ++;
            }
        }

        int[][] list = new int[result.size()][];
        return result.toArray(list);
    }

    private int[] mixed2(int[] first, int[] second) {
        int right = Math.min(first[first.length -1], second[second.length - 1]);
        int left = Math.max(first[0], second[0]);
        if (left > right) {
            return null;
        } else {
            return new int[]{left, right};
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int idxF = 0;
        int idxS = 0;

        List<int[]> result = new ArrayList<>();

        for ( ; idxF < firstList.length && idxS < secondList.length; ) {

            int[] cf = firstList[idxF];
            int[] cs = secondList[idxS];

            int[] mixedList = mixed(cf, cs);
            if (mixedList != null) {
                result.add(mixedList);
            }

            int c = compareLimit(cf, cs);
            if (c < 0) {
                idxF ++;
            } else if (c == 0) {
                idxF ++;
                idxS ++;
            } else {
                idxS ++;
            }
        }

        return list2Arr(result);
    }

    private static int[] mixed(int[] cf, int[] cs) {
        int lowF = cf[0];
        int highF = cf[cf.length - 1];
        int lowS = cs[0];
        int highS = cs[cs.length - 1];

        if (lowF > highS || lowS > highF) {
            return null;
        }

        int min = lowF <= lowS ? lowS : lowF;
        int max = highF <= highS ? highF : highS;

        return new int[]{min, max};
    }

    private static int compareLimit(int[] cf, int[] cs) {
        return Integer.compare(cf[cf.length-1], cs[cs.length-1]);
    }

    private static int[][] list2Arr(List<int[]> list) {
        int[][] arr = new int[list.size()][];
        for (int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }



}
