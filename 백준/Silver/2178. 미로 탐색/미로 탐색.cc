// 2178

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector <vector <char>> grid;
bool visited[101][101] = {false, };
int count[101][101] = {0, };

void bfs(void)
{
    queue <pair <int, int>> q;
    q.push({0, 0});
    visited[0][0] = true;
    count[0][0] = 1;
    while (!q.empty())
    {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        if (y - 1 >= 0 && grid[y - 1][x] == '1' && visited[y - 1][x] == false)
        {
            q.push({y - 1, x});
            visited[y - 1][x] = true;
            count[y - 1][x] = count[y][x] + 1;
        }
        if (y + 1 < N && grid[y + 1][x] == '1' && visited[y + 1][x] == false)
        {
            q.push({y + 1, x});
            visited[y + 1][x] = true;
            count[y + 1][x] = count[y][x] + 1;
        }
        if (x - 1 >= 0 && grid[y][x - 1] == '1' && visited[y][x - 1] == false)
        {
            q.push({y, x - 1});
            visited[y][x - 1] = true;
            count[y][x - 1] = count[y][x] + 1;
        }
        if (x + 1 < M && grid[y][x + 1] == '1' && visited[y][x + 1] == false)
        {
            q.push({y, x + 1});
            visited[y][x + 1] = true;
            count[y][x + 1] = count[y][x] + 1;
        }
    }
}

int main(void)
{
    cin >> N >> M;
    grid = vector <vector <char>> (N, vector <char> (M, 0));
    for (int i = 0; i < N; i ++)
    {
        for (int j = 0; j < M; j ++)
        {
            cin >> grid[i][j];
        }
    }
    bfs();
    cout << count[N - 1][M - 1];
}