import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        boolean[] students = new boolean[31];
	        
	        students[0] = true;
	        for (int i = 0; i < 28; ++i)
	        {
	        	int input = Integer.parseInt(br.readLine());
	        	students[input] = true;
	        }
	        
	        int num = 0;
	        for (boolean b : students)
	        {
	        	if (!b)
	        		System.out.println(num);
	        	num ++;
	        	
	        }
		}
}
