package leetcode.day29;

public class LC312 {
  public int maxCoins(int[] nums) {
	   int len=nums.length;
	   int[] newNums=new int[len+2];
	   newNums[0]=1;
	   newNums[len+1]=1;
	   System.arraycopy(nums, 0, newNums, 1, len);
       int[][] dp=new int[len+2][len+2];
       for (int i = 1; i <=len; i++) {
		 for (int j = 1; j <=len-i+1; j++) {
			 int r=i+j-1;
			for (int k = j; k <=r; k++) {
				dp[j][r]=Math.max(dp[j][r], dp[j][k-1]+newNums[j-1]*newNums[k]*newNums[r+1]+dp[k+1][r]);
			}
		}
	}
       return dp[1][len];
   }
}
