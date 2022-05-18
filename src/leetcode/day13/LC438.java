package leetcode.day13;

import java.util.ArrayList;
import java.util.List;

public class LC438 {
	public static void main(String[] args) {
	System.out.println( findAnagrams("cbaebabacd", "abc"));
	}
	public static List<Integer> findAnagrams(String s, String p) {
	   List<Integer> list=new ArrayList<Integer>();
       int[] model=new int[26]; 
       final int A='a';
       char[] our=s.toCharArray();
      for (char i : p.toCharArray()) {
		model[i-A]++;
	}
     int len=0;
     for (int i:model) {
		if(i>0)len++;
	}
     int right=0;
     int[] finder=null;
     int match=0;
     while(right<s.length()-p .length()) {
    	 if(model[our[right]-A]>0) {
    		 match=0;
    	     finder=new int[26];
    		 for (int i = right; i <right+p.length()+1; i++) {
				finder[our[i]-A]++;
				if(model[our[i]-A]==finder[our[i]-A]) {
					match++;
				}
			}
    		if(match==len) list.add(right);
    	 }
    	 right++;
     }
     return list;
    }
}
