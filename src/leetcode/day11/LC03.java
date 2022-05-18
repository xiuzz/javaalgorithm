package leetcode.day11;

import java.util.HashSet;

public class LC03 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}
	public static int lengthOfLongestSubstring(String s) {
	   if(s.length()==0)return 0;
       String[] arr=s.split("");
       HashSet<String> set=new HashSet<>();
       int max=0;
       int cur=0;
       for (int i = 0,j=0; i < arr.length; i++) {
		  if(!set.contains(arr[i])) {
			  set.add(arr[i]);
			  cur++;
			 max=Math.max(cur, max);
		  }
		  else {
			  while(set.contains(arr[i])) {
				  set.remove(arr[j++]);
			  }
			  set.add(arr[i]);
			  cur=i-j+1;
			  max=Math.max(cur, max);
		  }
	}
       return max;
    }
}
