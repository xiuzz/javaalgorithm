package leetcode.day06;

public class LCP12 {
	public static void main(String[] args) {
		int[] arr= {94,92,90,57,6,89,63,15,91,74};
	   System.out.println( minTime(arr, 6));
	}
	public static  int minTime(int[] time, int m) {
         int left=0;
         int right=0;
         for (int i : time) {
			right+=i;
		}
         while(left<right) {
        	 int mid=(left+right)>>>1;
        	 int M=getM(time, mid);
        	 if(M>m)left=mid+1;
        	 else right=mid;
         }
         return left;
    }
	public static int getM(int[] arr,int mid) {	
		int M=1;
		int max=0;
		int sum=0;
		boolean loop=true;
		for (int i : arr) {
			max=Math.max(max, i);
			if((sum+=i)>mid) {
			if(loop){
				sum-=max;
				loop=false;
			}
				if(sum>mid) {
					M++;
					sum=i;
					loop=true;
					max=i;
				}
			}
			
		}
		return M;
	}
}
