import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int startPoint;
	static int endPoint;
	static final int INF = 987654321;
	static List <List<Bus>> BusList;
	
	static class Bus implements Comparable<Bus> {
		int to;
		int weight;
		
		public Bus(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static void dijkstra() {
		int[] minCost = new int[N + 1];
		int[] parents = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; ++i)
		{
			minCost[i] = INF;
		}
		
		minCost[startPoint] = 0;
		pq.add(new Bus(startPoint, minCost[startPoint]));

		while (!pq.isEmpty())
		{
			Bus pollData = pq.poll();
			int now = pollData.to;
			int total = pollData.weight;
			
			if (visited[now])
				continue;
			
			visited[now] = true;
			
			if (now == endPoint)
			{
				System.out.println(total);
				
				Stack <Integer> path = new Stack<>();
				int cur = endPoint;
				while (cur != 0)
				{
					path.push(cur);
					cur = parents[cur];
					if (cur == startPoint)
					{
						path.push(cur);
						break;
					}
				}
				System.out.println(path.size());
				while (!path.isEmpty())
				{
					int p = path.pop();
					System.out.print(p + " ");
				}
				return ;
			}
			
			for (Bus b : BusList.get(now))
			{
				int to = b.to;
				int weight = b.weight;
				
				
				if (!visited[to] && minCost[to] > total + weight)
				{
					minCost[to] = total + weight;
					parents[to] = now;
					pq.add(new Bus(to, minCost[to]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		BusList = new ArrayList<>();
		for (int n = 0; n <= N; ++n)
		{
			BusList.add(new ArrayList<>());
		}
		
		for (int m = 0; m < M; ++m)
		{
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			BusList.get(s).add(new Bus(t, w));
		}
		
		st = new StringTokenizer(br.readLine());
		startPoint = Integer.parseInt(st.nextToken());
		endPoint = Integer.parseInt(st.nextToken());
		
		dijkstra();
	}
}