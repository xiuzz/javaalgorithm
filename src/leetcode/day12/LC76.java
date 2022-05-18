package leetcode.day12;

public class LC76 {
	public String minWindow(String s, String t) {
       int[] window=new int[128];
       int[] pattern=new int[128];
       final int A='A';
      for (int i : t.toCharArray()) {
		pattern[i-A]++;
	}
      int disatance=0;
      for (int i = 0; i < pattern.length; i++) {
		if(pattern[i]>0)disatance++;
	}
     int left=0;
     int right=0;
     int match=0;
     int min=s.length()+1;
     int start=0;
     while(right<s.length()) {
    	 Character ourChar=s.charAt(right++);
    	 if(pattern[ourChar-A]>0) {
    		 window[ourChar-A]++;
    	  if(window[ourChar-A]==pattern[ourChar-A])match++;
    	 }
    	while(match==disatance) {
         if(right-left<min) {
        	 min=right-left;
        	 start=left;
         }
        Character leftchar=s.charAt(left++);
        if(window[leftchar-A]>0) {
        	window[leftchar-A]--;
        	if(window[leftchar-A]<pattern[leftchar-A])match--;
        }
         }
     }
    return min==s.length()+1?"":s.substring(start, start+min);
    }
}
