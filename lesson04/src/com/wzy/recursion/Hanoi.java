package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年02月26日 22:26
 */
public class Hanoi {
    public static void hanoi1(int n) {
        leftToRight(n);
    }

    /**
     * 将汉诺塔的1~N层圆盘 从左 -> 右
     * @param n n层
     */
    public static void leftToRight(int n) {
        // base case 最简单的情况即一层的时候
        if (n == 1) {
            // 解释一下为什么是 1，而不是 n
            // base case这一步是递归的最深层（不需要再往下进行递归），完成后将向上返回结果
            System.out.println("Move 1 from left to right");
            return;
        }
        leftToMid(n - 1);
        System.out.println("Move"+ n +" from left to right");
        midToRight(n - 1);
    }

    private static void leftToMid(int n) {
        if (n == 1){
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move"+ n +" from left to mid");
        rightToMid(n - 1);
    }
    public static void rightToMid(int n) {
        if (n == 1){
            System.out.println("Move 1 from right to mid");
        }
        rightToLeft(n - 1);
        System.out.println("Move" + n +"from right to mid");
        leftToMid(n - 1);
    }
    public static void rightToLeft(int n){
        if (n == 1){
            System.out.println("Move 1 from right to left");
        }
        rightToMid(n - 1);
        System.out.println("Move"+ n +" from right to left");
        midToLeft(n - 1);
    }
    private static void midToRight(int n) {
        if (n == 1){
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move"+ n +" from mid to right");
        leftToRight(n - 1);
    }

    public static void midToLeft(int n) {
        if (n == 1){
            System.out.println("Move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("Move"+ n +" from mid to left");
        rightToLeft(n - 1);
    }

    public static void hanoi2(int n) {
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    public static void func(int n, String from, String to, String other){
        if (n == 1){
            System.out.println("Move 1 from " + from + "to " + to);
        }
        func(n - 1, from, other, to);
        System.out.println("Move " + n + "from " + from + "to " + to);
        func(n - 1, other, to, from);
    }
}
