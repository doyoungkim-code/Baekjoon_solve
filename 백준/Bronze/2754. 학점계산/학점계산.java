import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		char a = str.charAt(0);
		if (a == 'F')
		{
			System.out.println("0.0");
			return ;
		}
		char b = str.charAt(1);
		
		double res = 0.0;
		
		if (a == 'A')
			res += 4.0;
		else if (a == 'B')
			res += 3.0;
		else if (a == 'C')
			res += 2.0;
		else if (a == 'D')
			res += 1.0;
		
		if (b == '+')
			res += 0.3;
		else if (b == '-')
			res -= 0.3;
		
		System.out.println(res);
	}

}
