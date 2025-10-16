import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] parent;
	static List <Edge> EdgeList;
	
	static class Edge {
		int start;
		int to;
		
		public Edge(int start, int to) {
			this.start = start;
			this.to = to;
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
		
		if (rootB > rootA)
			parent[rootA] = rootB;
		else
			parent[rootB] = rootA;
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
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parent = new int[N + 1];
			
			for (int i = 0; i < N; ++i)
			{
				parent[i] = i;
			}
			
			EdgeList = new ArrayList<>();
			
			for (int i = 0; i < M; ++i)
			{
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				EdgeList.add(new Edge(a, b));
			}
			
			int result = 0;
			int cnt = 0;
			
			for (Edge e : EdgeList)
			{
				if (!union(e.start, e.to))
					continue;
				
				result ++;
				
				if (++cnt == N - 1)
					break;
					
			}
			System.out.println(result);
		}
	}
}