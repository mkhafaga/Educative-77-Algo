package com.educative.algo77solutions.inplace_reversal_linkedlist;

import java.util.*;
// Template for the linked list
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    @Override public String toString() {
        StringBuffer sb = new StringBuffer("[");
        LinkedListNode current = head;
        while(current != null){
            sb.append(head.data);
            sb.append(",");
            current = current.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        return sb.toString();
    }
}
