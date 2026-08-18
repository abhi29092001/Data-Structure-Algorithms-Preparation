// TC -> O(n + m)
// SC -> O(1)

public class Optimal {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Logic-
        // used two-pointer approach, easy to understand

        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        // if one list is exhausted but other one is still there or if both are exhausted
        curr.next = (list1 != null) ? list1 : list2;

        return dummyNode.next;
    }    
}
