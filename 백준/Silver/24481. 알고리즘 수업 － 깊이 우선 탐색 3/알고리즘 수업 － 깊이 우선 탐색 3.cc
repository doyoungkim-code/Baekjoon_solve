// 24481

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, R, a, b;
vector <int> nodes[100001];
int result[100001] = {0, };
bool visited[100001] = {false, };

void dfs(int n)
{
    for (int i = 0; i < nodes[n].size(); i ++)
    {
        if (!visited[nodes[n][i]])
        {
            visited[nodes[n][i]] = true;
            result[nodes[n][i]] = result[n] + 1;
            dfs(nodes[n][i]);
        }
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N >> M >> R;
    for (int i = 0; i < M; i ++)
    {
        cin >> a >> b;
        nodes[a].push_back(b);
        nodes[b].push_back(a);
    }
    for (int i = 1; i <= N; i ++)
    {
        sort(nodes[i].begin(), nodes[i].end());
    }
    visited[R] = true;
    dfs(R);
    for (int i = 1; i <= N; i ++)
    {
        if (i != R && result[i] == 0)
            cout << "-1\n";
        else
            cout << result[i] << "\n";
    }
}