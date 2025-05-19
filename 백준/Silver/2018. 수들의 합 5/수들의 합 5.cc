// 2018

#include <iostream>

using namespace std;

int main(void)
{
    int N;
    int res = 0;
    cin >> N;
    for (int i = 1; i <= N; i ++)
    {
        int sum = 0;
        for (int j = i; j <= i + N; j ++)
        {
            sum = sum + j;
            if (sum == N)
            {
                res ++;
                break;
            }
            if (sum > N)
                break;
        }
    }
    cout << res;
}