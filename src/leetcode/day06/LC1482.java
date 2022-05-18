package leetcode.day06;

import java.util.Arrays;

public class LC1482 {
	 public int minDays(int[] bloomDay, int m, int k) {
		 if(m*k>bloomDay.length)return -1;
           int left=1;
           int right=Arrays.stream(bloomDay).max().getAsInt();
          while(left<right){
        	  int mid=(left+right)>>>1;
        	int M=getM(bloomDay, mid, k);
        	if(M<m)left=mid+1;
        	else right=mid;
          } 
          return left;
	  }
	 public static int getM(int[] arr,int mid,int k) {
		 int get=0;
		 int M=0;
		 for (int i : arr) {
			if(i<=mid) {
			   get++;
			  if(get==k) {
				  get=0;
				 M++; 
			  }
			}
			else get=0;
		}
		 return M;
	 }
}
