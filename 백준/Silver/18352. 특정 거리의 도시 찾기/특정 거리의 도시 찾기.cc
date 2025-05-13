// 18352

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M, K, X, A, B;
bool flag = false;
vector <int> v[300001];
bool visited[300001] = {false, };
int result[300001] = {0, };

void bfs()
{
    queue <int> q;
    visited[X] = true;
    q.push(X);
    while (!q.empty())
    {
        int n = q.front();
        q.pop();
        for (int i = 0; i < v[n].size(); i ++)
        {
            if (!visited[v[n][i]])
            {
                visited[v[n][i]] = true;
                result[v[n][i]] = result[n] + 1;
                q.push(v[n][i]);
            }
        }
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    cin >> N >> M >> K >> X;
    for (int i = 0; i < M; i ++)
    {
        cin >> A >> B;
        v[A].push_back(B);
    }
    bfs();
    for (int i = 1; i <= N; i ++)
    {
        if (result[i] == K)
        {
            cout << i << "\n";
            flag = true;
        }
    }
    if (flag == false)
        cout << "-1";
}