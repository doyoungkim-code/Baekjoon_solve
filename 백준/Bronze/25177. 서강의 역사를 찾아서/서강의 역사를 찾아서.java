import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int m = Math.max(N, M);
    	int[] arrA = new int[m];
    	int[] arrB = new int[m];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; ++i)
    	{
    		arrA[i] = Integer.parseInt(st.nextToken());
    	}
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < M; ++i)
    	{
    		arrB[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = 0;
    	for (int i = 0; i < m; ++i)
    	{
    		max = Math.max(arrB[i] - arrA[i], max);
    	}
    	System.out.println(max);
    }
    
}