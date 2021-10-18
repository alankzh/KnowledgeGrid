package alankzh.introductiontoalgorithms.datastucture;

/**
 * 最大堆
 *
 * 关注算法问题:  找数组中前k大的数； 合并k个有序链表
 *
 * max-heapify, 负责维护堆性质，复杂度为O(lgn)
 * build-max-heap, 建堆过程，具有线性复杂度，
 * heap-sort, 需要用到最大堆，时间复杂度为O(nlgn),功能是对数组进行原址排序
 *
 * max-heap-insert, heap-extract-max,heap-increase-key,heap-maximum过程，
 * 时间复杂度为O(lgn), 过程是利用堆实现一个优先队列
 *
 *
 */
public class MaxHeap {

    int[] arr;

    int size;

    public MaxHeap() {
        arr = new int[8];
    }

    public MaxHeap(int[] arr) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        buildHead();
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        // 建堆
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = maxHeap.size - 1; i > 1; i -- ) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeap.size --;
            maxHeap.heapfipy(0);
        }
    }

    public void insert(int x) {
        if (arr.length == size) {
            // 扩容
            int[] newarr = new int[arr.length * 2];
            System.arraycopy(arr, 0, newarr, 0, arr.length);
            arr = newarr;
        }

        arr[size] = Integer.MIN_VALUE;
        size ++;
        increaseKey(size, x);
    }

    public int max() {
        if (size <= 0) {
            throw new RuntimeException("empty max heap");
        }

        return arr[0];
    }

    public int extractMax() {
        if (size <= 0) {
            throw new RuntimeException("empty max heap");
        }

        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size --;
        heapfipy(0);

        return temp;
    }

    private void increaseKey(int i, int k) {
        if (i >= size) {
            throw new RuntimeException("illegal index i");
        }
        if (arr[i] > k) {
            throw new RuntimeException("new k is smaller than current key");
        }

        arr[i] = k;
        while (i > 0 && arr[parent(i)] < k) {
            int p = parent(i);
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }

    // 建堆 时间复杂度为O(n)
    private void buildHead() {
        size = arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapfipy(i);
        }
    }

    // 维护堆性质
    private void heapfipy(int i) {
        int lg = i;

        int l = left(i);
        if (l < size && arr[l] > arr[i]) {
            lg = l;
        }

        int r = right(i);
        if (r < size && arr[r] > arr[lg]) {
            lg = r;
        }

        if (lg != i) {
            int temp = arr[i];
            arr[i] = arr[lg];
            arr[lg] = temp;
            heapfipy(lg);
        }
    }

    private int parent(int i) {
        return ((i + 1) / 2) - 1;
    }

    private int left(int i) {
        return 2 * (i + 1) - 1;
    }

    private int right(int i) {
        return 2 * (i + 1);
    }

}
