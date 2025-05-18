// 4673

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    vector <bool> v(10000, false);
    for (int i = 1; i <= 10000; i ++)
    {
        if (!v[i])
        {
            cout << i << "\n";
            v[i] = true;
            int num;
            num = i;
            while (num <= 10000)
            {
                int ix = num;
                while (ix > 0)
                {
                    num = num + ix % 10;
                    ix = ix / 10;
                }
                v[num] = true;
            }
        }
    }
}