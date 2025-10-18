#include <iostream>

using namespace std;

int main()
{
    int a;
    cin >> a;

    string s;
    cin >> s;

    long res = 0;
    long n = 0;
    for (char c : s)
    {
        long l = (c - 'a' + 1);
        for (int k = 0; k < n; ++k)
        {
            l = l * 31;
            l = l % 1234567891;
        }
        res += l;
        n ++;
    }

    cout << res % 1234567891 << endl;
}
