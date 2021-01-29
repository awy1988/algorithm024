package Week_01;

public class Main {
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = initListNode(1);
        ListNode l2 = initListNode(2);

        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(l1,l2);
        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
        l1 = initListNode(1);
        l2 = initListNode(2);
        ListNode mergedListWithRecursion = mergeTwoSortedLists.mergeTwoListsWithRecursion(l1, l2);
        while (mergedListWithRecursion != null) {
            System.out.println(mergedListWithRecursion.val);
            mergedListWithRecursion = mergedListWithRecursion.next;
        }
    }

    private static ListNode initListNode(int listNo) {
        ListNode headNode = new ListNode(1);

        switch (listNo) {
            case 1:
                headNode.next = new ListNode(2);
                break;
            default:
                headNode.next = new ListNode(3);
                break;
        }
        headNode.next.next = new ListNode(4);

        return headNode;
    }
}