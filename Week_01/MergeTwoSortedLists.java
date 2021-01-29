package Week_01;

public class MergeTwoSortedLists {
    /**
     * 迭代合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 迭代
        ListNode preHead = new ListNode();
        ListNode cursor = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            } else {
                cursor.next = l2;
                l2 = l2.next;
            }
            cursor = cursor.next;
        }
        cursor.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    /**
     * 递归合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsWithRecursion(ListNode l1, ListNode l2) {
        // 递归结束条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsWithRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsWithRecursion(l1, l2.next);
            return l2;
        }
    }
}