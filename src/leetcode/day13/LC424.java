package leetcode.day13;

public class LC424 {
	 public int characterReplacement(String s, int k) {
	    int left=0;
	    int right=0;
	    final int A='A';
	    int max=0;
	    int res=0;
	    int[] p=new int[26];
	    char[] our=s.toCharArray();
	    while(right<s.length()) {
	       p[our[right]-A]++;
	       max=Math.max(max, p[our[right]-A]);//贪心策略是真的难想
	       right++;
	        if(right-left>k+max) {         
	    	   p[our[left++]-A]--;    	  
	       }
	    	  res=Math.max(res, right-left); 
	    }
	   return res; 
	 }
}
