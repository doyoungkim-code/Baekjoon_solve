import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; ++tc)
        {
        	int N = Integer.parseInt(br.readLine());
        	
        	int[] rank = new int[N + 1];
        	for (int n = 0; n < N; ++n)
        	{
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		rank[a] = b;
        	}
        	
        	int res = 0;
        	int nowMin = 100001;
        	for (int i = 1; i <= N; ++i)
        	{
        		if (nowMin > rank[i])
        		{
        			nowMin = rank[i];
        			res ++;
        		}
        	}
        	System.out.println(res);
        }
    }
}