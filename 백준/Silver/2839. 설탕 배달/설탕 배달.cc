// 2839

#include <iostream>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int result = 0;
    int N;
    cin >> N;
    int sum = N;
    while (1)
    {
        if (sum % 5 == 0)
        {
            cout << result + (sum / 5);
            break ;
        }
        else if (sum % 5 == 3)
        {
            cout << result + (sum / 5) + 1;
            break ;
        }
        else
        {
            result = result + 1;
            sum = sum - 3;
        }
        if (sum < 3)
        {
            cout << "-1";
            break;
        }
    }
}