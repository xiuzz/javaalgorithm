package leetcode.day24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC017 {
 public List<String> letterCombinations(String digits) {
     List<String> res=new ArrayList<String>();
	    if(digits.length()==0)return res;
        HashMap<Character, String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4',"ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] characters=digits.toCharArray();
        StringBuilder builder=new StringBuilder();
        dfs(digits.length(), 0, builder,characters, res, map, 0);
        return res;
	 }
 public void dfs(int len,int depth,StringBuilder builder,char[] nums,List<String> res,Map<Character,String> map,int begin) {
	   if(depth==len) {
		   res.add(builder.toString());
		   return;
	   }
	   for (int i = begin; i <nums.length; i++) {
		   String ans=map.get(nums[i]);
		   for (int j = 0; j <ans.length(); j++) {
			 String sub=ans.substring(j,j+1);
			 builder.append(sub);
			   dfs(len, depth+1, builder, nums,res, map, i+1);
			   builder.deleteCharAt(builder.length()-1);
		}	   
	}
 }
}
