import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static int V;
	static int E;
	static int K;
	static int[] minDist;
	static int INF = 2147483647;
	static List<List<Edge>> edgeList;
	
	static class Edge implements Comparable<Edge> {
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
	
	static void dijkstra()
	{
		minDist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		
		for (int i = 1; i <= V; ++i)
		{
			minDist[i] = INF;
		}
		
		minDist[K] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K, minDist[K]));
		
		while (!pq.isEmpty())
		{
			Edge pollData = pq.poll();
			int n = pollData.to;
			
			if (visited[n])
				continue;
			
			visited[n] = true;
			
			int size = edgeList.get(n).size();
			for (int i = 0; i < size; ++i)
			{
				Edge now = edgeList.get(n).get(i);
				if (!visited[now.to] && minDist[now.to] > minDist[n] + now.weight)
				{
					minDist[now.to] = minDist[n] + now.weight;
					pq.add(new Edge(now.to, minDist[now.to]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		for (int i = 0; i <= V; ++i)
		{
			edgeList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList.get(u).add(new Edge(v, w));
		}
		
		dijkstra();
		for (int i = 1; i <= V; ++i)	
		{
			if (minDist[i] == 2147483647)
				sb.append("INF").append("\n");
			else
				sb.append(minDist[i]).append("\n");
		}
		System.out.println(sb);
	}
}