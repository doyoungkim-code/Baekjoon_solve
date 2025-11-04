
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[] items = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i)
        {
        	items[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] len = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; ++i)
        {
        	for (int j = 1; j <= n; ++j)
        	{
        		len[i][j] = 1000000;
        	}
        }
        
        for(int i = 0; i < r; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	len[a][b] = c;
        	len[b][a] = c;
        }
        
        for (int i = 1; i <= n; ++i)
        {
        	for (int j = 1; j <= n; ++j)
        	{
        		for (int k = 1; k <= n; ++k)
        		{
        			len[j][k] = Math.min(len[j][k], len[j][i] + len[i][k]);
        		}
        	}
        }
        
        int max = 0;
        for (int i = 1; i <= n; ++i)
        {
        	int res = 0;
        	for (int j = 1; j <= n; ++j)
        	{
        		if (i == j || len[i][j] <= m)
        			res = res + items[j];
        	}
        	if (res > max)
        		max = res;
        }
        
        System.out.println(max);
    }
}
