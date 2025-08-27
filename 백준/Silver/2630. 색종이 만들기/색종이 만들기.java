import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N;
    static int[][] arr;
    static int blue;
    static int white;

    static void check(int x, int y, int size)
    {
    	boolean flag = false;
        int now_color = arr[x][y];
        
    	if (size == 1)
    	{
    		if (now_color == 1)
    			blue ++;
    		else
    			white ++;
    		return ;
    	}

        for (int i = x; i < x + size; ++i)
        {
        	for (int j = y; j < y + size; ++j)
        	{
        		if (arr[i][j] == now_color)
        			continue ;
        		else
        		{
        			flag = true;
        			break;
        		}
        	}
        }
        if (flag)
        {
        	check(x, y, size/2);
        	check(x + size/2, y, size/2);
        	check(x, y + size/2, size/2);
        	check(x + size/2, y + size/2, size/2);
        }
        else
        {
        	if (now_color == 1)
    			blue ++;
    		else
    			white ++;
    		return ;
        }
        	
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; ++i)
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);
        System.out.println(white);
        System.out.println(blue);        
    }
}