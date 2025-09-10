import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] d = new int[N + 1][N + 1];
        
        for (int i = 0; i < M; ++i)
        {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (d[a][b] == 0 || d[a][b] > c)
            	d[a][b] = c;
        }
        for (int i = 1; i <= N; ++i)
        {
        	for (int j = 1; j <= N; ++j)
        	{
        		if (i != j && d[i][j] == 0)
        			d[i][j] = 100000000;
        	}
        }
        for (int k = 1; k <= N; ++k) // 경유지
        {
            for (int i = 1; i <= N; ++i) // 출발지
            {
            	for (int j = 1; j <= N; ++j) // 도착지
            	{
            		d[i][j] = Math.min(d[i][k] + d[k][j], d[i][j]);
            	}
            }
        }
        
        for (int i = 1; i <= N; ++i)
        {
        	for (int j = 1; j <= N; ++j)
        	{
        		if (d[i][j] >= 100000000)
        			sb.append("0 ");
        		else
        			sb.append(d[i][j] + " ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}