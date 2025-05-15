// 2304

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    int N, a, b;
    int sum = 0;
    int max_value = 0;
    cin >> N;
    vector <pair <int, int>> v;
    for (int i = 0; i < N; i ++)
    {
        cin >> a >> b;
        if (max_value < b)
        {
            max_value = b;
        }
        v.push_back({a, b});
    }
    sum = sum + max_value;
    sort(v.begin(), v.end());

    int max_index;
    int iterate_index;
    for (int i = 0; i < v.size(); i ++)
    {
        if (max_value == v[i].second)
        {
            max_index = i;
        }
    }
    iterate_index = max_index;
    while (iterate_index > 0)
    {
        int part_max = 0;
        int part_max_index;
        for (int i = 0; i < iterate_index; i ++)
        {
            if (part_max < v[i].second)
            {
                part_max = v[i].second;
                part_max_index = i;
            }
        }
        sum = sum + (v[iterate_index].first - v[part_max_index].first) * part_max;
        iterate_index = part_max_index;
    }
    iterate_index = max_index;
    while (iterate_index < v.size() - 1)
    {
        int part_max = 0;
        int part_max_index;
        for (int i = v.size() - 1; i > iterate_index; i --)
        {
            if (part_max < v[i].second)
            {
                part_max = v[i].second;
                part_max_index = i;
            }
        }
        sum = sum + (- v[iterate_index].first + v[part_max_index].first) * part_max;
        iterate_index = part_max_index;
    }
    cout << sum;
}