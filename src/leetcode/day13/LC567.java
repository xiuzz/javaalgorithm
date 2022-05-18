package leetcode.day13;

public class LC567 {
	public static void main(String[] args) {
	 System.out.println(checkInclusion("ab", "eidboaoo"));
	}
 public static boolean checkInclusion(String s1, String s2) {
		 final int A='a';
	   int[] model=new int[26];
	   char[] our=s2.toCharArray();
	   for (int i : s1.toCharArray()) {
		 model[i-A]++;
	}
	   int len=0;
	  for (int i : model) {
		if(i>0)len++;
	}
	   int[] finder=new int[26];
	   int left=0;
	   int right=0;
	   int match=0;
	   while(right<s2.length()) {
		  if(model[our[right]-A]>0) {
			  finder[our[right]-A]++;
			  if(finder[our[right]-A]==model[our[right]-A])match++;
		  }
		  while(match==len) {
			  if(right-left+1>s1.length()) {
				  if(finder[our[left]-A]>0) {
					  finder[our[left]-A]--;
					  if(finder[our[left]-A]<model[our[left]-A])match--;
				  }
				  left++;
			  }
			  else  return true;
		  }
		  right++;
	   }
	   return false;
	}
}
