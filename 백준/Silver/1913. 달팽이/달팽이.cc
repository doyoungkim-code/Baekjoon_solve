// 1913
#include <iostream>
#include <vector>

using namespace std;

int main(void){
    int N, origin_N, xy, wanted_x, wanted_y;
    int to = 0;
    int x = 0;
    int y = 0;
    cin >> N >> xy;
    int num = N * N;
    origin_N = N;
    vector <vector <int>> v(N, vector <int> (N, 0));
    while (N > 0)
    {
        if (to == 0)
        {
            for (int i = 0; i < N; i ++)
            {
                v[y][x] = num;
                y ++;
                num --;
            }
            N --;
            y --;
            x ++;
            to = 1;
        }
        else if (to == 1)
        {
            for (int i = 0; i < N; i ++)
            {
                v[y][x] = num;
                x ++;
                num --;
            }
            x --;
            y --;
            to = 2;
        }
        else if (to == 2)
        {
            for (int i = 0; i < N; i ++)
            {
                v[y][x] = num;
                y --;
                num --;
            }
            N --;
            y ++;
            x --;
            to = 3;
        }
        else if (to == 3)
        {
            for (int i = 0; i < N; i ++)
            {
                v[y][x] = num;
                x --;
                num --;
            }
            x ++;
            y ++;
            to = 0;
        }
    }
    for (int i = 0; i < origin_N; i ++)
    {
        for (int j = 0; j < origin_N; j ++)
        {
            cout << v[i][j] << " ";
            if (v[i][j] == xy)
            {
                wanted_x = j;
                wanted_y = i;
            }
        }
        cout << "\n";
    }
    cout << wanted_y + 1 << " " << wanted_x + 1;
}