package leetcode.day24;

public class GCD {
   public  static int gcd(int a,int b) {
	   return a%b==0?b:gcd(b, a%b);
   }
   public static void main(String[] args) {
	 System.out.println(gcd(2,4 ));
}
}
