// 2644

#include <iostream>
#include <vector>

using namespace std;

vector <int> v[101];
bool visited[101] = {false, };
int result[101] = {0, };

void dfs(int n, int end)
{
    if (n == end)
    {
        return ;
    }
    for (int i = 0; i < v[n].size(); i ++)
    {

        if (!visited[v[n][i]])
        {
            visited[v[n][i]] = true;
            result[v[n][i]] = result[n] + 1;
            dfs(v[n][i], end);
        }
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int n, a, b, m, x, y;
    cin >> n >> a >> b >> m;
    for (int i = 0; i < m; i ++)
    {
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }
    dfs(a, b);
    if (result[b] != 0)
        cout << result[b];
    else
        cout << "-1";
}