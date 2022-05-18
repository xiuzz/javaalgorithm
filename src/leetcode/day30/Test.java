package leetcode.day30;

public class Test {
	 static	 boolean isBadVersion(int version,int bad) {
		 return version>=bad;
	 };
	 public static int firstBadVersion(int n,int bad) {
		 int l = 0;
	        int r = n;
	        
	        while(l < r - 1){
	            int mid = l + r >>> 1;
	            if(isBadVersion(mid,bad)){
	                r = mid;
	            } else l = mid;
	        }
	        
	        return r;
	    }
	public static void main(String[] args) {
		System.out.println(firstBadVersion(4,1));
	}
}
