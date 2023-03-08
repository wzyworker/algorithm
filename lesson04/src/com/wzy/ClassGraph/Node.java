package com.wzy.ClassGraph;

import java.util.ArrayList;

/**
 * 图中的点结构
 * @author wzy
 * @date 2023年02月20日 21:59
 */
public class Node {
    public int value;
    public int in;  // 连接到该点的点的数量
    public int out;  // 从其出发连接到的点的数量
    public ArrayList<Node> nexts;  // 从其出发连接到的点
    public ArrayList<Edge> edges;  // 从其出发的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
