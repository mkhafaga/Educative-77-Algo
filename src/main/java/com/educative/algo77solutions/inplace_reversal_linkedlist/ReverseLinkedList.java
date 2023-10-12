package com.educative.algo77solutions.inplace_reversal_linkedlist;

public class ReverseLinkedList {
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.createLinkedList(new int[]{-1,2,-3,4});
        LinkedListNode reveredList = reverse(list.head);
        System.out.println(reveredList);
    }
}
