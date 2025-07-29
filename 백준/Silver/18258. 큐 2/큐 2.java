
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			switch (order) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					q.addLast(num);
					break;
				case "pop":
					sb.append(q.isEmpty() ? -1 : q.removeFirst()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					sb.append(q.isEmpty() ? 1 : 0).append("\n");
					break;
				case "front":
					sb.append(q.isEmpty() ? -1 : q.getFirst()).append("\n");
					break;
				case "back":
					sb.append(q.isEmpty() ? -1 : q.getLast()).append("\n");
					break;
			}
		}

		System.out.print(sb);
	}
}
