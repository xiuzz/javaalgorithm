package leetcode.day02;

import java.util.Arrays;

public class LC34 {
	public static void main(String[] args) {
	     int[] nums= {5,7,7,8,8,10};
	     System.out.println(Arrays.toString(searchRange(nums, 8)));
	}  
	 public  static int[] searchRange(int[] nums, int target) {
          int len=nums.length;
         int[]ans= new int[] {-1,-1};
          if(len==0) return ans;
        int left=0;
        int right=len-1;
        while(left<right) {
      	  int mid=(left+right)>>>1;
      	  if(target>nums[mid]) {
      		  left=mid+1;
      	  } 
      	  else {
      		  right=mid;
      	  }  
        }
         if(nums[left]==target) {
        	 ans[0]=left;
        	 left=0;
        	 right=len-1;
        	 while(left<right) {
           	  int mid=((left+right+1)>>>1);
           	  if(target<nums[mid]) {
           		  right=mid-1;
           	  } 
           	  else {
           		  left=mid;                                                                       
           	  }  
             }
        	 ans[1]=right; 
	  }
       return ans;  
	}
}