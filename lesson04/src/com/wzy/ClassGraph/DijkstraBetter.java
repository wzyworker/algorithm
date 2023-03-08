package com.wzy.ClassGraph;

import java.util.HashMap;

/**
 * @author wzy
 * @date 2023年02月22日 23:46
 */
public class DijkstraBetter {
    /*public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static class NodeHeap {
        private Node[] nodes;  // 实际的堆结构
        private HashMap<Node, Integer> heapIndexMap;  // 每一个Node在堆中的位置，若value为-1则说明节点需要被忽略，无需遍历堆
        private HashMap<Node, Integer> distanceMap;  // 从源节点出发到某个Node目前的最小距离
        private int size;  // 堆上有几个点
        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }
        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }

    }

    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, distance + edge.weight);
            }
            result.put(cur, distance);
        }
        return result;
    }*/
}
