// 14716

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int bfs(vector <vector <int>> &v, vector <vector <bool>> &visited, int i, int j, int M, int N)
{
    queue <pair <int, int>> q;
    if (! visited[i][j] && v[i][j] == 1)
    {
        visited[i][j] = true;
        q.push({i, j});
        while (! q.empty())
        {
            int ny = q.front().first;
            int nx = q.front().second;
            q.pop();

            int dy[8] = {0, 1, 0, -1, 1, 1, -1, -1};
            int dx[8] = {1, 0, -1, 0, 1, -1, 1, -1};

            for (int k = 0; k < 8; k ++)
            {
                int ry = ny + dy[k];
                int rx = nx + dx[k];
                if (ry >= 0 && ry < M && rx >= 0 && rx < N && v[ry][rx] == 1 && !visited[ry][rx])
                {
                    visited[ry][rx] = true;
                    q.push({ry, rx});
                }
            }
        }
        return (1);        
    }
    return (0);
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int M, N;
    cin >> M >> N;
    vector <vector <int>> v(M, vector <int>(N, 0));
    vector <vector <bool>> visited(M, vector <bool>(N, false));

    for (int i = 0; i < M; i ++)
    {
        for (int j = 0; j < N; j ++)
        {
            cin >> v[i][j];
        }
    }
    int res = 0;
    for (int i = 0; i < M; i ++)
    {
        for (int j = 0; j < N; j ++)
        {
            res = res + bfs(v, visited, i, j, M, N);
        }
    }
    cout << res;
}