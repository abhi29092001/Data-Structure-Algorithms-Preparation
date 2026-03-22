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
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Logic is Simple - 
        // 1. first I'm counting the nodes whether LL has atleast K nodes or not.
        // 2. if not then break the loop
        // 3. otherwise, reverse K nodes 
        // 4. after reversing, correct start point and end point. 

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;

        ListNode prev = null;
        ListNode curr = head;
        ListNode tail = head;

        while (true) {
            ListNode nodeChecker = start;

            for (int i = 0; i < k; i++) {
                if (nodeChecker != null) {
                    nodeChecker = nodeChecker.next;
                }
            }

            if (nodeChecker == null) {
                break;
            }

            for (int i = 0; i < k; i++) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            start.next = prev;
            start = tail;
            tail.next = curr;
            tail = curr;
            prev = null;
        }

        return dummy.next;
    }    
}
