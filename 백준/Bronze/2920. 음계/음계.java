import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] asc = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] des = {8, 7, 6, 5, 4, 3, 2, 1};
		
		int[] arr = new int[8];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < 8; ++i)
		{
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int asc_num = 0;
		int des_num = 0;
		
		for (int i = 0; i < 8; ++i)
		{
			if (asc[i] == arr[i])
				asc_num ++;
			else if (des[i] == arr[i])
				des_num ++;
			else
				break ;
		}
		if (asc_num == 8)
			System.out.println("ascending");
		else if (des_num == 8)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
