// TC -> O(n)
// SC -> O(1)

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Optimal {
    public ListNode detectCycle(ListNode head) {
        // Logic-
        // slow and fast pointers will move 1 and 2 step at a time
        // if there's a cycle they will definitely meet at some point
        // the point at which they meet from there we'll reset slow pointer and put it at head and move both pointers 1 step at a time
        // they will meet at start of the cycle
        // L -> distance from head to cycle start
        // K -> distance from cycle start to point at which they meet
        // slow covered distance -> L + K
        // fast covered distance -> 2 * (L + K) -> twice what slow covered
        // fast may also covered some cycle laps before meeting slow -> L+K+n*C
        // compare fast's equation -> 2*(L+K)=L+K+n*C
        // L=(n-1)*C + C-K
        // thats why this whole pointer resetting algo works

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return fast;
            }
        }

        return null;
    }
}
