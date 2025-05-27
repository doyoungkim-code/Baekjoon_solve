// 15953

#include <iostream>
#include <vector>

using namespace std;

vector <int> first_fest(100, 0);
vector <int> second_fest(64, 0);

void pre_func(void)
{
    first_fest[1] = 5000000;
    second_fest[1] = 5120000;
    for (int i = 2; i < 4; ++i)
    {
        first_fest[i] = 3000000;
        second_fest[i] = 2560000;
    }
    for (int i = 4; i < 7; ++i)
    {
        first_fest[i] = 2000000;
        second_fest[i] = 1280000;
    }
    second_fest[7] = 1280000;
    for (int i = 7; i < 11; ++i)
    {
        first_fest[i] = 500000;
    }
    for (int i = 8; i < 16; ++i)
    {
        second_fest[i] = 640000;
    }
    for (int i = 11; i < 16; ++i)
    {
        first_fest[i] = 300000;
    }
    for (int i = 16; i < 22; ++i)
    {
        first_fest[i] = 100000;
        second_fest[i] = 320000;
    }
    for (int i = 22; i < 32; ++i)
    {
        second_fest[i] = 320000;
    }
}

int main(void)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

    int T;

    pre_func();
    cin >> T;
    for (int t = 0; t < T; ++t)
    {
        int a, b;
        cin >> a >> b;
        cout << first_fest[a] + second_fest[b] << "\n";
    }
}