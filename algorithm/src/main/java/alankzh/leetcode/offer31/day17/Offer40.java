package alankzh.leetcode.offer31.day17;

import alankzh.leetcode.offer31.day15.Offer34;

import java.util.Comparator;
import java.util.PriorityQueue;

@Deprecated
/**
 * 利用快排思想未做
 */
public class Offer40 {


    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        priorityQueue.poll();

        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        int k = 8;
        new Offer40().getLeastNumbers(arr, 8);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] heap = new int[k];
        if (k <= 0) {
            return heap;
        }
        System.arraycopy(arr, 0, heap, 0, k);
        printArr(heap);
        buildHeap(heap);
        printArr(heap);

        for (int i=k; i<arr.length; i++) {
            compareAndReplaceMax(heap, arr[i]);
        }

        return heap;
    }

    private void printArr(int[] heap) {
        for (int i=0; i<heap.length; i++) {
            System.out.print(heap[i] + ",");
        }
        System.out.println();
    }

    private void compareAndReplaceMax(int[] arr, int v) {
        int max = arr[0];
        if (v >= max) {
            return;
        }

        arr[0] = v;
        heapify(arr, 0);
    }

    private void buildHeap(int[] arr) {
        for (int i=arr.length/2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int i) {
        int lgIndex = i;
        int l = left(i);
        int r = right(i);
        if (l < arr.length && arr[l] > arr[i]) {
            lgIndex = l;
        }
        if (r < arr.length && arr[r] > arr[lgIndex]) {
            lgIndex = r;
        }

        if (lgIndex != i) {
            int temp = arr[i];
            arr[i] = arr[lgIndex];
            arr[lgIndex] = temp;

            heapify(arr, lgIndex);
        }
    }

    private int parent(int i) {
        return (i+1)/2 - 1;
    }

    private int left(int i) {
        return (2 * (i+1)) - 1;
    }

    private int right(int i) {
        return 2 * (i+1);
    }

}
