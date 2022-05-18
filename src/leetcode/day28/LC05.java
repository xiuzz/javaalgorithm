package leetcode.day28;

public class LC05 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aacabdkacaa"));
	}
	 public  static String longestPalindrome(String s) {
		 char[] arr=s.toCharArray();
         boolean[][] dp=new boolean[s.length()][s.length()];
  	   for (int i = 0; i < arr.length; i++) {
 			dp[i][i]=true;
 		}
  	   int max=1;
  	   int begin=0;
        for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j <i; j++) {
				if(arr[i]==arr[j]) {
					if(i-j<3) dp[j][i]=true;
					else dp[j][i]=dp[j+1][i-1];				   
				}
			if(dp[j][i]&&i-j+1>max) {
			   		max=i-j+1;
			   		begin=j;
			   	}
			}
		} 
        return s.substring(begin,begin+max);
	   }
}
