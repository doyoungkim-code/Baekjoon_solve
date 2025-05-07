// 24444

#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

queue <int> q;
vector <int> nodes[100001];
int result[100001];
int cnt = 1;
bool visited[100001] = {false, };

void bfs(){
    int frontOfQueue = q.front();
    while (!nodes[frontOfQueue].empty())
    {
        if (visited[nodes[frontOfQueue].back()] == false)
        {
            q.push(nodes[frontOfQueue].back());
            visited[nodes[frontOfQueue].back()] = true;
        }
        nodes[frontOfQueue].pop_back();
    }
    result[q.front()] = cnt;
    ++ cnt;
    q.pop();
}

int main(void){
    int N, M, R, a, b;
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> N >> M >> R;
    
    for (int i = 0; i < M; i ++)
    {
        cin >> a >> b;
        nodes[a].push_back(b);
        nodes[b].push_back(a);
    }
    for (int i = 1; i <= N; i ++)
    {
        sort(nodes[i].begin(), nodes[i].end(), greater <int>());
    }
    q.push(R);
    visited[R] = true;
    while (!q.empty())
        bfs();
    for (int i = 1; i <= N; i ++)
    {
        cout << result[i] << "\n";
    }
}