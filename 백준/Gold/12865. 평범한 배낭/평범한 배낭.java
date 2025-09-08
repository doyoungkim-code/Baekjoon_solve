import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int[] weight = new int[N + 1];
    	int[] value = new int[N + 1];
    	int[][] result = new int[N + 1][K + 1];
    	
    	for (int i = 1; i <= N; ++i)
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		weight[i] = Integer.parseInt(st.nextToken());
    		value[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int itemWeight = 0;
    	int itemValue = 0;
    	
    	for (int item = 1; item <= N; ++item)
    	{
    		itemWeight = weight[item];
    		itemValue = value[item];
    		
    		for (int w = 1; w <= K; ++w)
    		{
    			if (itemWeight <= w)
    			{
    				result[item][w] = Math.max(result[item - 1][w], itemValue + result[item - 1][w - itemWeight]);
    			}
    			else
    			{
    				result[item][w] = result[item - 1][w];
    			}
    		}
    	}
    	
    	int max = 0;
    	for (int w = 1; w <= K; ++w)
    	{
    		if (max < result[N][w])
    			max = result[N][w];
    	}
    	System.out.println(max);
    }
}