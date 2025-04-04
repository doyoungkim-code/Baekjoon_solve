import java.util.Scanner;

public class Main {
    static int top;
    static int stacks[] = new int[50];

    static int pushStack(){
        if (top >= 50)
            return (1);
        stacks[top] = 1;
        top ++;
        return (0);
    }
    static int popStack(){
        if (top == 0)
            return (1);
        stacks[top] = 0;
        top --;
        return (0);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i ++)
        {
            top = 0;
            String S = sc.nextLine();
            for (int j = 0; j < S.length(); j ++)
            {
                int res = 0;
                if (S.charAt(j) == '(') {
                    res = pushStack();
                }
                else if (S.charAt(j) == ')'){
                    res = popStack();
                }
                if (res == 1)
                {
                    top = 1;
                    break ;
                }
            }
            if (top == 0)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
