//1436

#include <iostream>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int count = 0;
    int i = 666;
    int N;
    cin >> N;
    while (count != N)
    {
        int cnt = 0;
        int ix = i;
        while (cnt < 3 && ix > 0)
        {
            if (ix % 10 == 6)
                cnt ++;
            else
                cnt = 0;
            ix = ix / 10;
        }
        if (cnt == 3)
            count ++;
        if (count != N)
            i ++;
    }
    cout << i;
}