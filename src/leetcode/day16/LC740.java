package leetcode.day16;

public class LC740 {
	public int deleteAndEarn(int[] nums) {
         int[] index=new int[10001];
         for (int i = 0; i < nums.length; i++) {
			index[nums[i]]++;
		}
        int[] value=new int[10001];
        for (int i = 0; i < value.length; i++) {
			value[i]=index[i]*i;
		}
        return rob(value);
    }
	public int rob(int[] nums) {
	     int[] dp=new int [nums.length];
	     dp[0]=nums[0];
	     for (int i = 1; i < dp.length; i++) {
			if(i==1)dp[i]=Math.max(dp[i-1], nums[i]);
			else{
				dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
			}
	     }
	     return dp[dp.length-1];
   }
}
