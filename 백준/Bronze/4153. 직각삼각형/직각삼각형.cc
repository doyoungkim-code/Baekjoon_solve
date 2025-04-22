#include <iostream>

int main(void){
    int a, b, c;
    while (1)
    {
        std::cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0)
            break ;
        if ((a * a) + (b * b) == (c * c) ||\
        (a * a) + (c * c) == (b * b) ||\
        (c * c) + (b * b) == (a * a))
            std::cout << "right\n";
        else
            std::cout << "wrong\n";
    }
}