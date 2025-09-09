import java.io.*;
import java.util.*;

public class Solution {
	
	static int lowerBound(int[] arr, int end, int n) {
		
		int start = 0;
		
		while (start < end)
		{
			int mid = (start + end) / 2;
			
			if (arr[mid] >= n)
			{
				end = mid;
			}
			else
			{
				start = mid + 1;
			}
		}
		
		return end;
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1; tc <= T; ++tc)
    	{
    		int N = Integer.parseInt(br.readLine());
    		int[] arr = new int[N];
    		int[] result = new int[N];
    		
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; ++i)
    		{
    			arr[i] = Integer.parseInt(st.nextToken());
    		}
    		 
    		int idx = 0;
			result[0] = arr[0];
    		for (int i = 1; i < N; ++i)
    		{
    			if (arr[i] > result[idx])
    			{
    				result[++idx] = arr[i];
    			}
    			else
    			{
    				int idxidx = lowerBound(result, idx + 1, arr[i]);
    				result[idxidx] = arr[i];
    			}
    		}
    		sb.append("#" + tc + " " + (idx+1) + "\n");
    	}
    	System.out.println(sb);
    }
}