import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static Edge[] edgeList;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>
	{
		
		int from;
		int to;
		long weight;
		
		public Edge(int from, int to, long weight) {
			super();
			
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return (Long.compare(this.weight, o.weight));
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
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			// 파싱부
			int N = Integer.parseInt(br.readLine());
			edgeList = new Edge[N * (N - 1) / 2];
			parents = new int[N + 1];
			long[] Nx = new long[N];
			long[] Ny = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				Nx[i] = Long.parseLong(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				Ny[i] = Long.parseLong(st.nextToken());
			double E = Double.parseDouble(br.readLine());
			
			// 실행부
			for (int i = 0; i <= N; ++i)
			{
				parents[i] = i;
			}
			
			int numEdge = 0;
			
			for (int i = 0; i < N - 1; ++i)
			{
				for (int j = i + 1; j < N; ++j)
				{
					long dx = Nx[i] - Nx[j];
					long dy = Ny[i] - Ny[j];

					long len = dx * dx + dy * dy;
					edgeList[numEdge] = new Edge(i, j, len);
					numEdge ++;
				}
			}
			
			Arrays.sort(edgeList);
			
			long res = 0;
			int cnt = 0;
			
			for (Edge e : edgeList)
			{
				if (!union(e.from, e.to))
					continue;
				res += e.weight;
				if (++cnt == N - 1)
					break;
			}
			
			long finalres = Math.round(E * res);
			
			sb.append("#" + tc + " " + finalres + "\n");
		}
		System.out.println(sb);
	}
}