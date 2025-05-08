// 24446

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, R, a, b;
queue <int> q;
vector <int> nodes[100001];
int result[100001] = {0, };
bool visited[100001] = {false, };

void bfs(void)
{
    visited[R] = true;
    q.push(R);
    result[R] = 0;
    while (!q.empty())
    {
        int n = q.front();
        q.pop();
        for (int i = nodes[n].size() - 1; i >= 0; i --)
        {
            if (!visited[nodes[n][i]])
            {
                visited[nodes[n][i]] = true;
                q.push(nodes[n][i]);
                result[nodes[n][i]] = result[n] + 1;
            }
        }
    }
}

int main(void){
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> N >> M >> R;
    for (int i = 0; i < M; ++ i)
    {
        cin >> a >> b;
        nodes[a].push_back(b);
        nodes[b].push_back(a);
    }
    bfs();
    for (int i = 1; i <= N; ++ i)
    {
        if (i != R && result[i] == 0)
            cout << -1 << "\n";
        else
            cout << result[i] << "\n";
    }
}