package leetcode.day24;

import java.util.ArrayList;
import java.util.List;

public class LC022 {
  public List<String> generateParenthesis(int n) {
	  StringBuilder builder=new StringBuilder();
	  List<String> res=new ArrayList<String>();
	  dfs(n, n, builder, res);
	  return res;
	 }
  public void dfs(int left,int right,StringBuilder builder,List<String> res) {
	  if(left==0&&right==0) {
		  res.add(builder.toString());
	  }
	if(left>0) {
		builder.append("(");
		dfs(left-1, right, builder, res);
		builder.deleteCharAt(builder.length()-1);
	}
	if(left<right) {
		builder.append(")");
		dfs(left, right-1, builder, res);
		builder.deleteCharAt(builder.length()-1);
	}
  }
}
