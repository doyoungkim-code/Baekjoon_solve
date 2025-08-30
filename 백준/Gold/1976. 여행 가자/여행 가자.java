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
	
	static boolean union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		
		parents[rootA] = rootB;
		return true;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parents = new int[n + 1];
        for (int i = 0; i <= n; ++i)
        {
        	parents[i] = i;
        }
        
        for (int i = 1; i <= n; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int j = 1; j <= n; ++j)
        	{
        		int flag = Integer.parseInt(st.nextToken());
        		
        		if (flag == 1)
        			union(i, j);
        	}
        }
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; ++i)
        {
        	int next = Integer.parseInt(st.nextToken());
        	if (union(temp, next))
        	{
        		System.out.println("NO");
        		return;
        	}
        	temp = next;
        }
        System.out.println("YES");
    }
}