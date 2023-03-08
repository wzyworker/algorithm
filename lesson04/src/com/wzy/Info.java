package com.wzy;

/**
 * @author wzy
 * @date 2022年09月28日 23:12
 */
public class Info {
    public Node maxSubBSTHead;
    public int maxSubBSTSize;
    public int max;
    public int min;

    public Info(Node maxSubBSTHead, int maxSubBSTSize, int max, int min) {
        this.maxSubBSTHead = maxSubBSTHead;
        this.maxSubBSTSize = maxSubBSTSize;
        this.max = max;
        this.min = min;
    }

    public static class Node {

    }
}
