import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	
    	if (N <= 1 || M <= 1)
    	{
    		System.out.println(0);
    		return ;
    	}
    	
    	System.out.println((2 + (N - 2) * 2) * (M - 1));
    }
}