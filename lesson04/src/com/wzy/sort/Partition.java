package com.wzy.sort;

/**
 * @author wzy
 * @date 2022年09月01日 23:29
 */
public class Partition {

    /**
     * 以arr[R]为划分值得荷兰国旗问题
     * @param arr 待划分数组
     * @param L 划分的左边界
     * @param R 划分的右边界
     * @return 等于区的左边界和右边界
     */
    public static int[] netherLandsFlag(int[] arr, int L, int R){
        if (L > R){
            return new int[] {-1, -1};
        }
        if (L == R){
            return new int[] {L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < R){
            if (arr[index] == arr[R]){
                index++;
            }else if (arr[index] < arr[R]){
                swap(arr, ++less, index++);
            }else{
                // 此处不能让index自增，大于区左边的数没有被判断过
                swap(arr, index, --more);
            }
            swap(arr, more, R);
        }
        return new int[] {less +1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2)
        {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L >= R){
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M -1);
        process1(arr, M + 1, R);
    }

    private static int partition(int[] arr, int l, int r) {
        return 0;
    }

    /*private static int partition(int[] arr, int L, int R) {
        if (L > R){
            return 0;
        }
        if (L == R){
            return 0;
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < R){
            if (arr[index] == arr[R]){
                index++;
            }else if (arr[index] < arr[R]){
                swap(arr, ++less, index++);
            }else{
                // 此处不能让index自增，大于区左边的数没有被判断过
                swap(arr, index, --more);
            }
            swap(arr, more, R);
        }
    }*/
}
