import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for (int i = 0; i < 5; ++i)
		{
			int input = Integer.parseInt(br.readLine());
			if (input < 40)
				input = 40;
			
			sum += input;
		}
		
		System.out.println(sum / 5);
	}

}
