package alankzh.introductiontoalgorithms;

public class Mergesort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,6,8,12,7,865};
        new Mergesort().mergesort(arr, 0, arr.length - 1);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
    }

    public void mergesort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = begin + (end - begin) / 2;
        mergesort(arr, begin, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private void merge(int[] arr, int begin, int mid, int end) {
        int[] left = new int[mid - begin + 1];
        int[] right = new int[end - mid];

        System.arraycopy(arr, begin, left, 0, left.length);
        System.arraycopy(arr, mid + 1, right, 0, right.length);

        int li = 0;
        int ri = 0;
        int index = begin;
        for ( ; ; index++) {
            if (li >= left.length) {
                break;
            }
            if (ri >= right.length) {
                break;
            }

            if (left[li] <= right[ri]) {
                arr[index] = left[li];
                li ++;
            } else {
                arr[index] = right[ri];
                ri ++;
            }
        }

        if (li < left.length) {
            System.arraycopy(left, li, arr, index, left.length - li);
        }
        if (ri < right.length) {
            System.arraycopy(right, ri, arr, index, right.length - ri);
        }
    }


}

