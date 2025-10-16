import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] parent;
	static List <Edge> EdgeList;
	
	static class Edge implements Comparable<Edge> {
		int start;
		int to;
		int weight;
		
		public Edge(int start, int to, int weight) {
			this.start = start;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (Integer.compare(this.weight, o.weight));
		}
	}
	
	static int find(int a) {
		if (parent[a] == a)
			return a;
		return (parent[a] = find(parent[a]));
	}
	
	static boolean union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		
		parent[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		parent = new int[N + 2];

		EdgeList = new ArrayList<>();
		
		int result = 0;

		for (int i = 1; i <= N + 1; ++i)
		{
			parent[i] = i;
		}
		for (int i = 1; i <= N; ++i)
		{
			int cost = Integer.parseInt(br.readLine());
			EdgeList.add(new Edge(i, N + 1, cost));
		}

		for (int i = 1; i <= N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; ++j)
			{
				int cost = Integer.parseInt(st.nextToken());
				if (i < j)
					EdgeList.add(new Edge(i, j, cost));
			}
		}
		
		Collections.sort(EdgeList);
		
		int cnt = 0;
		
		for (Edge e : EdgeList)
		{
			if (!union(e.start, e.to))
				continue;
			
			result += e.weight;
			
			if (++cnt == N)
				break;
				
		}
		System.out.println(result);
	}
}