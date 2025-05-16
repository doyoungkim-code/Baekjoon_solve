// 2491

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int N;
    cin >> N;
    vector <int> v;
    for (int i = 0; i < N; i++)
    {
        int num;
        cin >> num;
        v.push_back(num);
    }
    int max_len = 0;
    int len = 1;
    for (int i = 1; i < N; i ++)
    {
        if (v[i - 1] <= v[i])
            len ++;
        else
        {
            if (max_len < len)
                max_len = len;
            len = 1;
        }
    }
    if (max_len < len)
        max_len = len;
    len = 1;
    for (int i = 1; i < N; i ++)
    {
        if (v[i - 1] >= v[i])
            len ++;
        else
        {
            if (max_len < len)
                max_len = len;
            len = 1;
        }
    }
    if (max_len < len)
        max_len = len;
    cout << max_len;
}