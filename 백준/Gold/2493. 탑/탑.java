
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	ArrayDeque<int[]> dq = new ArrayDeque<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for (int i = 1; i <= N; ++i)
    	{
    		int top = Integer.parseInt(st.nextToken());
    		
    		while (!dq.isEmpty())
    		{
    			if (dq.peek()[1] >= top)
    			{
    				System.out.print(dq.peek()[0] + " ");
    				break;
    			}
    			else
    			{
    				dq.poll();
    			}
    		}
    		if (dq.isEmpty())
    		{
    			System.out.print("0 ");
    		}
    		dq.push(new int[] {i, top});
    	}
    }
}
