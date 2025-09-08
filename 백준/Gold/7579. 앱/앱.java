import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[] memory;
	static int[] cost;
	static int[][] result;
	
	static int knapsack(int costSum) {
		
		int itemMemory = 0;
		int itemCost = 0;
		
		for (int item = 1; item <= N; ++item)	
		{
			itemMemory = memory[item];
			itemCost = cost[item];
			
			for (int i = 0; i <= costSum; ++i)
			{
				if (itemCost <= i)
				{
					result[item][i] = Math.max(result[item - 1][i], itemMemory + result[item - 1][i - itemCost]);
				}
				else
				{
					result[item][i] = result[item - 1][i];
				}
			}
		}
		for (int i = 0; i <= costSum; ++i)
		{
			if(result[N][i] >= M)
				return (i);
		}
		return -1;
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	memory = new int[N + 1];
    	cost = new int[N + 1];
    	result = new int[N + 1][10001];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= N; ++i)
    	{
    		memory[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int costSum = 0;
    	for (int i = 1; i <= N; ++i)
    	{
    		cost[i] = Integer.parseInt(st.nextToken());
    		costSum = costSum + cost[i];
    	}
    	
    	System.out.println(knapsack(costSum));
    }
}