package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年03月09日 22:20
 */
public class RobotWalk {
    public static int ways1(int N, int M, int K, int P){
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        return walk(N, M, K, P);
    }

    /**
     *
     * @param N 位置为1~N，固定参数
     * @param cur 当前位置， 可变参数
     * @param rest 剩余的步数， 可变参数
     * @param P 最终目标位置，固定参数
     * @return 当前在cur位置上，走完剩余的rest步，最终来到P位置的方法数
     */
    public static int walk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            return cur == P ? 1 : 0;
        }

        // 如果来到左边界只能向右走一步
        if (cur == 1) {
            return walk(N, 2, rest - 1, P);
        }

        if (cur == N) {
            return walk(N, N - 1, rest - 1, P);
        }

        return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
    }


    //// 现在想将所有(cur, rest)的组合保存起来
    public static int waysCache(int N, int M, int K, int P){
        if (N < 2 || K < 1 || M < 1 || M > N || P < 1 || P > N) {
            return 0;
        }
        // 所以有了下面的结构(0,X)位置弃用
        int[][] dp = new int[N+1][K+1];
        // 初始化缓存结构
        for (int row = 0; row <= N; row++) {
            for (int col = 0; col <= K; col++) {
                dp[row][col] = -1;
            }
        }
        return walkCache(N, M, K, P, dp);
    }

    public static int walkCache(int N, int cur, int rest, int P, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }

        // 如果来到左边界只能向右走一步
        if (cur == 1) {
            dp[cur][rest] = walkCache(N, 2, rest - 1, P, dp);
            return dp[cur][rest] ;
        }

        if (cur == N) {
            dp[cur][rest] = walkCache(N, N - 1, rest - 1, P, dp);
            return dp[cur][rest] ;
        }

        dp[cur][rest] = walkCache(N, cur + 1, rest - 1, P, dp) + walkCache(N, cur - 1, rest - 1, P, dp);
        return dp[cur][rest] ;
    }
}
