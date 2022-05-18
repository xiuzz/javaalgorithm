package leetcode.day05;

import java.util.Arrays;

public class LC1300 {
	  public int findBestValue(int[] arr, int target) {
          Arrays.sort(arr);
         int left=1;
         int right=arr[arr.length-1];
        while(left<right) {
            int mid=(left+right)>>>1;
            int sum=getSum(arr, mid);
           if(sum<target)left=mid+1;
           else right=mid;
        }
       int sum1=getSum(arr, right-1);
       int sum2=getSum(arr, right);
       if(sum2-target>=target-sum1) return right-1;
       else return right;
	  }
	 public  static int  getSum(int[] arr,int mid) {
		 int sum=0;
		 for (int i : arr) {
	   			sum+=Math.min(mid, i);
	   		}
		return sum; 
	 }  
}
