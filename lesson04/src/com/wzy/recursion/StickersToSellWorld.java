package com.wzy.recursion;

import java.util.HashMap;

/**
 * @author wzy
 * @date 2023年03月15日 22:35
 */
public class StickersToSellWorld {
    public static int minS(String rest, String[] arr) {
        return 0;
    }

    public static int minStickers1(String[] stickers, String target) {
        int n = stickers.length;
        // 表示贴纸
        // 每张贴纸都有26个空间分别表示 a~z 每种字符的数量
        // 每次选贴纸时，其实是获取每种贴纸每种字符的数量，所以建立这样的一种数组形式
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char x : str) {
                map[i][x - 'a']++;
            }
        }

        // 缓存结构
        HashMap<String, Integer> dp = new HashMap<>();

        // 为什么“” 对应 0，因为target为“”时最少使用0张贴纸即可拼出target
        dp.put("", 0);

        return process1(dp, map, target);
    }

    /**
     * 唯一的可变参数 target
     * @param dp 傻缓存
     * @param map 贴纸集
     * @param rest 剩余字符串
     * @return 最少贴纸数
     */
    public static int process1(HashMap<String, Integer> dp, int[][] map, String rest) {
        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }

        // 正式的调用过程
        int ans = Integer.MAX_VALUE; // 拼出 rest 的最少贴纸数量
        int n = map.length; // n种贴纸

        // rest转换为词频
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for (char x : target) {
            tmap[x - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            // 枚举第一张使用的贴纸

            // 多次循环后，如果每张贴纸连target的第一个字符都搞定不了，则会退出循环，将ans赋值为-1
            // 防止出现死循环
            if (map[i][target[0] - 'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (tmap[j] > 0) {
                    // 使用了第i张贴纸后，j 字符还剩多少个，最少为 0，不存在负数
                    for (int k = 0; k < Math.max(0, tmap[j] - map[i][j]); k++) {
                        sb.append((char) (j + 'a'));
                    }
                }
            }

            String s = sb.toString();
            int tmp = process1(dp, map, s);
            if (tmp != -1) {
                ans = Math.min(ans, 1 + tmp);
            }
        }
        // ans

        dp.put(rest, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(rest);
    }

    public static void main(String[] args) {
        String[] strings = {"abc"};
        System.out.println(minStickers1(strings, "x"));
    }
}
