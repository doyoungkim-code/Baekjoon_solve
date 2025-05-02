// 1952

#include <iostream>

int main(void){
    int M, N, result = 0;
    std::cin >> M >> N;
    while (1)
    {
        if (M > 1)
        {
            M --;
            result ++;
        }
        else
            break;
        if (N > 1)
        {
            N --;
            result ++;
        }
        else
            break;
    }
    std::cout << result;
}