package com.wzy.linkedList;

import java.util.HashSet;

/**
 * @author wzy
 * @date 2022年08月24日 22:03
 */
public class ReverseList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        HashSet<String> set = new HashSet<>();
        return pre;
    }
}
