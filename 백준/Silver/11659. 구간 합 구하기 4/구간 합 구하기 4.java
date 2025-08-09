
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] str = br.readLine().split(" ");
    	int N = Integer.parseInt(str[0]);
    	int M = Integer.parseInt(str[1]);
    	
    	int[] arr = new int[N + 1];
    	
    	str = br.readLine().split(" ");
    	arr[1] = Integer.parseInt(str[0]);
    	for (int i = 2; i <= N; ++i)
    	{
    		arr[i] = arr[i - 1] + Integer.parseInt(str[i - 1]);
    	}
    	
    	for (int i = 0; i < M; ++i)
    	{
    		str = br.readLine().split(" ");
    		System.out.println(arr[Integer.parseInt(str[1])] - arr[Integer.parseInt(str[0]) - 1]); 
    	}
    }
}