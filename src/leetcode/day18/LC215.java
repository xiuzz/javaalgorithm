package leetcode.day18;
import java.util.PriorityQueue;

public class LC215 {
	public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minHeap=new PriorityQueue<>(k);
       for (int i = 0; i < k; i++) {
		minHeap.offer(nums[i]);
	}
       for (int i = k; i < nums.length; i++) {
		if(nums[i]>minHeap.peek()) {
			minHeap.poll();
			minHeap.offer(nums[i]);
		}
	}
    return minHeap.peek();   
   }
}
