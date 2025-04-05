import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int top;
    public static int[] stack = new int[10000];

    static void push(int n){
        stack[top] = n;
        top ++;
    }

    static int pop(){
        if (top == 0)
            return (-1);
        top --;
        return (stack[top]);
    }

    static void isEmpty(){
        if (top == 0)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        top = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i ++){
            String[] str = br.readLine().split(" ");
            if (str[0].equals("push"))
                push(Integer.parseInt(str[1]));
            else if (str[0].equals("pop"))
                System.out.println(pop());
            else if (str[0].equals("size"))
                System.out.println(top);
            else if (str[0].equals("empty"))
                isEmpty();
            else if (str[0].equals("top")) {
                    if (top == 0) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack[top - 1]);
                    }
            }
        }
    }
}
