package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年03月08日 22:00
 */
public class NQueens {
    /**
     * N皇后问题的解决方案数
     * @param i 目前来到了第 i 行
     * @param record 表示之前的行的皇后的位置，纵坐标
     * @param n 总共的行数
     * @return 合理的摆法
     */
    public static int process1(int i, int[] record, int n) {
        // 之前n行的判断都成立
        if (i == n) {
            return 1;
        }
        int res = 0;
        // 当前在 i 行，从左到右尝试所有可能的结果
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static int getNum(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // 12皇后问题则表示，最后面12位都是1
        // 同时对32皇后问题的limit的优化
        int limit = n == 32 ? -1 : (1 << n) -1;
        return process2(limit, 0, 0, 0);
    }

    /**
     * N皇后问题位运算加速解法，
     * @param limit 问题的规模
     * @param colLim 列限制 1表示不能放皇后
     * @param leftLim 左斜线限制 1表示不能放皇后
     * @param rightLim 右斜线限制 1表示不能放皇后
     * @return N皇后的解
     */
    public static int process2(int limit, int colLim, int leftLim, int rightLim) {
        if (limit == colLim) {
            return 1;
        }

        // colLim | leftLim | rightLim 总限制，0可以放皇后，但limit前有大量无效的0，需要进行处理
        int pos = limit & (~(colLim | leftLim | rightLim));
        // 经过转化后，1表示可以放皇后

        int mostRightOne = 0;
        int res = 0;
        while (pos != 0){
            // 真正判断时，还是1的位置可以放皇后
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit,
                    colLim | mostRightOne,
                    (leftLim | mostRightOne) << 1,
                    (rightLim | mostRightOne) << 1);
        }
        // 中间某一步没有可以摆放的位置，会直接返回0
        return res;
    }
}
