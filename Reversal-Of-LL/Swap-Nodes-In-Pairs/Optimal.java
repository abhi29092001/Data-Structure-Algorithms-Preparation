// TC -> O(n)
// SC -> O(1)

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Optimal {
    public ListNode swapPairs(ListNode head) {
        // Logic is Simple-
        // 1. take 3 pointers - prev, first, second
        // 2. put prev on dummy, first on prev next, second on prev next next
        // 3. swap first and second node, after swapping, prev next will be second and then put prev on first because first node needs to be corrected later on
        // 4. do this repeatedly until condition becomes false
        ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode prev = dummy;

       while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
       }

       return dummy.next;
    }    
}
