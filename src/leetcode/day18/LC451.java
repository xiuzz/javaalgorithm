package leetcode.day18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC451 {
  public String frequencySort(String s) {
         Map<String, Integer> map=new HashMap<String, Integer>();
         String[] strings=s.split("");
         for (String string : strings) {
			map.put(string, map.getOrDefault(string, 0)+1);
		}
      PriorityQueue<Comparable[]> heap=new PriorityQueue<>(new Comparator<Comparable[]>() {
    	  @Override
    	public int compare(Comparable[] o1, Comparable[] o2) {
    		return o2[1].compareTo(o1[1]);
    	}
	});
      for(Map.Entry<String, Integer> entry:map.entrySet()) {
    	  heap.offer(new Comparable[] {entry.getKey(),entry.getValue()});
      }
      StringBuilder builder=new StringBuilder();
      while(!heap.isEmpty()) {
    	  int loop=(Integer)heap.peek()[1];
    	 for (int i = 0; i < loop; i++) {
    		 builder.append(heap.peek()[0]);
		}
		 heap.poll();
      }
      return builder.toString();
	}
  public static void main(String[] args) {
	LC451 lc451=new LC451();
	System.out.println(lc451.frequencySort("tree"));
}
}
