#include <iostream>

using namespace std;

int main(void)
{
    int N;
    int min = 2147483647;
    int n, nn;
    cin >> N;
    for (int i = N; i >= 0; i --)
    {
        int sum = 0;
        sum = sum + i;
        n = i;
        while (1)
        {
            nn = n % 10;
            n = n / 10;
            sum = sum + nn;
            if (n == 0)
                break;
        }
        if (sum == N && min > i)
        {
            min = i;
        }
    }
    if (min != 2147483647)
        cout << min;
    else
        cout << 0;
}