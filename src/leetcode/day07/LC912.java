package leetcode.day07;

import java.util.Arrays;

public class LC912 {
	public static void main(String[] args) {
		int[] nums= {5,1,1,2,0,0};
		nums=sortArray(nums);
		System.out.println(Arrays.toString(nums));
	}
	public static int[] sortArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        quick(nums, left, right);
        return nums;
    }
   private static void quick(int[] nums,int left,int right) {
	   int pl=left;
	   int pr=right+1;
	 while(true) {
		 while(nums[++pl]<=nums[left]) {
			  if(pl==right)break;
		  }
		  while(nums[--pr]>nums[left]) {
			  if(pr==left)break;
		  }
		  if(pl<pr) {
			  int temp=nums[pl];
			  nums[pl]=nums[pr];
			  nums[pr]=temp;
		  }
		  else {
			  int temp=nums[left];
			  nums[left]=nums[pr];
			  nums[pr]=temp;
			  break;
		  }
	 }
	if(left<pr-1) quick(nums, left,pr-1);
	if(pr<right) quick(nums, pr, right);
   }
}
