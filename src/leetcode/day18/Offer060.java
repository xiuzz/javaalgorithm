package leetcode.day18;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/*
 *值得写感言的题，md，
 *太抽象了这b题，
 *首先题目本身不复杂,
 *统计频率前k高的元素，
 *只需要先用hash记一下每一个的频率，再用堆原理就行了。（感觉堆原理有一种“名落孙山”的感觉，小于孙山的就没了）
 *然后这道题为什么恶心。首先是hash填充时候，第一次知道getOrDefault方法，然后就是优先队列的比较器这里
 *不会lamda表达式，只能重写抽象函数的compare方法了，然后就是泛型居然支持数组泛型，以及太久没用过entrySet了快忘了md */
public class Offer060 {
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : nums) {
			map.put(i, map.getOrDefault(i,0)+1);
		}
      PriorityQueue<int[]>  minHeap=new  PriorityQueue<>(new Comparator<int[]>() {
    	  @Override
    	public int compare(int[] o1, int[] o2) {
    		return o1[1]-o2[1];
    	} 
	});
      for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
    	   if(minHeap.size()>=k) {
    		   if(minHeap.peek()[1]<entry.getValue()) {
    			   minHeap.poll();
    			   minHeap.offer(new int[] {entry.getKey(),entry.getValue()});
    		   }
    	   }
    	   else {
    		   minHeap.offer(new int[] {entry.getKey(),entry.getValue()});
    	   }
      }
      int[] ans=new int[k];
    for (int i = 0; i < ans.length; i++) {
		ans[i]=minHeap.poll()[0];
	}
    return ans;
    }
}
