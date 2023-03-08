package com.wzy.sort;

/**
 * @author wzy
 * @date 2022年08月22日 23:07
 */
public class Sort {
    public static void main(String[] args) {

    }

    // 对冒泡排序和选择排序来说，数据状况不影响复杂度
    // 插入排序来说，数据状况会影响复杂度，在一些情况下会减少操作，最好的情况(排好序了)为O(N)，最差的情况为O(N^2)
    // 三种排序都是O(N^2)

    /**
     * 冒泡排序
     * @param arr 待排序数组
     */
    public void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[i + 1]){
                    swap(arr, i, i +1);
                }
            }
        }
    }

    /**
     * 选择排序，每次找到一个最小的放到第一个位置
     * @param arr 待排序数组
     */
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            // 最小值的位置
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序，类比打牌，依次使0-1 0-2 0-3 0-4.。。上有序
     * 对 1-n 上的数依次向前比，插入到合适的位置
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void swapHigher(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 随机数组产生器
     * @param maxSize 数组中最大值
     * @param maxValue 数组的最大长度
     * @return 一个随机数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize-1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
