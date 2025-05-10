//// // 24484

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, R, a, b;
int cnt = 1;
long long res = 0;
vector <int> nodes[100001];
int result[100001] = {0, };
int order[100001] = {0, };
bool visited[100001] = {false, };

void dfs(int n)
{
    for (int i = 0; i < nodes[n].size(); i ++)
    {
        if (! visited[nodes[n][i]])
        {
            result[nodes[n][i]] = result[n] + 1;
            order[nodes[n][i]] = ++ cnt;
            visited[nodes[n][i]] = true;
            dfs(nodes[n][i]);
        }
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N >> M >> R;
    for (int i = 0; i < M; i++)
    {
        cin >> a >> b;
        nodes[a].push_back(b);
        nodes[b].push_back(a);
    }
    for (int i = 1; i <= N; i ++)
    {
        sort(nodes[i].begin(), nodes[i].end(), greater<int>());
    }
    visited[R] = true;
    order[R] = 1;
    dfs(R);
    for (int i = 1; i <= N; i ++)
    {
        if (i != R && result[i] == 0)
            continue ;
        else
            res = res + ((long long)result[i] * (long long) order[i]);
    }
    cout << res;
}