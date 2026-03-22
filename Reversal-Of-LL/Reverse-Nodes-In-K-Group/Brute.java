// TC -> O(n)
// SC -> O(n)

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Brute {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // Logic is Simple - 
        // 1. count len of LL
        // 2. create arr of that len
        // 3. put nodes value in that arr
        // 4. create 3 pointers - i , j, curr
        // 4. i and j will be used for swapping and curr will be placed at j's position to remember that pos because after swapping k values we need to start from next pos of j where curr is placed
        // 5. after swapping create new LL from arr

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int len = 0;

        // count length of LL
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // create arr of LL's length
        int[] arr = new int[len];
        temp = head;
        int i = 0;

        // traverse LL and put nodes value in arr
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }

        // 3 pointers for swapking k values in arr
        i = 0;
        int j = k - 1;
        int curr = j;

        // swapping logic of k values in arr
        while (i < len && j < len) {
            while (i < j) {
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
                j--;
            }

            i = curr + 1;
            j = i + k - 1;
            curr = j;
        }

        // create new LL from swapped values
        head = new ListNode(arr[0]);
        i = 1;
        temp = head;
        while (i < len) {
            ListNode node = new ListNode(arr[i]);
            temp.next = node;
            temp = temp.next;
            i++;
        }

        return head;
    }
}
