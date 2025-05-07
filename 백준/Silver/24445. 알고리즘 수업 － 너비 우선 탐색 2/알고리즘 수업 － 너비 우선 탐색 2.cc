// 24445

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, R, a, b, cnt;
queue <int> q;
vector <int> nodes[100001];
int result[100001] = {0, };
bool visited[100001] = {false, };

void bfs(void)
{
    cnt = 1;
    q.push(R);
    result[R] = cnt;
    visited[R] = true;
    while (! q.empty())
    {
        int n = q.front();

        while (! nodes[n].empty())
        {
            if (!visited[nodes[n].back()])
            {
                result[nodes[n].back()] = ++ cnt;
                visited[nodes[n].back()] = true;
                q.push(nodes[n].back());
            }
            nodes[n].pop_back();
        }
        q.pop();
    }
}

int main(void){
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
        sort(nodes[i].begin(), nodes[i].end());
    bfs();
    for (int i = 1; i <= N; i ++)
    {
        cout << result[i] << "\n";
    }
}