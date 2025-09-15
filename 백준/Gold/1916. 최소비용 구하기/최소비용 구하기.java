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
	final static int INF = 2147483647;
	static int startNode;
	static int endNode;
	static int[] min;
	static boolean[] visited;
	static List<List<Edge>> edgeList;
	
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
	
	static void dijkstra()
	{
		visited = new boolean[N + 1];
		min = new int[N + 1];
		
		for (int i = 1; i <= N; ++i)
		{
			min[i] = INF;
		}
		
		min[startNode] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(startNode, min[startNode]));
		
		while (!pq.isEmpty())
		{
			Edge pollData = pq.poll();
			int currentNo = pollData.to;
			
			if (visited[endNode])
				break;
			
			if (visited[currentNo])
				continue;
			
			visited[currentNo] = true;
			
			List <Edge> lst = edgeList.get(currentNo);
			int size = lst.size();
			
			for (int i = 0; i < size; ++i)
			{
				Edge e = lst.get(i);
				if (!visited[e.to] && min[e.to] > min[currentNo] + e.weight)
				{
					min[e.to] = min[currentNo] + e.weight;
					pq.add(new Edge(e.to, min[e.to]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		for (int i = 0; i <= N; ++i)
		{
			edgeList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList.get(a).add(new Edge(b, c));
		}
		
		st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(min[endNode]);
	}
}
