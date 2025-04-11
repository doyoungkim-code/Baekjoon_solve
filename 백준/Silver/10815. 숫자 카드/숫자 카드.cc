#include <iostream>
#include <set>

int main(void){
    int N, M, num;
    std::set <int> st;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    for (int i = 0; i < N; i ++){
        std::cin >> num;
        st.insert(num);
    }
    std::cin >> M;
    for (int i = 0; i < M; i ++){
        std::cin >> num;
        if (st.find(num) != st.end())
            std::cout << "1 ";
        else
            std::cout << "0 ";
    }
}