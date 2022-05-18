package leetcode.day20;

public class LC952 {
	public static void main(String[] args) {
		LC952 lc952=new LC952();
		System.out.println(lc952.largestComponentSize(new int[] {4,6,15,35}));
	}
	public int largestComponentSize(int[] nums) {
		int max=0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]>max)max=nums[i];
		}
        UnionFind unionFind=new UnionFind(max+1);
        for (int i = 0; i < nums.length; i++) {
			double sqrt=Math.sqrt(nums[i]);
			for (int j = 2; j <=sqrt; j++) {
				if(nums[i]%j==0) {
					unionFind.union(nums[i], j);
					unionFind.union(nums[i], nums[i]/j);
				}
			}
		}
       int[] cnt=new int[max+1];
       int ans=0;
       for (int i = 0; i < nums.length; i++) {
		  int root=unionFind.find(nums[i]);
		  cnt[root]++;
		  ans=Math.max(ans, cnt[root]);
	}
        return ans;
    }
	private class UnionFind{
		int[] parent;
		public UnionFind(int N) {
			parent=new int[N];
		    for (int i = 0; i < parent.length; i++) {
				parent[i]=i;
			}
		}
		public int find(int x) {
			while(x!=parent[x]) {
				parent[x]=parent[parent[x]];
				x=parent[x];
			}
			return x;
		}
		public void union(int x,int y) {
		      int xRoot=find(x);
		      int yRoot=find(y);
		      if(xRoot==yRoot)return;
		     parent[xRoot]=yRoot;
		}
	}
}
