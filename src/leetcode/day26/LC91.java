package leetcode.day26;

public class LC91 {
	public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        if(!s.substring(0,1).equals("0"))dp[0]=1;
        if(dp.length==1)return dp[0];
        if(!s.substring(1,2).equals("0")&&!s.substring(0, 1).equals("0"))dp[1]++;
        if(!s.substring(0, 1).equals("0")&&s.substring(0, 2).compareTo("27")<0)dp[1]++;
        for (int i = 2; i < dp.length; i++) {
			if(!s.substring(i,i+1).equals("0")&&!s.substring(i-1, i).equals("0"))dp[i]+=dp[i-1];
			if(!s.substring(i-1, i).equals("0")&&s.substring(i-1, i+1).compareTo("27")<0)dp[i]+=dp[i-2];
		}
        return dp[s.length()-1];
    }
}
