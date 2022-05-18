package leetcode.day06;

import java.util.Arrays;

public class LC875 {
	public static void main(String[] args) {
	   int[] arr= {3,6,7,11};
	   System.out.println(minEatingSpeed(arr, 8));
	}
	 public static int minEatingSpeed(int[] piles, int h) {
         Arrays.sort(piles);
         int left=1;
         int right=piles[piles.length-1];
         int k=0;
       while(left<right) {
    	  k=(left+right)>>>1;
    	  int time=getTime(piles, k);
    	  if(time>h)left=k+1;
    	  else right=k;
       }
       return right;
	 }
	public static int getTime(int[] arr,int k) {
		int time=0;
		for (int i : arr) {
		    i=Math.max(i,k);
		    time+=(i%k==0?i/k:(i/k)+1);
		}
		return time;
	} 
}
