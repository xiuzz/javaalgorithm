package leetcode.day27;

public class LC53 {
	public int maxSubArray(int[] nums) {
         int[] dp=new int[nums.length];
         dp[0]=nums[0];
         int max=nums[0];
         for (int i = 1; i < dp.length; i++) {
			dp[i]=Math.max(dp[i-1]+nums[i], nums[i]);
			max=Math.max(dp[i], max);
		}
         return max;
	 }
}
