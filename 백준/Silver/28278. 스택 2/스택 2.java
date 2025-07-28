import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Stack <Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++)
		{
			int order = sc.nextInt();
			if (order == 1)
			{
				stack.push(sc.nextInt());
			}
			else if (order == 2)
			{
				if (!stack.isEmpty())
				{
					sb.append(stack.pop()).append("\n");
				}
				else
				{
					sb.append(-1).append("\n");
				}
					
			}
			else if (order == 3)
			{
				sb.append(stack.size()).append("\n");
			}
			else if (order == 4)
			{
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			}
			else if (order == 5)
			{
				if (!stack.isEmpty())
				{
					sb.append(stack.peek()).append("\n");
				}
				else
				{
					sb.append(-1).append("\n");
				}
			}
		}
		System.out.print(sb);
		sc.close();
	}
}

