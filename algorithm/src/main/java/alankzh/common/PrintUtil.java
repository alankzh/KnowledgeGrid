package alankzh.common;

public class PrintUtil {
    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            if (i!=0){
                System.out.print(",");
            }
            System.out.print(array[i]);
        }
    }

    public static void printTwoDimensionalArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            printArray(array[i]);
            System.out.println();
        }
    }
}
