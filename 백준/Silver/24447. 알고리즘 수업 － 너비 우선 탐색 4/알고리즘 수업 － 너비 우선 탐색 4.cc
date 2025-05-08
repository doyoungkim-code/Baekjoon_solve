// 24447

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, R, a, b, cnt;
long long result;
queue <int> q;
vector <int> nodes[100001];
long long depth[100001] = {0, };
long long order[100001] = {0, };
bool visited[100001] = {false, };

void dfs(void)
{
    cnt = 1;
    q.push(R);
    depth[R] = 0;
    order[R] = cnt ++;
    visited[R] = true;
    while (!q.empty())
    {
        int n = q.front();
        q.pop();
        for (int i = 0; i < nodes[n].size(); i ++)
        {
            if (visited[nodes[n][i]] == false)
            {
                q.push(nodes[n][i]);
                depth[nodes[n][i]] = depth[n] + 1;
                order[nodes[n][i]] = cnt ++;
                visited[nodes[n][i]] = true;
            }
        }
    }
}

int main(void){
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> N >> M >> R;
    for (int i = 0; i < M; ++ i)
    {
        cin >> a >> b;
        nodes[a].push_back(b);
        nodes[b].push_back(a);
    }
    for (int i = 1; i <= N; ++ i)
        sort(nodes[i].begin(), nodes[i].end());
    dfs();
    result = 0;
    for (int i = 1; i <= N; ++ i)
    {
        if (i != R && depth[i] == 0)
            continue ;
        result = result + (depth[i] * order[i]);
    }
    cout << result;
}