package leetcode.day19;
//基于标识的quick-find
public class UnionFind {
	/*每个节点的id标识，id表示一样表示被分在同一组
	 * */
   private int[] id;
   /*
    * 连通分量的个数*/
  private int count;
  /*记录id数
   * */
  private int N;
  public int getCount() {
	return count;
}
  public UnionFind(int N) {
	  this.N=N;
	  this.count=N;
	  id=new int[N];
	  for (int i = 0; i < id.length; i++) {
		id[i]=i;
	}
  }
  public int find(int x) {
	  return id[x];
  }
  public void union(int x,int y) {
	  int xid=find(x);
	  int yid=find(y);
	  if(xid==yid)return;
	  for (int i = 0; i < N; i++) {
		if(id[i]==xid) {
			id[i]=yid;
		}
	}
	  count--; 
  }
}
