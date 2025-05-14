// 3273

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int n, x, po_l, po_r;
    int cnt = 0;
    cin >> n;
    vector <int> v(n, 0);
    for (int i = 0; i < n; i ++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    cin >> x;

    po_l = 0;
    po_r = n - 1;
    while (1)
    {
        if (po_r <= po_l)
            break ;
        if (v[po_l] + v[po_r] == x)
        {
            po_r --;
            cnt ++;
        }
        else if (v[po_l] + v[po_r] < x)
            po_l ++;
        else if (v[po_l] + v[po_r] > x)
            po_r --;
    }
    cout << cnt;
}