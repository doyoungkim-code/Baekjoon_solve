// 1012

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int M, N, K, x, y;

int bfs(vector <vector <int>> &nodes, vector <vector <bool>> &visited, int i, int j)
{
    int now_y, now_x;
    int cnt = 0;
    queue <pair <int, int>> q;
    if (!visited[i][j] && nodes[i][j] == 1)
    {
        cnt ++;
        visited[i][j] = true;
        q.push({i, j});
        while (!q.empty())
        {
            now_y = q.front().first;
            now_x = q.front().second;
            q.pop();
            if (now_y + 1 < N && !visited[now_y + 1][now_x] && nodes[now_y + 1][now_x] == 1)
            {
                visited[now_y + 1][now_x] = true;
                q.push({now_y + 1, now_x});
            }
            if (now_y - 1 >= 0 && !visited[now_y - 1][now_x] && nodes[now_y - 1][now_x] == 1)
            {
                visited[now_y - 1][now_x] = true;
                q.push({now_y - 1, now_x});
            }
            if (now_x + 1 < M && !visited[now_y][now_x + 1] && nodes[now_y][now_x + 1] == 1)
            {
                visited[now_y][now_x + 1] = true;
                q.push({now_y, now_x + 1});
            }
            if (now_x - 1 >= 0 && !visited[now_y][now_x - 1] && nodes[now_y][now_x - 1] == 1)
            {
                visited[now_y][now_x - 1] = true;
                q.push({now_y, now_x - 1});
            }
        }
        return (cnt);
    }
    return (0);
}

int main(void)
{
    int T;

    cin.tie(0);
    ios::sync_with_stdio(0);

    cin >> T;
    for (int t = 0; t < T; t ++)
    {
        int res = 0;
        cin >> M >> N >> K;
        vector <vector <int>> nodes(N, vector <int> (M, 0));
        vector <vector <bool>> visited(N, vector <bool> (M, false));
        for (int j = 0; j < K; j ++)
        {
            cin >> x >> y;
            nodes[y][x] = 1;
        }
        for (int i = 0; i < N; i ++)
        {
            for (int j = 0; j < M; j ++)
            {
                res = res + bfs(nodes, visited, i, j);
            }
        }
        cout << res << "\n";
    }
}