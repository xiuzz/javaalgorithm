package leetcode.day28;

public class LC1143 {
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde","ace"));
	}
  public static int longestCommonSubsequence(String text1, String text2) {
       char[] t1=text1.toCharArray();
       char[] t2=text2.toCharArray();
       int[][] dp=new int[text1.length()+1][text2.length()+1];
       for (int i = 1; i < dp.length; i++) {
		for (int j = 1; j < dp[0].length; j++) {
			dp[i][j]=t1[i-1]==t2[j-1]?dp[i-1][j-1]+1:Math.max(dp[i-1][j], dp[i][j-1]);
		}
	}
       return dp[t1.length][t2.length];
	}
}
