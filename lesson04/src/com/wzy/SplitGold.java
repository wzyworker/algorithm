package com.wzy;

import java.util.PriorityQueue;

/**
 * @author wzy
 * @date 2023年02月16日 22:56
 */
public class SplitGold {

    /*public static int lessMoney1(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return process(arr, 0);
    }*/

   /* public static int process(int[] arr, int pre){
        if (arr.length == 1){
            return pre;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans = Math.min(ans, process(copyAndMerageTwo(arr, i, j)), )
            }
        }
    }*/

    public static int lessMoney2(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while(pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum = sum + cur;
            pQ.add(cur);
        }
        return sum;
    }
}
