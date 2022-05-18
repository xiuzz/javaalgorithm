package leetcode.day26;

public class LC070 { 
   public int climbStairs(int n) {
      if(n<=1)return n;
     int[] dp=new int[n+1];
     dp[1]=1;
     for (int i = 2; i < dp.length; i++) {
        dp[i]=dp[i-1]+dp[i-2];		
	}
     return dp[dp.length-1];
	 }
}
