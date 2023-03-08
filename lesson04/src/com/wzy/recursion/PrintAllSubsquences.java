package com.wzy.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wzy
 * @date 2023年02月27日 23:21
 */
public class PrintAllSubsquences {
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    /**
     * str固定
     * @param str 固定不变
     * @param index 现在需要考虑的下标，要 or 不要
     * @param ans 如果 index 来到终止位置，将沿途路径所形成的答案加到结果集中
     * @param path 考虑 index 位置前已经做出的决定所形成的路径
     */
    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        process1(str, index + 1, ans, path);
        String yes = path + String.valueOf(str[index]);
        process1(str, index + 1, ans, yes);
    }

    public static void process2(char[] str, int index, HashSet<String> set, String path){
        if (index == str.length){
            set.add(path);
            return;
        }
        process2(str, index + 1, set, path);
        String yes = path + String.valueOf(str[index]);
        process2(str, index + 1, set, path);
    }
}
