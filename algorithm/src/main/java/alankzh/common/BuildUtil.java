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

        linkTree(arr, root, 1);

        return root;
    }

    private static void linkTree(Integer[] arr, TreeNode cur, int i) {
        int left = i*2 - 1;
        int right = i*2;
        if (left < arr.length && arr[left] != null) {
            cur.left = new TreeNode(arr[left]);
            linkTree(arr, cur.left, left + 1);
        }
        if (right < arr.length && arr[right] != null) {
            cur.right = new TreeNode(arr[right]);
            linkTree(arr, cur.right, right + 1);
        }
    }

}
