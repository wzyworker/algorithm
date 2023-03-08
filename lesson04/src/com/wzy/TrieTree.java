package com.wzy;

/**
 * 前缀树
 * @author wzy
 * @date 2022年09月07日 22:02
 */
public class TrieTree {
    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1(){
            pass = 0;
            end = 0;
            // 有没有下一条路是否存在，判断Node1[n]是否为空
            // 当字符串数组的字符种类较小时，可以使用数组，
            // 当字符种类较多时，使用 HashMap<Integer, Node> Integer 为Ascll Node为下一个节点
            nexts = new Node1[26];
        }
    }

    public static class Trie1{
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word){
            if (word == null){
                return;
            }
            char[] chars = word.toCharArray();
            Node1 curNode = root;
            curNode.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (curNode.nexts[index] == null){
                    curNode.nexts[index] = new Node1();
                }
                curNode = curNode.nexts[index];
                curNode.pass++;
            }
            curNode.end++;
        }

        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] chars = word.toCharArray();
            Node1 curNode = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (curNode.nexts[index] == null){
                    return 0;
                }
                curNode = curNode.nexts[index];
            }
            return curNode.end;
        }

        public int preFixNumber(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            Node1 curNode = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (curNode.nexts[index] == null){
                    return 0;
                }
                curNode = curNode.nexts[index];
            }
            // 这里是pass
            return curNode.pass;
        }

        public void delete(String word){
            if (search(word) != 0){
                char[] chars = word.toCharArray();
                Node1 curNode = root;
                curNode.pass--;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    // 不用判断，一定不为空
                    /*if (curNode.nexts[index] != null){
                        curNode.pass--;
                    }*/
                    // 小加速
                    if (--curNode.nexts[index].pass == 0){
                        curNode.nexts[index] = null;
                        return;
                    }
                    curNode = curNode.nexts[index];
                }
                curNode.end--;
            }
        }
    }
}
