package leetcode.day30;
public class LC904 {
	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] {1,2}));
	}
	 public static int totalFruit(int[] fruits) {
		 if(fruits.length<=2)return fruits.length;
		int[] kind= {-1,-1};
		int l=0;
		int r=1;
		int max=0;
		for ( ; r < fruits.length; r++) {
			 if(fruits[r]!=kind[0]&&fruits[r]!=kind[1]) {
				 l=r-1;
				 while(l>0&&fruits[l]==fruits[l-1])l--;
				 kind[0]=fruits[l];
				 kind[1]=fruits[r];
			   }
	           max=Math.max(r-l+1,max);	   
		}	
		return max;
	 }
}
