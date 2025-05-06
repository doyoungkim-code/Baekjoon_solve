// 1926

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;

int bfs(int i, int j, vector <vector <int>> &grid, vector <vector <bool>> &visited)
{
    int res = 1;
    int y, x;
    queue <pair <int, int>> q;
    q.push({i, j});
    while (!q.empty())
    {
        y = q.front().first;
        x = q.front().second;
        q.pop();
        if (y + 1 < n && grid[y + 1][x] == 1 && visited[y + 1][x] == false)
        {
            ++ res;
            visited[y + 1][x] = true;
            q.push({y + 1, x});
        }
        if (y - 1 >= 0 && grid[y - 1][x] == 1 && visited[y - 1][x] == false)
        {
            ++ res;
            visited[y - 1][x] = true;
            q.push({y - 1, x});
        }
        if (x + 1 < m && grid[y][x + 1] == 1 && visited[y][x + 1] == false)
        {
            ++ res;
            visited[y][x + 1] = true;
            q.push({y , x + 1});
        }
        if (x - 1 >= 0 && grid[y][x - 1] == 1 && visited[y][x - 1] == false)
        {
            ++ res;
            visited[y][x - 1] = true;
            q.push({y , x - 1});
        }
    }
    return (res);
}

int main(void){
    int result;
    int num = 0;
    int max = 0;
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    vector <vector <int>> grid(n, vector <int> (m, 0));
    vector <vector <bool>> visited(n, vector <bool> (m, false));
    
    for (int i = 0; i < n; i ++)
    {
        for (int j = 0; j < m; j ++)
        {
            cin >> grid[i][j];
        }
    }

    for (int i = 0; i < n; i ++)
    {
        for (int j = 0; j < m; j ++)
        {
            if (grid[i][j] == 1 && visited[i][j] == false)
            {
                ++ num;
                visited[i][j] = true;
                result = bfs(i, j, grid, visited);
                if (max < result)
                    max = result;
            }
        }
    }
    cout << num << "\n" << max;
}