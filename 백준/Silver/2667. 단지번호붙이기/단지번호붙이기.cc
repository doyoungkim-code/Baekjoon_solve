// 2667

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N;
vector <vector <char>> maps;
vector <vector <bool>> visited;
vector <int> result;

int dfs(int y, int x)
{
    int ret = 0;
    if (y >= N || y < 0 || x >= N || x < 0)
        return (0);
    if (maps[y][x] == '1' && visited[y][x] == false)
    {
        visited[y][x] = true;
        ret = 1;
        ret += dfs(y + 1, x);
        ret += dfs(y - 1, x);
        ret += dfs(y, x + 1);
        ret += dfs(y, x - 1);
        return (ret);
    }
    return (0);
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N;
    maps = vector <vector <char>> (N, vector <char>(N, '0'));
    visited = vector <vector <bool>> (N, vector <bool>(N, false));
    for (int i = 0; i < N; i ++)
    {
        for (int j = 0; j < N; j ++)
        {
            cin >> maps[i][j];
        }
    }
    for (int i = 0; i < N; i ++)
    {
        for (int j = 0; j < N; j ++)
        {
            int r = dfs(i, j);
            if (r != 0)
                result.push_back(r);
        }
    }
    sort(result.begin(), result.end());
    cout << result.size() << "\n";
    for (int i = 0; i < result.size(); i ++)
    {
        cout << result[i] << "\n";
    }
}