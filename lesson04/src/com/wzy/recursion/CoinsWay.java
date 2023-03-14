package com.wzy.recursion;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wzy
 * @date 2023年03月13日 23:32
 */
public class CoinsWay {
    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        return process(arr, 0, aim);
    }

    /**
     * 可以自由使用arr[i...]的值任意次，凑出aim的方法数为多少
     * @param arr 数组
     * @param index 从index往后数组中的值可以任意使用
     * @param rest 要到达rest的目标
     * @return 方法数
     */
    public static int process(int[] arr, int index, int rest) {
        /*if (rest < 0) {
            return 0;
        }*/
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <=rest; zhang++) {
            // 子过程中rest已严格控制不小于0，故base case的第一部分不需要
            ways += process(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return memoryWay(arr, 0, aim, dp);
    }
    public static int memoryWay(int[] arr, int index, int rest, int[][] dp) {
        // 先查有没有
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }

        if (index == arr.length) {
            // 返回前先存值
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <=rest; zhang++) {
            // 子过程中rest已严格控制不小于0，故base case的第一部分不需要
            // 任何一个位置都需要底下一行的值
            ways += memoryWay(arr, index + 1, rest - (zhang * arr[index]), dp);
        }
        // 返回前先存值
        dp[index][rest] = ways;
        return dp[index][rest];
    }

    public static int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // 初始化
        dp[N][0] = 1; // 其它位置都是0

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <=rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }
}
