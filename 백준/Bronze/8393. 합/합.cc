#include <iostream>

int main(void){
    int T, result = 0;
    std::cin >> T;
    for (int i = 1; i <= T; i ++)
    {
        result = result + i;
    }
    std::cout << result;
}