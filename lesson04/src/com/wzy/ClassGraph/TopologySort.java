package com.wzy.ClassGraph;

import java.util.*;

/**
 * 因为有了入度的概念，在拓扑排序中不需要删除变
 * @author wzy
 * @date 2023年02月20日 23:37
 */
public class TopologySort {

    public static List<Node> sortedTopology(Graph graph) {
        // key: 某一个Node
        // value: 这个Node的当前入度
        HashMap<Node, Integer> inMap = new HashMap<>();

        Queue<Node> zeroInQueue = new LinkedList<>();

        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) - 1 == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
