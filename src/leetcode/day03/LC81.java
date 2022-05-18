package leetcode.day03;

public class LC81 {
     public static void main(String[] args) {
		int[] nums= {1,1,1,1,2,1,1,1};
		System.out.println(search(nums, 0));
	}
	public static boolean search(int[] nums, int target) {
		 if(nums.length==1) {
	           if(target==nums[0])return true;
	           else return false;
	        }
		int left=0;
		int right=nums.length-1;
		int mid=0;
		int renew=right;
		boolean roop=true;
		while(left<right) {
			mid=(left+right)>>>1;
			if(nums[mid]==nums[right]) {
				right--;
				if(roop) renew=right;
			}
			else {
				roop=false;
				if(nums[mid]>nums[right])left=mid+1;
				else right=mid;
			}			
		}
		int min=right;
		left=0;
		right=renew;
		if(target<nums[min]) return false;
		if(target>nums[right]) {
			if(min==0)return false;
			else right=min-1;
		}
		else left=min;
	while(left<=right) {
		mid=(left+right)>>>1;
	  if(nums[mid]<target)left=mid+1;
	  else if(nums[mid]>target) right=mid-1; 
	  else  return true;
	}
 return false;	
    }
}
