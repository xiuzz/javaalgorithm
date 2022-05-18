package leetcode.day26;

import java.util.Arrays;

public class LC62 {
	public static void main(String[] args) {
	    System.out.println(uniquePaths(3, 7));
	}
	public static int uniquePaths(int m, int n) {
        int[] dp=new int[(m+1)*(n+1)];
        Arrays.fill(dp, 1);
       for (int i = 1; i <m; i++) {
		for (int j = 1; j <n; j++) {
			 dp[i*n+j]=dp[(i-1)*n+j]+dp[i*n+j-1];
		}
	}
    return dp[m*n];   
    }
}
