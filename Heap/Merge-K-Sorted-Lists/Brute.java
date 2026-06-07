// TC -> O(n logn)
// SC -> O(n)

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Brute {  
    public ListNode mergeKLists(ListNode[] lists) {
        // Logic-
        // Iterate through each node and store that in arraylist, sort arraylist and again create new LL and return its head

        int n = lists.length;

        // O(n) - space
        ArrayList<Integer> arr = new ArrayList<>();

        // O(n) - time
        for (int i = 0; i < n; i++) {
            ListNode temp = lists[i];

            while (temp != null) {
                arr.add(temp.val);
                temp = temp.next;
            }
        }

        if (arr.size() == 0) {
            return null;
        }

        // O(n logn) - time
        Collections.sort(arr);

        ListNode head = new ListNode(arr.get(0));
        ListNode curr = head;

        // O(n) - time & O(n) - space for new LL
        for (int i = 1; i < arr.size(); i++) {
            ListNode newNode = new ListNode(arr.get(i));
            curr.next = newNode;
            curr = curr.next;
        }

        return head;
    }
}
