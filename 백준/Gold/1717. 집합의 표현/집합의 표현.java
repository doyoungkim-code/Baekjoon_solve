import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int[] parents;
	
	static int find(int a)
	{
		if (parents[a] == a)
			return a;
		return (parents[a] = find(parents[a]));
	}
	
	static boolean union(int a, int b, int mode)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
		{
			if (mode == 1)
				System.out.println("YES");
			return false;
		}
		
		if (mode == 0)
			parents[rootA] = rootB;
		else
			System.out.println("NO");
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n + 1];
        for (int i = 0; i <= n; ++i)
        {
        	parents[i] = i;
        }
        
        for (int i = 0; i < m; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int mode = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	union(a, b, mode);
        }
    }
}