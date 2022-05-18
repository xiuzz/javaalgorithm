package leetcode.day24;

import java.util.HashSet;
import java.util.Set;

public class LC1593 {
	public static void main(String[] args) {
	LC1593 lc1593=new LC1593();
	System.out.println(lc1593.maxUniqueSplit("ababccc"));
	}
	int max;
	public int maxUniqueSplit(String s) {
       Set<String> set=new HashSet<>();
       dfs(0, s, s.length(), set);
       return max;
    }

	public void dfs(int start,String s,int len,Set<String> set) {
		if(start==len) {
			max=Math.max(max,set.size());
			return;
		}
		for (int i = start+1; i <=len; i++) {
			String sub=s.substring(start, i);
			if(set.contains(sub))continue;
			set.add(sub);
			dfs(i, s, len, set);
			set.remove(sub);
		}
	}
}
