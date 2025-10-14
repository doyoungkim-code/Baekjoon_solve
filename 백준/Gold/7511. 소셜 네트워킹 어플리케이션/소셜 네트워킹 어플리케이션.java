import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] userRoot;
	
	static int find(int a)
	{
		if (userRoot[a] == a)
			return a;
		return (userRoot[a] = find(userRoot[a]));
	}
	
	static boolean union(int a, int b)
	{
		if (userRoot[a] == userRoot[b])
			return false;
		
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootB > rootA)
			userRoot[rootA] = rootB;
		else
			userRoot[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc)
		{
			sb.append("Scenario " + tc + ":\n");
			int userCount = Integer.parseInt(br.readLine());
			int relationCount = Integer.parseInt(br.readLine());
			
			userRoot = new int[userCount + 1];
			
			for (int u = 0; u < userCount; u++)
			{
				userRoot[u] = u;
			}
			
			for (int r = 0; r < relationCount; ++r)
			{
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			int wantCount = Integer.parseInt(br.readLine());
			
			for (int m = 0; m < wantCount; ++m)
			{
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (find(a) == find(b))
					sb.append("1\n");
				else
					sb.append("0\n");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
