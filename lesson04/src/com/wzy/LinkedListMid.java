package com.wzy;

/**
 * @author wzy
 * @date 2022年09月13日 21:56
 */
public class LinkedListMid {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 返回奇数链表的中点，偶数链表的上中点
     */
    public static Node midOrUpMidNode(Node head){
        // head为空，链表有一个节点或有两个节点
        // 专属定制
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }
        // 到这里，链表有3个或以上的节点
        // 专属定制
        Node slow = head.next;
        Node fast = head.next.next;

        // 下面是主逻辑，最终会让快慢指针分别来到链表的最后和链表的的中间部分，但具体是中间的哪里，需要边界条件的控制
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
