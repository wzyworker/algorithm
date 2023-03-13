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

    public static int dpWay(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
            // s表初始化默认0，省略
        }

        for (int i = 1; i < N; i++) {
            int row = 0;
            int col = i;
            while (row < N && col < N) {
                f[row][col] = Math.max(arr[row] + s[row + 1][col], arr[col] + s[row][col - 1]);
                s[row][col] = Math.min(f[row + 1][col], f[row][col - 1]);
                row++;
                col++;
            }
        }

        return Math.max(f[0][N - 1], s[0][N - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 100, 26};
        System.out.println(win1(arr));
        System.out.println(dpWay(arr));
    }
}
