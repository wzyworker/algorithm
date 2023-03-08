package com.wzy.ClassGraph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wzy
 * @date 2023年02月20日 22:07
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
