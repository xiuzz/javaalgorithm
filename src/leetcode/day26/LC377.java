package leetcode.day26;
public class LC377 {
	public static void main(String[] args) {
		System.out.println(combinationSum4(new int[] {1,2,3}, 4));
	}
	public static  int combinationSum4(int[] nums, int target) {
       int[] dp=new int[target+1];
       for (int i = 1; i < dp.length; i++) {
        for (int j = 0; j < nums.length; j++) {
			if(i>=nums[j]&&dp[i-nums[j]]>=0) {
				dp[i]+=i-nums[j]==0?1:dp[i-nums[j]];
			}
		}
	}
       return dp[target];
    }
}
