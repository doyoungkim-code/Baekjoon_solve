
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        ArrayDeque <Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < N; ++i)
        {
        	int input = Integer.parseInt(br.readLine());
        	
        	while (!dq.isEmpty() && dq.peekLast() <= input)
        	{
        		dq.pollLast();
        	}
        	dq.add(input);
        	
        	result += (dq.size() - 1);
        }
        
        System.out.println(result);
    }
}
