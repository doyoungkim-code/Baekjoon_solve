#include <iostream>
#include <stack>

int main(void){
    int N, num, turn;
    std::stack <int> st;
    turn = 1;
    std::cin >> N;
    for (int i = 0; i < N; i ++){
        std::cin >> num;
        if (turn == num)
            turn ++;
        else
            st.push(num);
        while (!st.empty() && st.top() == turn)
        {
            st.pop();
            turn ++;
        }
    }

    if (st.empty())
        std::cout << "Nice\n";
    else
        std::cout << "Sad\n";
    return (0);
}