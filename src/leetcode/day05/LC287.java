package leetcode.day05;

public class LC287 {
	public static void main(String[] args) {
		int[] nums= {1,3,4,2,2};
		System.out.println(findDuplicate(nums));
	}
	public static int findDuplicate(int[] nums) {
      int left=1;
      int right=nums.length-1;
      int ans=0;
     while(left<=right) {
        int mid=(left+right)>>>1;
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]<=mid) cnt++;
		}
        if(cnt<=mid)left=mid+1;
        else {
        	right=mid-1;
        	ans=mid;
        }
     }
     return ans;
    }
}
