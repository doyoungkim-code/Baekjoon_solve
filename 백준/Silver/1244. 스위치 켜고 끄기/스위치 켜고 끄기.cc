// 1244

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int n; // 스위치 개수
    int h; // 학생 수
    int mw; // 남녀
    int num; // 받은 숫자

    cin >> n;
    vector <bool> v(n + 1, 0);
    for (int i = 1; i <= n; i ++)
    {
        bool b;
        cin >> b;
        v[i] = b;
    }

    cin >> h;
    for (int i = 0; i < h; i ++)
    {
        cin >> mw >> num;
        if (mw == 1)
        {
            for (int j = 1; j <= n; j ++)
            {
                if (j % num == 0)
                    v[j] = !(v[j]);
            }
        }
        else if (mw == 2)
        {
            v[num] = !(v[num]);
            int a = 1;
            while (num - a > 0 && num + a <= n)
            {
                if (v[num - a] == v[num + a])
                {
                    v[num - a] = !(v[num - a]);
                    v[num + a] = !(v[num + a]);
                    a ++;
                }
                else
                    break;
            }
        }
    }
    for (int i = 1; i <= n; i ++)
    {
        cout << v[i] << " ";
        if (i % 20 == 0)
            cout << "\n";
    }
}