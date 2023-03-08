package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年03月06日 23:24
 */
public class CardsGame {
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // A先手获得的分数
        int scoreA = f(arr, 0, arr.length - 1);
        // B为后手，则B获得的分数
        int scoreB = s(arr, 0, arr.length - 1);
        return Math.max(scoreA, scoreB);
    }

    /**
     * 先手函数
     * @param arr 牌堆
     * @param L 左边界
     * @param R 右边界
     * @return 先手情况下的最大分数
     */
    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    /**
     * 后手函数
     * @param arr 牌堆
     * @param L 左边界
     * @param R 右边界
     * @return 后手情况下可获得点的最大分数
     */
    public static int s(int[] arr, int L, int R) {
        if (L == R){
            return 0;
        }
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }
}
