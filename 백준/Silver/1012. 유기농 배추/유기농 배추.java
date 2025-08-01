import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] nodes;
    static boolean[][] visited;

    public static int bfs(int i, int j) {
        if (!visited[i][j] && nodes[i][j] == 1) {
            Queue<int[]> q = new LinkedList<>();
            visited[i][j] = true;
            q.offer(new int[]{i, j});

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int nowY = current[0];
                int nowX = current[1];

                int[] dy = {1, -1, 0, 0};
                int[] dx = {0, 0, 1, -1};

                for (int dir = 0; dir < 4; dir++) {
                    int ny = nowY + dy[dir];
                    int nx = nowX + dx[dir];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                        if (!visited[ny][nx] && nodes[ny][nx] == 1) {
                            visited[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            nodes = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                nodes[y][x] = 1;
            }

            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    res += bfs(i, j);
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}