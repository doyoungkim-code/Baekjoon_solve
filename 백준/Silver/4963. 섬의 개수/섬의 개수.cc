// 4963

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int bfs(vector <vector <int>> &v, vector <vector <bool>> &visited, int i, int j, int w, int h)
{
    queue <pair <int, int>> q;
    if (!visited[i][j] && v[i][j] == 1)
    {
        visited[i][j] = true;
        q.push({i, j});
        while (! q.empty())
        {
            int ny = q.front().first;
            int nx = q.front().second;
            q.pop();

            int dy[8] = {0, 0, 1, -1, 1, 1, -1, -1};
            int dx[8] = {1, -1, 0, 0, 1, -1, 1, -1};

            for (int a = 0; a < 8; a ++)
            {
                int ry = ny + dy[a];
                int rx = nx + dx[a];
                if (ry >= 0 && ry < h && rx >= 0 && rx < w && v[ry][rx] == 1 && !visited[ry][rx])
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

    int n;
    int w = 1;
    int h = 1;
    
    while (!(w == 0 && h == 0))
    {
        cin >> w >> h;
        if (w == 0 && h == 0)
            break ;
        vector <vector <int>> v(h, vector <int>(w, 0));
        vector <vector <bool>> visited(h, vector <bool>(w, false));
        for (int i = 0; i < h; i ++)
        {
            for (int j = 0; j < w; j ++)
            {
                cin >> n;
                v[i][j] = n;
            }
        }
        int res = 0;
        for (int i = 0; i < h; i ++)
        {
            for (int j = 0; j < w; j ++)
            {
                res = res + bfs(v, visited, i, j, w, h);
            }
        }
        cout << res << "\n";
    }
}