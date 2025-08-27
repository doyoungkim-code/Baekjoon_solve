import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Data implements Comparable<Data>{

		int num;
		long weight;
		
		public Data(int num, long weight) {
			this.num = num;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
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
			
			List<List<Data>> input = new ArrayList<>();
			for (int i = 0; i <= V; ++i)
				input.add(new ArrayList<>());
			boolean[] visited = new boolean[V + 1];
			
			for(int i = 0; i < E; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				input.get(A).add(new Data(B, C));
				input.get(B).add(new Data(A, C));
			}
			
			long result = 0;
			int count = 0;
			
			PriorityQueue<Data> pq = new PriorityQueue<>();
			pq.offer(new Data(1, 0));
			
			while(!pq.isEmpty())
			{
				Data cur = pq.poll();
				
				if (visited[cur.num])
					continue;
				
				result += cur.weight;
				visited[cur.num] = true;
				
				if (++count == V)
					break;
				
				for (Data next : input.get(cur.num))
				{
					if (!visited[next.num]) {
						pq.offer(next);
					}
				}
			}
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}
}