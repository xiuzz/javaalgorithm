package leetcode.day26;

import java.util.Arrays;

public class LC279 {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	public static int numSquares(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp, n);
      dp[0]=0;
    for (int i = 1; i < dp.length; i++) {
    	int min=n;
		for (int j = 1; j*j<=i; j++) {
			int temp=j*j;
			min=Math.min(min, dp[i-temp]+1);
		}
	  dp[i]=min;	
	}
    return dp[dp.length-1];
    }
}
