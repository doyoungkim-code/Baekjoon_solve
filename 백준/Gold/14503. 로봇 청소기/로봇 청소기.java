import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int cleanedCount;
    static int[][] room;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 시작
        clean(r, c, d);
        
        // 결과 출력
        System.out.println(cleanedCount);
    }

    static void clean(int r, int c, int d) {
        // 1. 현재 위치를 청소
        if (room[r][c] == 0) {
            room[r][c] = 2;
            cleanedCount++;
        }

        // 2. 왼쪽 방향부터 탐색
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
                clean(nr, nc, d);
                return;
            }
        }

        // 3. 후진 시도
        int backDirection = (d + 2) % 4;
        int br = r + dr[backDirection];
        int bc = c + dc[backDirection];

        if (br >= 0 && br < n && bc >= 0 && bc < m && room[br][bc] != 1) {
            clean(br, bc, d);
        }
    }
}