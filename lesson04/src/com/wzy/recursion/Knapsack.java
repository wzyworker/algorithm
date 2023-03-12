package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年03月02日 23:24
 */
public class Knapsack {
    public static int getMaxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, 0, bag);
    }

    /**
     *
     * @param w 重量数组
     * @param v 价值数组
     * @param index 当前需要判断下标
     * @param alreadyW 已经具有的价值
     * @param bag 背包载重
     * @return 最大价值，返回-1表示没有这种方案，来到最后返回0表示
     */
    public  static int process(int[] w, int[] v, int index, int alreadyW, int bag) {
        if (alreadyW > bag) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }

        int p1 = process(w, v, index + 1, alreadyW, bag);
        int p2next = process(w, v, index + 1, alreadyW + w[index], bag);
        int p2 = -1;
        if (p2next != -1) {
            p2 = v[index] + p2next;
        }

        return Math.max(p1, p2);
    }

    /**
     *
     * @param w 重量数组
     * @param v 价值数组
     * @param index 当前需要判断下标，保证剩余空间不小于0
     * @param rest 剩余空间
     * @return 最大价值
     */
    public static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }

        int p1 = process(w, v, index + 1, rest);
        int p2 = -1;
        int p2Next = process(w, v, index + 1, rest - w[index]);
        if (p2Next != -1) {
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    public static int dpWay(int[] w, int[] v, int bag) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        // 数组默认初始化为0，无需进行初始化
        for (int index = N -1; index >= 0; index--) {
            for (int rest = 1; rest <= bag; rest++) {
                if (rest >= w[index]) {
                    dp[index][rest] = Math.max(dp[index + 1][rest], v[index] + dp[index + 1][rest - w[index]]);
                }
            }
        }
        return dp[0][bag];
    }
}
