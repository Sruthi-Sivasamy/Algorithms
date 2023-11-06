public final class UnionFind {
	private int[] parent, size;
	
	public UnionFind(int n)
	{
		parent = new int[n];
		size = new int[n];
		for(int i = 0; i < n; i++)
		{
			parent[i] = i;
			size[i] = 1;
		}
		
	}
	
	public int find(int x)
	{
		if(parent[x] == x)
			return x;
		parent[x] =  find(parent[x]);
		return parent[x];
	}
	
	public void union(int x, int y)
	{
		int pX = find(x);
		int pY = find(y);
		
		if(pX != pY)
		{
			if(size[pX] > size[pY])
			{
				parent[pY] = pX;
				size[pX] += size[pY];
			}
			else
			{
				parent[pX] = pY;
				size[pY] += size[pX];
			}
		}
		
	}
	
	boolean isConnected(int x, int y)
	{
		return find(x) == find(y);
	}

  public static void main(String args[])
	{
		int n = 7;
		UnionFind UF = new UnionFind(n);
		UF.union(5, 6);
		UF.union(6, 1);
		UF.union(2, 3);
		System.out.println(UF.isConnected(1, 5)); //return true
		System.out.println(UF.isConnected(6, 1)); //return true 	
		System.out.println(UF.isConnected(2, 3)); //return true
		System.out.println(UF.isConnected(2, 6)); //return false
	}

}

