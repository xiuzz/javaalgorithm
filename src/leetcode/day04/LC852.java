package leetcode.day04;

public class LC852 {
	 public int peakIndexInMountainArray(int[] arr) {
         int left=0;
         int right=arr.length-1;
       int mid=0;
     while(left<right) {
    	mid=(left+right)>>>1;
    	if(arr[mid]>arr[mid+1])right=mid;
    	if(arr[mid]>arr[mid-1])left=mid;
     }
     return right;
  }
}
