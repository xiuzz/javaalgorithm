package leetcode.day16;

public class LC121 {
	/*
	 *  public int maxProfit(int[] prices) {
	  int[] dp=new int[prices.length];
	  dp[0]=prices[0];;
	  for (int i = 1; i < dp.length; i++) {
		dp[i]=Math.min(dp[i-1],prices[i]);	
	}
	int max=0;
	for (int i = 1; i < dp.length; i++) {
	    max=Math.max(max, prices[i]-dp[i-1]);
	}
	return max;
   }*/
	 public int maxProfit(int[] prices) {
	 int min=prices[0];
	 int max=0;
	 for (int i = 0; i < prices.length; i++) {
		min=Math.min(min, prices[i]);
		max=Math.max(max, prices[i]-min);
	}
	 return max;
	 }
}
