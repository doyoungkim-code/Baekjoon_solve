import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		int num = 0;
		for (String st : str)
		{
			if (st != "")
				num ++;
		}
		System.out.println(num);
	}
}