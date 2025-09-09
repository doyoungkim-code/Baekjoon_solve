import java.io.*;
import java.util.*;

public class Main {
	
	static int binary(int[] res, int end, int n)
	{
		int start = 0;
		while (start < end)
		{
			int mid = (start + end) / 2;
			if (res[mid] < n)
			{
				start = mid + 1;
			}
			else
			{
				end = mid;
			}
		}
		return end;
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;

    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; ++i)
    	{
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int[] result = new int[N];
    	
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
    			int idxBinary = binary(result, idx + 1, arr[i]);
    			result[idxBinary] = arr[i];
    		}
    	}
    	
    	System.out.println(idx + 1);
    }
}