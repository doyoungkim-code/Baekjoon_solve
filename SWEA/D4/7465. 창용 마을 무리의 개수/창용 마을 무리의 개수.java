import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	
	static int[] parents;
	
	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return (parents[a] = find(parents[a]));
	}
	
	public static boolean union(int a, int b)
	{
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			parents = new int[N + 1];
			for (int i = 1; i <= N; ++i)
			{
				parents[i] = i;
			}
			
			for (int i = 0; i < M; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			int count = 0;
			for (int i = 1; i <= N; ++i)
			{
				if (parents[i] == i)
					count ++;
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}