import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parents;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {
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
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static int find(int a)
	{
		if (parents[a] == a)
			return a;
		return (parents[a] = find(parents[a]));
	}
	
	private static boolean union(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot)
			return false;
		if (aRoot > bRoot)
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parents = new int[V + 1];
			edgeList = new Edge[E];
			
			for (int i = 0; i < E; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(from, to, weight);
			}
			
			for (int i = 0; i <= V; ++i)
			{
				parents[i] = i;
			}
			
			Arrays.sort(edgeList);
			
			long res = 0;
			int cnt = 0;
			
			for (Edge edge : edgeList)
			{
				if (!union(edge.from, edge.to))
					continue;
				res += edge.weight;
				if (++cnt == V - 1)
					break;
			}
			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.println(sb);
	}
}