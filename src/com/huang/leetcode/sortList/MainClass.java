package com.huang.leetcode.sortList;

import com.huang.leetcode.removeNthFromEnd.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


//class Solution {
//    public ListNode sortList(ListNode head) {
//        ListNode listNode ,listNode1;
//        listNode = head;
//        listNode1 = head;
//        int tem = 0;
//        ArrayList<Integer> sites = new ArrayList<Integer>();
//        while (listNode != null){
//            sites.add(listNode.val);
//            listNode = listNode.next;
//        }
//        sites.sort(Comparator.naturalOrder());
//        while (listNode1 != null){
//            listNode1.val = sites.get(tem);
//
//            listNode1 = listNode1.next;
//            tem++;
//        }
//        return head;
//    }
//}

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode listNode, listNode1;
        listNode = head;
        listNode1 = head;
        int tem = 0;

        while (listNode1 != null) {
            while (listNode.next != null) {
                if (listNode.val > listNode.next.val) {
                    tem = listNode.next.val;
                    listNode.next.val = listNode.val;
                    listNode.val = tem;
                }else{
                    listNode.next = listNode.next.next;
                }
            }
            listNode1 = listNode1.next;
        }
        return head;
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}