import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String str = br.readLine();
	        
	        int res = 0;
	        for (int i = 0; i < str.length(); ++i)
	        {
	        	char a = str.charAt(i);
	        	if (a == 'A' || a == 'B' || a == 'C')
	        		res += 3;
	        	else if (a == 'D' || a == 'E' || a == 'F')
	        		res += 4;
	        	else if (a == 'G' || a == 'H' || a == 'I')
	        		res += 5;
	        	else if (a == 'J' || a == 'K' || a == 'L')
	        		res += 6;
	        	else if (a == 'M' || a == 'N' || a == 'O')
	        		res += 7;
	        	else if (a == 'P' || a == 'Q' || a == 'R' || a == 'S')
	        		res += 8;
	        	else if (a == 'T' || a == 'U' || a == 'V')
	        		res += 9;
	        	else if (a == 'W' || a == 'X' || a == 'Y' || a == 'Z')
	        		res += 10;
	        }
	        System.out.println(res);
		}

}
