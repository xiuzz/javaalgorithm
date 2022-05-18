package leetcode.day05;

public class LC69 {
	public int mySqrt(int x) {
		if(x<=1)return x;
       int left=0;
       int right=x/2;
       int mid=0;
      while(left<right) {
    	  mid=(left+right+1)>>>1;
    	if(mid>x/mid)right=mid-1;
    	else right=mid;
      }
      return mid;
    }
}
