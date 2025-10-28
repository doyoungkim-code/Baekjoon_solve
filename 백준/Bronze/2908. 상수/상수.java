import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       
       int newA = (a / 100) + ((a / 10) % 10) * 10 + (a % 10) * 100;
       int newB = (b / 100) + ((b / 10) % 10) * 10 + (b % 10) * 100;
       
       if (newA < newB)
    	   System.out.println(newB);
       else
    	   System.out.println(newA);
    }
}