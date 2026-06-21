// TC -> O(n)
// SC -> O(n)

import java.util.*;

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Brute {
    public ListNode detectCycle(ListNode head) {
        // Logic-
        // we'll keep track of nodes in set, if one node comes again then we can return directly coz that means there is a cycle and that node is the start of the cycle
        // if temp reaches null that means there is no cycle and return null at the end

        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> seen = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (seen.contains(temp)) {
                return temp;
            }
            seen.add(temp);
            temp = temp.next;
        }

        return null;
    }
}
