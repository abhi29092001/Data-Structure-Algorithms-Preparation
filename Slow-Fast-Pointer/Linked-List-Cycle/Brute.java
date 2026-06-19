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
    public static boolean hasCycle(ListNode head) {
        // Logic-
        // i'll keep an hashset which contains nodes, if there's a cycle then that node must be present in the hashset 
        // if so, will return true directly
        // if not then temp will reach null, loop will break
        // outside loop false will be returned 

        Set<ListNode> seen = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {
            if (seen.contains(temp)) {
                return true;
            } else {
                seen.add(temp);
                temp = temp.next;
            }
        }

        return false;
    }
}
