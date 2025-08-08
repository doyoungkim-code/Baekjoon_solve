
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int R = Integer.parseInt(str[2]);

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i ++)
        {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j ++)
            {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int[][] new_arr = new int[N][M];
        
        int grade = 0;
        int new_N = N;
        int new_M = M;
        
        while (grade < new_N && grade < new_M)
        {
	        LinkedList<Integer> arr_new = new LinkedList<>();
	        
	        for (int i = grade; i < new_N; ++i)
	        	arr_new.add(arr[i][grade]);
	    	for (int j = grade + 1; j < new_M; ++j)
	    		arr_new.add(arr[new_N - 1][j]);
	    	for (int k = new_N - 2; k >= grade; k--)
	    		arr_new.add(arr[k][new_M - 1]);
	    	for (int l = new_M - 2; l >= grade + 1; l--)
	    		arr_new.add(arr[grade][l]);
	    	
	    	if (arr_new.isEmpty())
	    		break;
	    	
	    	Collections.rotate(arr_new, R % arr_new.size());
	    	
	        for (int i = grade; i < new_N; ++i)
	        	new_arr[i][grade] = arr_new.pollFirst();
	    	for (int j = grade + 1; j < new_M; ++j)
	    		new_arr[new_N - 1][j] = arr_new.pollFirst();
	    	for (int k = new_N - 2; k >= grade; k--)
	    		new_arr[k][new_M - 1] = arr_new.pollFirst();
	    	for (int l = new_M - 2; l >= grade + 1; l--)
	    		new_arr[grade][l] = arr_new.pollFirst();
	    	
	    	grade ++;
	    	new_N --;
	    	new_M --;
        }
        
        for (int i = 0; i < N; i ++)
        {
            for (int j = 0; j < M; j++)
            {
                sb.append(new_arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}