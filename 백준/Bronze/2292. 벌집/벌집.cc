#include <iostream>
using namespace std;

int main(void)
{
    int N, num;
    int count = 0;
    int six = 0;
    cin >> N;
    if (N == 1)
        cout << "1";
    else
    {
        num = N - 1;
        while (1)
        {
            six ++;
            count ++;
            num = (num) - six * 6;
            if (num <= 0)
                break;
        }
        cout << count + 1;
    }
}