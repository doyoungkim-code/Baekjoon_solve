import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge>{
		
		int from, to, weight;
		
		public Edge(int from, int to, int weight)
		{
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o)
		{
			return (Integer.compare(this.weight, o.weight));
		}
	}
	
	static int find(int a)
	{
		if (parents[a] == a)
			return a;
		return (parents[a] = find(parents[a]));
	}
	
	static boolean union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		
		if (rootA > rootB)
			parents[rootB] = rootA;
		else
			parents[rootA] = rootB;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N + 1];
		edgeList = new Edge[M];
		
		for (int i = 0; i <= N; ++i)
		{
			parents[i] = i;
		}
		
		for (int i = 0; i < M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		
		int res = 0;
		int cnt = 0;
		
		for (Edge e : edgeList)
		{
			if (!union(e.from, e.to))
				continue;
			res += e.weight;
			if (++cnt == N - 1)
				break;
		}
		System.out.println(res);
	}
}
