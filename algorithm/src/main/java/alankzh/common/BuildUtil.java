package alankzh.common;

public class BuildUtil {


    /**
     * 对于第i个数组元素 (注意不是下标)
     * parent = i/2 = i>>1
     * left = 2i
     * right = 2i + 1
     */
    public static TreeNode buildTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        for (int i=0; i<arr.length; i++) {
            
        }





        return null;
    }

}
