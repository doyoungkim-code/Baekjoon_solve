#include <iostream>
using namespace std;

int main(void)
{
    int N, num, j;
    int sum = 0;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> num;
        for (j = 2; j < num; j ++)
        {
            if (num % j != 0)
                continue;
            else
                break;
        }
        if (j == num)
            sum ++;
    }
    cout << sum;
}