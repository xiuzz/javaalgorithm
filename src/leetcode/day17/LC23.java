package leetcode.day17;

import java.util.Comparator;
import java.util.PriorityQueue;
public class LC23 {
	public class ListNode {
		  int val;
		  ListNode next;
		  ListNode() {}
		  ListNode(int val) { this.val = val; }
		  ListNode(int val, ListNode next) { 
			  this.val = val; this.next = next; 
			  }
		  }
	 public ListNode mergeKLists(ListNode[] lists) {
           if(lists.length==0)return null;
           int len=lists.length;
           PriorityQueue<ListNode> minHeap=
        		   new PriorityQueue<>(len,Comparator.comparingInt(o->o.val));
           for (ListNode listNode : lists) {
                 if(listNode!=null)
                	 minHeap.offer(listNode);
		}
           ListNode ans=new ListNode(-1);
           ListNode curr=ans;
           while(!minHeap.isEmpty()) {
        	 ListNode top=minHeap.poll();
        	 curr.next=top;
        	 curr=curr.next;
        	 if(top.next!=null)
        		 minHeap.offer(top.next);
           }
           return ans.next;
	   }
}	
