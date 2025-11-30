import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        while (true)
	        {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
		        int a = Integer.parseInt(st.nextToken());
		        int b = Integer.parseInt(st.nextToken());
		        
		        if (a == 0 && b == 0)
		        	break;
		       
		        if (a > b)
		        	System.out.println("Yes");
		        else
		        	System.out.println("No");
	        }
		}

}
