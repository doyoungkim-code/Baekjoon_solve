// 3040

#include <iostream>

int main(void){
    int num[9];
    int sum = 0;
    int res_i, res_j;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    for (int i = 0; i < 9; i++)
    {
        std::cin >> num[i];
        sum = sum + num[i];
    }
    sum = sum - 100;
    for (int i = 0; i < 9; i++)
    {
        for (int j = i + 1; j < 9; j ++)
        {
            if (num[i] + num[j] == sum)
            {
                res_i = i;
                res_j = j;
            }
        }
    }
    for (int i = 0; i < 9; i ++)
    {
        if (i == res_i || i == res_j)
            continue;
        std::cout << num[i] << "\n";
    }
}