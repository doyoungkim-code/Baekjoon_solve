// 1010

#include <iostream>

using namespace std;

long long combine(int n, int r)
{
    long long result = 1;
    
    if (r > n - r)
        r = n - r;
    
    for (int i = 1; i <= r; i ++)
    {
        result = result * (n - i + 1);
        result = result / i;
    }
    return (result);
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int T;
    int N, M;
    
    cin >> T;
    for (int i = 0; i < T; i ++)
    {
        cin >> N >> M;
        cout << combine(M, N) << "\n";
    }
}