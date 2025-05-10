#include <iostream>

using namespace std;

int main()
{
    int sum1 = 0;
    int ts[6];
    int N, T, P;
    cin >> N >> ts[0] >> ts[1] >> ts[2] >> ts[3] >> ts[4] >> ts[5] >> T >> P;
    for (int i = 0; i < 6; i ++)
    {
        if ((ts[i] % T) != 0)
            sum1 = sum1 + ((ts[i] + T) / T);
        else
            sum1 = sum1 + ts[i] / T;
    }
    cout << sum1 << "\n";
    cout << (N / P) << " " << (N % P);
}