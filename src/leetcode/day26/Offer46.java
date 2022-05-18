package leetcode.day26;

public class Offer46 {
	public static void main(String[] args) {
		System.out.println(translateNum(506));
	}
	public static int translateNum(int num) {
		if(num<10)return 1;
	   String string=String.valueOf(num);
       int[] dp=new int[string.length()];
       dp[0]=1;
       if(string.substring(0,2).compareTo("26")<0&&!string.substring(0,1).equals("0"))dp[1]=2;
       else dp[1]=1;
      for (int i = 2; i < dp.length; i++) {
		if(string.substring(i-1,i+1).compareTo("26")<0&&!string.substring(i-1,i).equals("0")) {
	         dp[i]=dp[i-2]+dp[i-1];
		}	
		else dp[i]=dp[i-1];
	}
      return dp[dp.length-1];
    }
}
