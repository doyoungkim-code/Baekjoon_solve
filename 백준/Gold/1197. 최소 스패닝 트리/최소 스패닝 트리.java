import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static int V;
	static int E;
	static int[] parents;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge>{
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
		if(parents[a] == a)
		{
			return (a);
		}
		return (parents[a] = find(parents[a]));
	}
	
	static boolean union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		
		parents[rootB] = rootA;
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        parents = new int[V + 1];
        edgeList = new Edge[E];
        
        for (int i = 0; i <= V; ++i)
        {
        	parents[i] = i;
        }
        
        for (int i = 0; i < E; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	int C = Integer.parseInt(st.nextToken());
        	
        	edgeList[i] = new Edge(A, B, C);
        }
        
        Arrays.sort(edgeList);
        
        long total = 0;
        for (Edge e : edgeList)
        {
        	if (union(e.from, e.to))
        		total += e.weight;
        }
        System.out.println(total);
    }
}