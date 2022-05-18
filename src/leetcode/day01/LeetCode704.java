package leetcode.day01;

public class LeetCode704 {
	 public int search(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            while(left<=right) {
            	 int mid=(left+right)>>>1;
            	if(target>nums[mid]) left=mid+1;
            	else if(target<nums[mid]) right=mid-1;
            	else return mid;
            }
            return -1;
	   } 
	//二分查找另一种模式，排除一定不存在的区间 
	 public int serach1(int[] nums,int target) {
		 int left=0;
		 int right=nums.length-1;
		 while(left<right) {
		 int mid=(left+right)>>>1;
         if(target>nums[mid]) {
        	 left=mid+1;
         }
         else {
        	 right=mid;
         } 
		 }
		 System.out.println(right);
		return nums[right]; 
	 }
 public static void main(String[] args) {
	 LeetCode704 leetCode704=new LeetCode704();
	 int[] nums= {1,2,3,4,5,6,7,8,9};
	 System.out.println(leetCode704.serach1(nums,5));
}	 
}