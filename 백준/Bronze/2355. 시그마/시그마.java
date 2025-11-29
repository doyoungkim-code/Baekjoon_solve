import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        long a = Long.parseLong(st.nextToken());
	        long b = Long.parseLong(st.nextToken());
	        
	        long res;
	        if (a <= b)
	        	res = (a + b) * (b - a + 1) / 2;
	        else
	        	res = (a + b) * (a - b + 1) / 2;
	        System.out.println(res);
		}

}
