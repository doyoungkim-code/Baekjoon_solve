// 3184

// . : 빈 필드, # : 울타리, o : 양, v : 늑대
// 4방탐색 후 울타리(#) 이거나, 범위 밖이면 종료
// o를 기준으로 탐색, 범위 내에 모두 탐색

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int R, C;

void bfs(vector <vector <char>> &v, vector <vector <bool>> &visited, int i, int j, int &wolf, int &sheep)
{
    queue <pair <int, int>> q;
    if (v[i][j] != '#' && !visited[i][j])
    {
        visited[i][j] = true;
        q.push({i, j});
        while (!q.empty())
        {
            int ny = q.front().first;
            int nx = q.front().second;
            q.pop();
            
            if (ny == 0 || nx == 0)
                return ;
            if (v[ny][nx] == 'o')
                sheep ++;
            else if (v[ny][nx] == 'v')
                wolf ++;
            
            int dy[4] = {0, 0, 1, -1};
            int dx[4] = {1, -1, 0, 0};
            
            for (int a = 0; a < 4; a ++)
            {
                int ry = ny + dy[a];
                int rx = nx + dx[a];

                if (ry >= 0 && ry < R && rx >= 0 && rx < C && ! visited[ry][rx] && v[ry][rx] != '#')
                {
                    visited[ry][rx] = true;
                    q.push({ry, rx});
                }
            }
        }
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> R >> C;
    vector <vector <char>> v(R, vector <char> (C, 0));
    vector <vector <bool>> visited(R, vector <bool> (C, false));
    int result_sheep = 0;
    int result_wolf = 0;
    for (int i = 0; i < R; i ++)
    {
        for (int j = 0; j < C; j ++)
        {
            cin >> v[i][j];
        }
    }
    for (int i = 0; i < R; i ++)
    {
        for (int j = 0; j < C; j ++)
        {
            int wolf = 0;
            int sheep = 0;
            bfs(v, visited, i, j, wolf, sheep);
            if (sheep > wolf)
                result_sheep += sheep;
            else
                result_wolf += wolf;
        }
    }
    cout << result_sheep << " " << result_wolf;
}