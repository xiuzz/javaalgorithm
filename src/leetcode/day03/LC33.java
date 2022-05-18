package leetcode.day03;

public class LC33 {
	public static void main(String[] args) {
		int[] nums= {1,3};
		System.out.println(search(nums, 0));
	}
	public static int search(int[] nums, int target) {
        if(nums.length==1) {
           if(target==nums[0])return 0;
           else return -1;
        }
        int left=0;
        int right=nums.length-1;
        int mid=0;
      while(left<right) {
    	  mid=(left+right)>>>1;
    	if(nums[mid]>nums[right]) left=mid+1;
    	else right=mid;
      }
      int min=right;
      left=0;
      right=nums.length-1;
      if(nums[min]>target)return -1;
      if(nums[right]<target) {
    	  if(min==0)return -1;
    	  else right=min-1; 
      }
      else left=min;
      while(left<right) {
    	   mid=(left+right)>>>1;
       if(nums[mid]<=target)left=mid;
       else right=mid-1;
      }
     return right;
    }  
}
