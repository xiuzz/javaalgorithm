package leetcode.day18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {
	public static int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<int[]>() {
           	@Override
           	public int compare(int[] o1, int[] o2) {
           		Double a=Math.sqrt(Math.pow(o1[0], 2)+Math.pow(o1[1], 2));
           		Double b=Math.sqrt(Math.pow(o2[0], 2)+Math.pow(o2[1], 2));
           		return b.compareTo(a);
           	}        	
       });
       for (int[] is : points) {
		  if(heap.size()>=k){
	    double temp=Math.sqrt(Math.pow(is[0], 2)+Math.pow(is[1], 2));
		double peek=Math.sqrt(Math.pow(heap.peek()[0], 2)+Math.pow(heap.peek()[1], 2));
			  if(temp<peek) {
				  heap.poll();
				  heap.offer(is);
			  }
		  }
		  else {
			  heap.offer(is);
		  }
	}
      int[][] res=new int[k][2];
      for (int i = 0; i < k; i++) {
		 int[] temp=heap.poll();
		 res[i]=temp;
	}
      return res;
    }
	public static void main(String[] args) {
		int[][] arr= {{1,3},{-2,2}};
		System.out.println(Arrays.toString(kClosest(arr, 1)));
	}
}
