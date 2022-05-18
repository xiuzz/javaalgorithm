package leetcode.day18;

import java.util.PriorityQueue;

public class LC295 {
     PriorityQueue<Integer> prevQueue;
     PriorityQueue<Integer> nextQueue;
	 public LC295() {
		 prevQueue=new PriorityQueue<>((a,b)->b-a);
		 nextQueue=new PriorityQueue<>();
	    } 
	    public void addNum(int num) {
            if(prevQueue.isEmpty()||num<=prevQueue.peek()) {
        		 prevQueue.offer(num);
            	if(prevQueue.size()>nextQueue.size()+1) {
            		nextQueue.offer(prevQueue.poll());
            	}
            }
            else {
            	nextQueue.offer(num);
            	if(nextQueue.size()>prevQueue.size()) {
            	   prevQueue.offer(nextQueue.poll());
            	}
            } 
	    }
	    
	    public double findMedian() {
              if(prevQueue.size()>nextQueue.size()) {
            	  return (prevQueue.peek()+(nextQueue.peek()-prevQueue.peek())/2.0);
              }
              return prevQueue.peek();
	    }
      
}
