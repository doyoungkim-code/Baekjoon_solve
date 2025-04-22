#include <iostream>

int main(void){
    int a;
    std::cin >> a;
    for (int i = 1; i <= 9; i++)
    {
        std::cout << a << " * " << i << " = " << a * i << "\n";
    }
}