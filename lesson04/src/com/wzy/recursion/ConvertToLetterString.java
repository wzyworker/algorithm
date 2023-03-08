package com.wzy.recursion;

/**
 * @author wzy
 * @date 2023年03月02日 22:29
 */
public class ConvertToLetterString {

    public static int number(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        return process(str.toCharArray(), 0);
    }
    /**
     * str[0...i-1]已经转化完了，固定了
     * @param str 要转化的字符串
     * @param i 现在从 i 开始往后判断有多少转化的结果
     * @return 转化的数量
     */
    public static int process(char[] str, int i) {
        if (i == str.length) {
            return  1;
        }
        // 0没有办法转化，后面的都不用往后判断了
        // 也是一种分支限界
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1);
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= 6)){
                res += process(str, i + 2);
            }
            return res;
        }
        return process(str, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(number("11"));
    }
}
