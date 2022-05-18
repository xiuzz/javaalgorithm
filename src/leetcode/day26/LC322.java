package leetcode.day26;

import java.util.Arrays;

public class LC322 {
	 public static void main(String[] args) {
		int[] coins= {186,419,83,408};
		System.out.println(coinChange(coins, 6249));
	}
	 public  static int coinChange(int[] coins, int amount) { 
          int[] dp=new int[amount+1];
          Arrays.fill(dp, amount+1);
          dp[0]=0;
        for (int i = 1; i < dp.length; i++) {
              int min=amount+1;
			for (int j = 0; j < coins.length; j++) {
				if(i>=coins[j]) {
                min=Math.min(min, dp[i-coins[j]]+1);
				}
			}
		dp[i]= min;
		}
          return dp[dp.length-1]==amount+1? -1:dp[dp.length-1];
	 }
}
