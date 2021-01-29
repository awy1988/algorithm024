package Week_01;

public class Main {
    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
//        while (l1 != null) {
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
//        while (l2 != null) {
//            System.out.println(l2.val);
//            l2 = l2.next;
//        }
        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(l1,l2);
        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }
}