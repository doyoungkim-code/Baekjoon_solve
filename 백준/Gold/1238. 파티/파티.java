import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int X;
	static final int INF = 987654321;
	
	static int[] result;
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int dijkstra(int start, List <List <Edge>> edgeList) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int[] minTime = new int[N + 1];
		
		for (int i = 1; i <= N; ++i)
		{
			minTime[i] = INF;
		}
		
		minTime[start] = 0;
		pq.add(new Edge(start, minTime[start]));
		
		while (!pq.isEmpty())
		{
			Edge data = pq.poll();
			int to = data.to;
			int total = data.weight;
			
			if (visited[to])
				continue;
			
			visited[to] = true;
			
			for (Edge e : edgeList.get(to))
			{
				int nowTo = e.to;
				int nowWeight = e.weight;
				
				if (!visited[nowTo] && minTime[nowTo] > nowWeight + total)
				{
					minTime[nowTo] = nowWeight + total;
					pq.add(new Edge(nowTo, minTime[nowTo]));
				}
			}
		}

		for (int i = 1; i <= N; ++i)
		{
			result[i] += minTime[i];
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		result = new int[N + 1];
		List <List <Edge>> edgeList = new ArrayList<>();
		List <List <Edge>> edgeListReverse = new ArrayList<>();
		
		for (int i = 0; i <= N; ++i){
			edgeList.add(new ArrayList<>());
			edgeListReverse.add(new ArrayList<>());
		}
		
		for (int m = 0; m < M; ++m)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList.get(a).add(new Edge(b, c));
			edgeListReverse.get(b).add(new Edge(a, c));
		}
		
		dijkstra(X, edgeList);
		dijkstra(X, edgeListReverse);
		
		int max = -1;
		for (int i = 1; i <= N; ++i)
		{
			if (i == X)
				continue;
			if (max < result[i])
				max = result[i];
		}
		System.out.println(max);
	}
}