// 1303

#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int N, M;

int bfs(vector <vector <char>> v, vector <vector <bool>> &visited, int i, int j)
{
    int cnt = 1;
    queue <pair <int, int>> q;
    if (v[i][j] == 'W' && !visited[i][j])
    {
        visited[i][j] = true;
        q.push({i, j});
        while (!q.empty())
        {
            int ny = q.front().first;
            int nx = q.front().second;
            q.pop();
            
            int dy[4] = {0, 0, 1, -1};
            int dx[4] = {1, -1, 0, 0};
            for (int k = 0; k < 4; k ++)
            {
                int ry = ny + dy[k];
                int rx = nx + dx[k];
                if (ry >= 0 && ry < M && rx >= 0 && rx < N && ! visited[ry][rx] && v[ry][rx] == 'W')
                {
                    cnt ++;
                    visited[ry][rx] = true;
                    q.push({ry, rx});
                }
            }
        }
    }
    else if (v[i][j] == 'B' && !visited[i][j])
    {
        visited[i][j] = true;
        q.push({i, j});
        while (!q.empty())
        {
            int ny = q.front().first;
            int nx = q.front().second;
            q.pop();
            
            int dy[4] = {0, 0, 1, -1};
            int dx[4] = {1, -1, 0, 0};
            for (int k = 0; k < 4; k ++)
            {
                int ry = ny + dy[k];
                int rx = nx + dx[k];
                if (ry >= 0 && ry < M && rx >= 0 && rx < N && ! visited[ry][rx] && v[ry][rx] == 'B')
                {
                    cnt ++;
                    visited[ry][rx] = true;
                    q.push({ry, rx});
                }
            }
        }
    }
    else
        return (0);
    return (cnt * cnt);
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int W_result = 0;
    int B_result = 0;
    cin >> N >> M;
    vector <vector <char>> v(M, vector <char>(N, 0));
    vector <vector <bool>> visited_W(M, vector <bool> (N, false));
    vector <vector <bool>> visited_B(M, vector <bool> (N, false));
    for (int i = 0; i < M; i ++)
    {
        for (int j = 0; j < N; j ++)
            cin >> v[i][j];
    }

    for (int i = 0; i < M; i ++)
    {
        for (int j = 0; j < N; j ++)
        {
            if (v[i][j] == 'W')
                W_result = W_result + bfs(v, visited_W, i, j);
            else
                B_result = B_result + bfs(v, visited_B, i, j);
        }
    }
    cout << W_result << " " << B_result;
}