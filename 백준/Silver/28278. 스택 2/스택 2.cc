#include <iostream>
#include <stack>

int main(void){
    int N, com, num;
    std::stack <int> st;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    for (int i = 0; i < N; i ++){
        std::cin >> com;
        if (com == 1){
            std::cin >> num;
            st.push(num);
        }
        else if (com == 2){
            if (st.empty())
                std::cout << "-1\n";
            else{
                std::cout << st.top() << "\n";
                st.pop();
            }
        }
        else if (com == 3)
            std::cout << st.size() << "\n";
        else if (com == 4)
            std::cout << st.empty() << "\n";
        else if (com == 5){
            if (st.empty())
                std::cout << "-1\n";
            else
                std::cout << st.top() << "\n";
        }
    }
}