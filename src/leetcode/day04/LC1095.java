package leetcode.day04;

public class LC1095 {
	public static void main(String[] args) {
		int[] arr= {1,5,2};
		System.out.println(findInMountainArray(2, arr));
	}
	 public static int findInMountainArray(int target, int[] mountainArr) {
	       int left=0;
	       int right=mountainArr.length-1;
	     int mid=0;
	     while(left<right) {
	    	 mid=(left+right)>>>1;
	    	 if(mountainArr[mid]>mountainArr[mid+1])right=mid;
	    	 if(mountainArr[mid]>mountainArr[mid-1])left=mid;
	     }
	     int max=right;
	     if(target>mountainArr[max]) return -1;
	     left=0;
	     right=max;
	      while(left<right) {
	     mid=(left+right)>>>1;
	     if(target>mountainArr[mid])left=mid+1;
	     else right=mid;
	     }
	      if(target==mountainArr[right])return right;
	      else {
	    	  left=max;
	    	  right=mountainArr.length-1;
	        while(left<right) {
	    		     mid=(left+right)>>>1;
	          if(target<mountainArr[mid])left=mid+1;
	          else right=mid;
	       }
	        if(target==mountainArr[right])return right;
	        else return -1;
	     }
	  }
}
