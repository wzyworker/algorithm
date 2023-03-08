package com.wzy;

import java.util.HashSet;

/**
 * @author wzy
 * @date 2023年02月15日 22:41
 */
public class LightOn {
    public static int minLight1(String road) {
        if (road == null || road.length() == 0){
            return 0;
        }
        return process(road.toCharArray(), 0, new HashSet<>());
    }

    /**
     * 从str[index] 开始做决定是否放灯，str[0...index]已经做过决定了
     * @param str 要放灯的街道
     * @param index 此次要决定的位置
     * @param lights 放了灯的位置（下标）集合
     * @return 能照亮整条街道的方案中最少的灯数
     */
    public static int process(char[] str, int index, HashSet<Integer> lights) {
        if (index == str.length){
            // 结束的时候，验证现在这种方案是否成立
            for (int i = 0; i < str.length; i++) {
                if (str[i] != 'X') {
                    if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i +1)){
                        return Integer.MAX_VALUE;
                    }
                }
            }
            return lights.size();
        }else {
            int no = process(str, index + 1, lights);
            int yes = Integer.MAX_VALUE;
            if (str[index] =='.'){
                lights.add(index);
                yes = process(str, index + 1, lights);
                lights.remove(index);
            }
            return Math.min(no, yes);
        }
    }

    /**
     *
     * @param road 待照亮的街道
     * @return 最少的灯数
     */
    public static int minLight2(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            }else {
                light++;
                if (index + 1 == str.length) {
                    break;
                }else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    }else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }
}
