import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static char[][] g;
    static int[][] v;
    static int sx, sy, ex, ey;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        g = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                g[i][j] = row.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;
        ex = Integer.parseInt(st.nextToken()) - 1;
        ey = Integer.parseInt(st.nextToken()) - 1;

        v = new int[n][m];
        for (int[] row : v) {
            Arrays.fill(row, -1);
        }
        System.out.println(bfs());
    }

    static int bfs() {
    	ArrayDeque<P> q = new ArrayDeque<>();

        q.offer(new P(sx, sy));
        v[sx][sy] = 0;

        while (!q.isEmpty()) {
            P cur = q.poll();

            if (cur.x == ex && cur.y == ey) {
                return v[cur.x][cur.y];
            }

            for (int d = 0; d < 4; d++) {
                for (int i = 1; i <= k; i++) {
                    int nx = cur.x + dx[d] * i;
                    int ny = cur.y + dy[d] * i;

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || g[nx][ny] == '#') {
                        break;
                    }

                    if (v[nx][ny] != -1) {
                        if (v[nx][ny] < v[cur.x][cur.y] + 1) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    
                    v[nx][ny] = v[cur.x][cur.y] + 1;
                    q.offer(new P(nx, ny));
                }
            }
        }
        
        return -1;
    }

    static class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}