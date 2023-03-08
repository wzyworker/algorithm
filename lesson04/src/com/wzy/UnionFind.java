package com.wzy;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author wzy
 * @date 2023年02月18日 23:23
 */
public class UnionFind {

    /*
    复杂度分析：
     */
    public static class Node<T> {
        T value;
        public Node(T t){
            value = t;
        }
    }

    public static class UnionSet<T> {
        public HashMap<T, Node<T>> nodes;
        // 节点的父节点，即向上指的节点
        public HashMap<Node<T>, Node<T>> parents;
        public HashMap<Node<T>, Integer> sizeMap;

        public UnionSet(List<T> values){
            for (T value : values) {
                Node<T> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 获取节点的最高节点，方法执行过后，处在同一个集合中同一条链上的节点，都统一指向最高节点
         * @param cur 当前结点
         * @return 返回cur的头结点
         */
        public Node<T> findFather(Node<T> cur) {
            Stack<Node<T>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }

            // 加快获取最高节点的速度，除了获取最高节点外的其他操作都是O(1)的，但findFather是该操作的瓶颈
            // 故做加速，将findFather的速度也变成O(1)，防止某次查找的代价太大
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public  boolean isSameSet(T a, T b){
            if (!nodes.containsKey(a) || nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(T a, T b){
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return;
            }
            Node<T> aHead = findFather(nodes.get(a));
            Node<T> bHead = findFather(nodes.get(b));

            if (aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<T> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<T> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
                /* 第二个优化，小集合挂在大集合上
                if (aSetSize >= bSetSize) {
                    parents.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                    sizeMap.remove(bHead);
                }else {
                    parents.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                    sizeMap.remove(aHead);
                }*/
            }
        }
    }
}
