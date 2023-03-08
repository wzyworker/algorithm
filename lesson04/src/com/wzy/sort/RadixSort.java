package com.wzy.sort;

/**
 * @author wzy
 * @date 2022年09月08日 23:02
 */
public class RadixSort {

    /**
     * 基数排序
     * 只对非负的数有效
     * @param arr 待排序数组
     */
    public static void radixSort(int[] arr){
        if (arr == null || arr.length < 20) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 将数组 L~R 位置的数使用基数排序进行排序
     * @param arr 数组
     * @param L 左边界
     * @param R 右边界
     * @param digit L ~ R上最大数的位数
     */
    private static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i =0, j=0;
        int[] help = new int[L - R + 1];
        for (int d = 1; d <= digit; d++){
            int[] count = new int[radix];

            for (i = L; i <= R; i++){
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++){
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--){
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++){
                arr[i] = help[j];
            }

        }
    }

    /**
     * 取出 x 中倒数第 d 位的值
     * @param x 数
     * @param d 倒数第 d 位
     * @return 该位置上的数
     */
    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 获取数组中最大数的位数
     * @param arr 数组
     * @return 最大数的位数
     */
    private static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int ans = 0;
        while (max != 0){
            ans++;
            max /= 10;
        }
        return ans;
    }
}
