// TC -> O(n)
// SC -> O(n)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Recursive {
    public static ListNode reverseList(ListNode head) {
        // Logic is simple-
        // logic is same as of optimal solution, the only diff is it is done using recursion

        if (head == null || head.next == null) return head;

        return helper(null, head);
    }

    public static ListNode helper(ListNode prev, ListNode curr) {
        // base case - returning prev as its new head
        if (curr == null) return prev;

        // storing next node before changing pointer to prev node
        ListNode nextNode = curr.next;

        // changing node to prev
        curr.next = prev;
    
        return helper(curr, nextNode);
    }
}
