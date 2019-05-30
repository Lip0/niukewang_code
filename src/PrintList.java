import org.junit.Test;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList list=new ArrayList();
        if(listNode==null){
            return list;
        }
        ListNode prev=listNode.next;
        ListNode pcur=prev.next;
        while(pcur!=null){
            prev.next=pcur.next;
            pcur.next=listNode.next;
            listNode.next=pcur;
            pcur=prev.next;
        }
        pcur=listNode.next;
        while (pcur!=null){
            list.add(pcur.val);
            pcur=pcur.next;
        }
        return list;
    }
    @Test
    public void test(){
        ListNode node =new ListNode(-1);
        ListNode node1=new ListNode(67);
        ListNode node2=new ListNode(0);
        ListNode node3=new ListNode(24);
        ListNode node4=new ListNode(58);
        ListNode node5=new ListNode(5);
        node.next =node1;   node1.next=node2;
        node2.next=node3;   node3.next=node4;
        node4.next=null;    node5.next=null;
        ArrayList<Integer> list=printListFromTailToHead(node);
        System.out.println(list);

    }

}

class ListNode {
       int val;
       ListNode next = null;
       ListNode(int val) {
           this.val = val;
      }
}
