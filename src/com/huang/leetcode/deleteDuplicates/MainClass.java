///* -----------------------------------
// *  WARNING:
// * -----------------------------------
// *  Your code may fail to compile
// *  because it contains public class
// *  declarations.
// *  To fix this, please remove the
// *  "public" keyword from your class
// *  declarations.
// */
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//
//
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//
//
//        if(head==null || head.next == null){
//            return head;
//        }
//        ListNode head1 = new ListNode(head.val ,head.next);
//        while (head.next != null){
//            int a1 = head.val;
//            int b1 = head.next.val;
//            if(a1 == b1){
//                if(head.next !=null){
//                    head.next = head.next.next;
//                    head1.next = head.next.next;
//                }
//            }
//            head = head.next;
//        }
//        return head1;
//    }
//
//}
//
//class MainClass {
//    public int[] stringToIntegerArray(String input) {
//        input = input.trim();
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return new int[0];
//        }
//
//        String[] parts = input.split(",");
//        int[] output = new int[parts.length];
//        for(int index = 0; index < parts.length; index++) {
//            String part = parts[index].trim();
//            output[index] = Integer.parseInt(part);
//        }
//        return output;
//    }
//
//    public static ListNode stringToListNode(String input) {
//        // Generate array from the input
//        int[] nodeValues = stringToIntegerArray(input);
//
//        // Now convert that list into linked list
//        ListNode dummyRoot = new ListNode(0);
//        ListNode ptr = dummyRoot;
//        for(int item : nodeValues) {
//            ptr.next = new ListNode(item);
//            ptr = ptr.next;
//        }
//        return dummyRoot.next;
//    }
//
//    public static String listNodeToString(ListNode node) {
//        if (node == null) {
//            return "[]";
//        }
//
//        String result = "";
//        while (node != null) {
//            result += Integer.toString(node.val) + ", ";
//            node = node.next;
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            ListNode head = stringToListNode(line);
//
//            ListNode ret = new Solution().deleteDuplicates(head);
//
//            String out = listNodeToString(ret);
//
//            System.out.print(out);
//        }
//    }
//}