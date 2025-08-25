import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parents;
	
	public static int find(int a)
	{
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b, int mode)
	{
		int aParents = find(a);
		int bParents = find(b);
		
		if (aParents == bParents)
			return false;
		if (mode == 0)
			parents[bParents] = aParents;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n + 1];
			for (int j = 1; j <= n; ++j)
			{
				parents[j] = j;
			}
			
			for (int i = 0; i < m; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int mode = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				boolean res = union(a, b, mode);
				if (mode == 1)
					sb.append(res ? 0 : 1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}